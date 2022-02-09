/**
 * @description 공통관리 페이지에서 코드 정보 출력하는 기능 구현
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

import { getFetch } from '../../../../util/defined-fetches.js';
import { EzenSelect } from '../../../../util/web-components.js';

import URL from './url.js';

/**
 *
 *
 * 그룹 코드 load
 * @param {*} grid
 */
async function loadGroupCodeList(grid) {
  const data = await getFetch(URL.CODE_GROUP_LIST); // fetch로 API요청

  /**
   * select web-component 적용 시
   *  define하기 전에 tag에 대한 DOM 작업을 끝마쳐야 제대로 적용된다.
   */
  await setOptionsForSelect(data); // 요청 받아온 데이터로 option태그 생성 및 select태그에 추가
  const loadedEzenSelect = await setEzenSelect(); // custom select 태그 define

  /**
   * 코드 목록 load 정의
   */
  loadMasterCodeList(grid); // 그리드에 데이터 작성
  loadedEzenSelect.setChangeHandler(() => loadMasterCodeList(grid)); // custom select 값 변경 시 실행
}

// 코드 목록 load
async function loadMasterCodeList(grid) {
  // API를 요청할 때 parameter로 넘어가는 값이 동적일 수 있도록 url을 함수로 정의한다.
  const url = `${URL.MASTER_CODE_LIST}?codeGroup=${document.querySelector('#codeGroup').value}`;
  await setGridData(grid, url);

  // 미 사용 row에 backgourd 부여
  const deprecatedRows = grid.getData().filter((row) => row.isEnabled === 0);
  deprecatedRows.forEach(({ rowKey }) => {
    grid.addRowClassName(rowKey, 'deprecated-grid-row');
  });
}

/**
 * @description 하위 코드 목록 load
 * @param {TuiGrid} targetGrid 목록을 작성할 그리드
 * @param {Object} parentRow 검색 조건에 사용할 데이터를 담고 있는 그리드 row
 */
async function loadChildrenCodeList(targetGrid, parentRow) {
  const { codeId } = parentRow;
  await setGridData(targetGrid, `${URL.DETAIL_CODE_LIST}?codeId=${codeId}`);

  targetGrid.getData().forEach(({ rowKey }) => {
    targetGrid.disableCell(rowKey, 'codeId');
  });
}

/**
 * @description API 요청을 통해 받아온 데이터로 그리드를 작성한다.
 * @param {TuiGrid} targetGrid
 * @param {String} url
 */
async function setGridData(targetGrid, url) {
  const data = await getFetch(url);
  targetGrid.saveData(data);
}

/**
 * @description option태그 생성 및 select태그에 추가
 * @param {Array} data API를 요청해서 받아온 데이터
 */
async function setOptionsForSelect(data) {
  const ezenSelect = document.querySelector('ezen-select');

  data.forEach((result) => {
    const option = document.createElement('option');
    option.value = result.codeId;
    option.innerHTML = result.codeNm;
    ezenSelect.appendChild(option);
  });
}

/**
 * @description custom select가 적용될 수 있도록 define한다.
 * @returns HTML-EzenSelect-Element
 */
async function setEzenSelect() {
  customElements.define('ezen-select', EzenSelect);
  return document.querySelector('ezen-select');
}

export { loadGroupCodeList, loadChildrenCodeList };
