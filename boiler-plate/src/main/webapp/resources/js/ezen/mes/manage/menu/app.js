import { setValidationStyle } from '../../../util/vaildation.js';
import { LimitedTextArea } from '../../../util/web-components.js';

import { loadListOfMenu } from './api/load-menu.js';
import { saveMenuData, deleteMenu } from './api/save-menu.js';
import { initializePage } from './initialize/initialize.js';
import { newBtn, delBtn, saveBtn } from './DOM/reusable-DOMs.js';

/**
 *
 * 화면 로드 시 실행
 */
loadListOfMenu();
setValidationStyle('saveMenu'); // 유효성 검사가 필요한 태그 style
customElements.define('limited-textarea', LimitedTextArea); // limited-textarea tag render

/**
 *
 * Add Event Listener
 */
newBtn.addEventListener('click', initializePage);
saveBtn.addEventListener('click', saveMenuData);
delBtn.addEventListener('click', deleteMenu);
