const listColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeIdNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeIdDc', hidden: true },
  { header: '사용여부', name: 'useAt', hidden: true },
];
const detailColumn = [
  { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
  { header: '코드명', name: 'codeIdNm', align: 'center', sortable: true },
  { header: '코드설명', name: 'codeIdDc' },
  { header: '사용여부', name: 'useAt' },
];

export { listColumn, detailColumn };
