/**
 * @description 공통관리 페이지에서 사용되는 그리드 정의
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

import UtilGrid from '../../../util/extened-grid.js';

// 그리드 칼럼 정의
const listColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeDesc', hidden: true },
  { header: '사용여부', name: 'isEnabled', hidden: true },
];
const detailColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeDesc' },
  { header: '사용여부', name: 'isEnabled' },
];

// 그리드 생성
const grid = new UtilGrid({
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
});

export { grid, detailGrid };
