import UtilGrid from '../../../../util/extended-grid.js';

const columns = [{ header: '메뉴명', name: 'menuNm', width: 200, align: 'center', sortable: true }];

const grid = new UtilGrid({
  el: document.querySelector('#master'),
  columns: columns,
  data: [],
  bodyHeight: 580,
  rowHeight: 30,
});

export default grid;
