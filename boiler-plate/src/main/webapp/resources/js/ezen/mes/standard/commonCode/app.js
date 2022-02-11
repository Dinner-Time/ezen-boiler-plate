/**
 * @description 공통관리 페이지 구현
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

import { setValidationStyle } from '../../../util/vaildation.js';
import { keyUpEnterHandler } from '../../../util/event-handlers.js';
import { LimitedTextArea } from '../../../util/web-components.js';

import { masterGrid, detailGrid, masterGridClickHandler } from './grid/grid.js';
import { loadGroupCodeList } from './api/load-code.js';
import { saveChildrenCode, saveMasterCodeInfo } from './api/save-code.js';
import { searchByCodeNm } from './search/search.js';
import { initializePage } from './init-page/init-page.js';

/**
 *
 *
 * DOM 선택
 */
const codeDataForm = document.querySelector('#codeDataForm'); // 코드 정보 form
const saveBtn = document.querySelector('#saveBtn'); // 저장 버튼
const newBtn = document.querySelector('#newBtn'); // 신규 버튼
const searchCodeNmKeyword = document.querySelector('#searchCodeNmKeyword'); // 검색 keyword
const searchCodeNmBtn = document.querySelector('#searchCodeNmBtn'); // 검색 버튼
const addDetailCode = document.querySelector('#addDetailCode'); // 코드 추가 버튼

/**
 *
 *
 * 화면 로드 이후 바로 호출하는 함수
 */
setValidationStyle(saveBtn.id); // 유효성 검사가 필요한 태그 style
customElements.define('limited-textarea', LimitedTextArea);
loadGroupCodeList(masterGrid); // 그룹 코드 load 및 선택한 그룹 코드에 해당하는 코드 목록 load

/**
 *
 *
 * 코드 명 검색
 */
searchCodeNmBtn.addEventListener('click', () => searchByCodeNm(masterGrid, searchCodeNmKeyword.value));
searchCodeNmKeyword.addEventListener('keyup', (e) => keyUpEnterHandler(e, searchCodeNmBtn));

/**
 *
 *
 * 코드 추가
 */
addDetailCode.addEventListener('click', () => {
  if (!masterGrid.selectedRow) {
    toastr.warning('코드목록에서 선택한 코드가 없습니다.');
    return;
  }
  detailGrid.appendRow({ isEnabled: 1 });
});

/**
 *
 *
 * 저장
 */
saveBtn.addEventListener('click', (e) => {
  // 현재 탭에 따라 서로 다른 function 호출
  const currentTabId = document.querySelector('.tab-pane.show.active').id;
  console.log(currentTabId);
  currentTabId === 'detail-code' ? saveChildrenCode(detailGrid, masterGrid.selectedRow.codeId) : saveMasterCodeInfo(e, codeDataForm);
});

/**
 *
 *
 * 화면 초기화
 */
newBtn.addEventListener('click', () => initializePage(masterGrid, detailGrid, codeDataForm, searchCodeNmKeyword));

/**
 *
 *
 * 코드 목록 그리드 클릭 이벤트 정의
 */
masterGrid.on('click', masterGridClickHandler);
