/**
 * @description 공통관리 페이지에서 사용되는 그리드 정의
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

import { loadChildrenCodeList } from '../api/load-code.js';
import UtilGrid from '../../../../util/extended-grid.js';

// 그리드 칼럼 정의
const listColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeDesc', hidden: true },
  { header: '사용여부', name: 'isEnabled', hidden: true },
];
const detailColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', editor: 'text', sortable: true },
  { header: '코드명', name: 'codeNm', width: 200, align: 'center', editor: 'text', sortable: true },
  { header: '코드설명', name: 'codeDesc', editor: 'text' },
  { header: '사용여부', name: 'isEnabled', width: 70, align: 'center' },
];

// 그리드 생성
const masterGrid = new UtilGrid({
  el: document.querySelector('#grid'),
  columns: listColumn,
  data: [],
  bodyHeight: 580,
  rowHeight: 30,
});
const detailGrid = new UtilGrid({
  el: document.querySelector('#detailGrid'),
  columns: detailColumn,
  data: [],
  bodyHeight: 545,
  rowHeight: 30,
  editingEvent: 'click',
});

function masterGridClickHandler(e) {
  const { targetType, instance, rowKey } = e; // 필요한 properties 비구조화

  if (targetType !== 'cell') return; // 유효하지 않은 row 클릭시 종료

  const row = instance.getRow(rowKey); // 현재 클릭한 row
  instance.saveSelectedRow(row); // 그리드에 row 저장

  loadChildrenCodeList(detailGrid, row); // 하위 코드 그리드에 데이터 작성
  selectOneFromMasterCode(codeDataForm, row); // 코드 정보 탭에 데이터 작성
}

function selectOneFromMasterCode(form, row) {
  /**
   * form태그를 비구조화 할 시
   *  name 또는 id를 키로 element(input, select, checkbox, radio, button)를 찾아온다.
   */
  const { codeId, codeNm, codeDesc, isEnabled } = form;

  [codeId, codeNm, codeDesc, isEnabled].forEach((elem) => {
    const { name } = elem;

    switch (name) {
      case 'isEnabled': {
        elem.closest('ezen-select').setValue(String(row[name])); // custom select의 값 변경 함수 호출
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

export { masterGrid, detailGrid, masterGridClickHandler };
