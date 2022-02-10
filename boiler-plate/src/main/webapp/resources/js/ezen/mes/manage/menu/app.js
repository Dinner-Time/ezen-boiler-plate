import { setValidationStyle, checkLimitText } from '../../../util/vaildation.js';

import { loadMenuData, loadListOfMenu } from './api/load-menu.js';
import { saveMenuData, deleteMenu } from './api/save-menu.js';
import { formToJson } from '../../../util/form-util.js';

loadListOfMenu().then(() => {
  const listItems = document.querySelectorAll('#menuManageAccordion .list-group-item');
  const meunManageForm = document.querySelector('#meunManageForm');

  [...listItems].forEach((item) => {
    item.addEventListener('click', (e) => {
      const { target } = e;
      const actived = document.querySelector('#menuManageAccordion .list-group-item.active');
      if (actived) actived.classList.remove('active');

      target.classList.add('active');

      loadMenuData(target, meunManageForm);
    });
  });
});

const delBtn = document.querySelector('#deleteBtn');
delBtn.addEventListener('click', () => {
  deleteMenu(meunManageForm.menuNo.value).then((data) => {
    if (data === 0) return;

    newBtn.click();
    loadListOfMenu();
  });
});

setValidationStyle('saveMenu'); // 유효성 검사가 필요한 태그 style
checkLimitText(meunManageForm.menuDesc, 255); // 글자 수 제한 style 및 기능

const newBtn = document.querySelector('#newBtn');
const saveBtn = document.querySelector('#saveBtn');
saveBtn.addEventListener('click', () => {
  saveMenuData(formToJson(meunManageForm))
    .then((data) => {
      if (data === 1) {
        newBtn.click();
        loadListOfMenu();
      }
    })
    .catch((err) => console.log(err));
});

newBtn.addEventListener('click', () => {
  meunManageForm.reset();

  const actived = document.querySelector('#menuManageAccordion .list-group-item.active');
  if (actived) actived.classList.remove('active');

  const expanded = document.querySelector('#menuManageAccordion button[aria-expanded="true"]');
  if (expanded) expanded.click();

  const delBtn = document.querySelector('#deleteBtn');
  delBtn.style.display = 'none';
});
// 하위 메뉴
