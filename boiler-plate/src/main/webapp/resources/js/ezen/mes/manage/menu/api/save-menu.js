import { postFetch, deleteFetch } from '../../../../util/defined-fetches.js';

async function saveMenuData(data) {
  const result = await postFetch('/manage/menu/save', data);
  console.log(result);
  return result;
}

async function deleteMenu(menuNo) {
  const result = await deleteFetch(`/manage/menu/${menuNo}`);
  console.log(result);
  return result;
}

export { saveMenuData, deleteMenu };
