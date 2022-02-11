import { postFetch, deleteFetch } from '../../../../util/defined-fetches.js';
import { formToJson } from '../../../../util/form-util.js';
import ErrorMessage from '../../../../util/error-message.js';
import { vaildateRequestData } from '../../../../util/vaildation.js';

import { initializePage } from '../initialize/initialize.js';
import { loadListOfMenu } from './load-menu.js';
import { form } from '../DOM/reusable-DOMs.js';

async function saveMenuData() {
  const vaildation = vaildateRequestData('saveMenu');
  if (vaildation) {
    toastr.warning(ErrorMessage.REQUIRED_UNFULFILLED);
    return;
  }

  const result = await postFetch('/manage/menu/save', formToJson(form));
  apiCallback(result, 'save');
}

async function deleteMenu() {
  const result = await deleteFetch(`/manage/menu/${form.menuNo.value}`);
  apiCallback(result, 'delete');
}

function apiCallback(result, type) {
  if (result === 0) {
    toastr.warning(type === 'save' ? ErrorMessage.SAVE_ERROR : ErrorMessage.DELETE_ERROR);
    return;
  }
  toastr.success(type === 'save' ? ErrorMessage.SAVE_SUCCESS : ErrorMessage.DELETE_SUCCESS);
  initializePage();
  loadListOfMenu();
}

export { saveMenuData, deleteMenu };
