import { EzenSelect } from '../../util/web-components.js';
customElements.define('ezen-select', EzenSelect);

const grid = new tui.Grid({
  el: document.querySelector('#grid'),
  columns: [
    { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
    { header: '코드ID명', name: 'codeIdNm', align: 'center', sortable: true },
    { header: '코드설명', name: 'codeIdDc', hidden: true },
    { header: '사용여부', name: 'useAt', hidden: true },
  ],
  data: [
    {
      codeId: 'MES001',
      codeIdNm: 'MES001',
    },
  ],
  bodyHeight: 580,
  rowHeight: 30,
});
const detailGrid = new tui.Grid({
  el: document.querySelector('#detailGrid'),
  columns: [
    { header: '코드ID', name: 'codeId', width: 200, align: 'center', sortable: true },
    { header: '코드ID명', name: 'codeIdNm', align: 'center', sortable: true },
    { header: '코드설명', name: 'codeIdDc' },
    { header: '사용여부', name: 'useAt' },
  ],
  data: [
    {
      codeId: 'MES001',
      codeIdNm: 'MES001',
    },
  ],
  bodyHeight: 545,
  rowHeight: 30,
});
