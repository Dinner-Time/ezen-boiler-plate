import { EzenSelect } from '../../util/web-components.js';
import { vaildateRequestData, checkLimitText } from '../../util/vaildation.js';
import { grid, detailGrid } from './grid/grid.js';

/**
 * select web-component 적용 시
 *  define하기 전에 tag에 대한 DOM 작업을 끝마쳐야 제대로 적용된다.
 */
const ezenSelect = document.querySelector('ezen-select');
for (let i = 0; i < 4; i++) {
  const option = document.createElement('option');
  option.value = i + 1;
  option.innerHTML = `test${i + 1}`;

  ezenSelect.appendChild(option);
}
customElements.define('ezen-select', EzenSelect);

// 글자 수 제한
checkLimitText(document.querySelector('textarea'), 60);
