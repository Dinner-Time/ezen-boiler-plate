import { listColumn, detailColumn } from './columns.js';

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
