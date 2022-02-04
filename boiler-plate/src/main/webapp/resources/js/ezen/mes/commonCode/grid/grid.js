/**
 * @description 공통관리 페이지에서 사용되는 그리드 정의
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

// 그리드 칼럼 정의
const listColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeIdNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeDesc', hidden: true },
  { header: '사용여부', name: 'useYn', hidden: true },
];
const detailColumn = [
  { header: 'No', name: 'codeNo', width: 50, align: 'center' },
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeIdNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeIdDc' },
  { header: '사용여부', name: 'useAt' },
];

// 그리드 생성
const grid = new tui.Grid({
  el: document.querySelector('#grid'),
  columns: listColumn,
  data: [],
  bodyHeight: 580,
  rowHeight: 30,
});
const detailGrid = new tui.Grid({
  el: document.querySelector('#detailGrid'),
  columns: detailColumn,
  data: [],
  bodyHeight: 545,
  rowHeight: 30,
});

export { grid, detailGrid };
