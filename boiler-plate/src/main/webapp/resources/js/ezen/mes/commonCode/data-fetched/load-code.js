/**
 * @description 공통관리 페이지에서 코드 정보 출력하는 기능 구현
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

import { getFetch } from '../../../util/defined-fetches.js';
import { EzenSelect } from '../../../util/web-components.js';
import { CommonCodeUrl } from '../../../util/request-urls.js';

/**
 * @description 코드 정보 출력 form
 * @param {HTMLFormElement} form
 * @param {Object} row
 *    그리드에서 클릭한 row
 */
function loadCodeData(form, row) {
  /**
   * form태그를 비구조화 할 시
   *  name 또는 id를 키로 element(input, select, checkbox, radio, button)를 찾아온다.
   */
  const { codeId, codeIdNm, codeDesc, useYn } = form;

  [codeId, codeIdNm, codeDesc, useYn].forEach((elem) => {
    const { name } = elem;

    switch (name) {
      case 'useYn': {
        elem.closest('ezen-select').setValue(row[name]); // custom select의 값 변경 함수 호출
        break;
      }
      case 'codeId': {
        elem.setAttribute('readonly', 'readonly'); // readonly 속성 부여
        // ** default가 실행 될 수 있도록 break를 걸지 않음
      }
      // value 초기화
      default: {
        elem.value = row[name];
      }
    }
  });
}

/**
 * @description 하위 코드 목록 출력
 * @param {TuiGrid} targetGrid 목록을 작성할 그리드
 * @param {Object} parentRow 검색 조건에 사용할 데이터를 담고 있는 그리드 row
 */
async function loadChildrenCodes(targetGrid, parentRow) {
  const { codeId } = parentRow;
  setGridData(targetGrid, `${CommonCodeUrl.CHILD_CODE}?codeId=${codeId}`);
}

/**
 * @description 그룹 코드 및 그룹 코드를 조건으로 불러온 코드 목록 출력
 * @param {TuiGrid} grid 목록을 작성할 그리드
 */
async function loadCodeListByGroup(grid) {
  const data = await getFetch(CommonCodeUrl.CODE_GROUP); // fetch로 API요청

  /**
   * select web-component 적용 시
   *  define하기 전에 tag에 대한 DOM 작업을 끝마쳐야 제대로 적용된다.
   */
  await setOptionsForSelect(data); // 요청 받아온 데이터로 option태그 생성 및 select태그에 추가
  const loadedEzenSelect = await setEzenSelect(); // custom select 태그 define

  /**
   * API를 요청할 때 parameter로 넘어가는 값이 동적일 수 있도록 url을 함수로 정의한다.
   */
  setGridData(grid, bindDynamicUrl()); // 그리드에 데이터 작성
  loadedEzenSelect.setChangeHandler(() => setGridData(grid, bindDynamicUrl())); // custom select 값 변경 시 실행
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
    option.innerHTML = result.codeIdNm;
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

/**
 * @description select 값이 변함에 따라 동적으로 url 생성
 * @returns url
 */
function bindDynamicUrl() {
  return `${CommonCodeUrl.COMMON_CODE}?codeGroup=${document.querySelector('#codeGroup').value}`;
}

/**
 * @description API 요청을 통해 받아온 데이터로 그리드를 작성한다.
 * @param {TuiGrid} targetGrid
 * @param {String} url
 */
async function setGridData(targetGrid, url) {
  const data = await getFetch(url);
  targetGrid.resetData(data);
}

export { loadCodeListByGroup, loadChildrenCodes, loadCodeData };
