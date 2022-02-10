import { getFetch } from '../../../../util/defined-fetches.js';

async function loadListOfMenu() {
  const data = await getFetch('/manage/menu/all');

  const listOfMasterMenus = document.querySelectorAll('[data-bs-parent="#menuManageAccordion"] .list-group-flush');

  [...listOfMasterMenus].forEach((menu) => {
    while (menu.hasChildNodes()) {
      menu.removeChild(menu.firstChild);
    }
  });

  data.forEach((menu) => {
    const masterMenu = document.querySelector(`#menu-manage-${menu.masterMenu} .list-group-flush`);

    const listItem = document.createElement('button');
    listItem.classList = 'btn list-group-item list-group-item-action';
    listItem.dataset.menuNo = menu.menuNo;
    listItem.innerText = menu.menuNm;

    masterMenu.append(listItem);
  });

  [...listOfMasterMenus].forEach((menu) => {
    const lastListItem = document.createElement('button');
    lastListItem.classList = 'btn list-group-item list-group-item-action last-item';
    menu.append(lastListItem);
  });
}

async function loadMenuData(elem, form) {
  const { masterMenu, menuNo, menuNm, menuOrder, menuDesc, redirectUrl } = form;

  masterMenu.value = await findMasterMenuNo(elem);
  menuNo.value = await findChildMenuNo(elem, masterMenu.value);

  const data = await getFetch(`/manage/menu/${menuNo.value}`);

  [menuNm, menuOrder, menuDesc, redirectUrl].forEach((elem) => {
    const { name } = elem;
    elem.value = data[name];
  });

  const delBtn = document.querySelector('#deleteBtn');
  if (menuNm.value) {
    delBtn.style.display = 'block';
  } else {
    delBtn.style.display = 'none';
  }
}

async function findMasterMenuNo(elem) {
  const menuNo = elem.closest('.accordion-collapse').dataset.masterMenu;
  return menuNo;
}

async function findChildMenuNo(elem, masterMenuNo) {
  const childMenuNo = elem.dataset.menuNo;
  // 메뉴 추가가 아닌경우
  if (childMenuNo || childMenuNo === 0) return childMenuNo;

  // 같은 레벨에 메뉴가 있을 경우
  const lastMenu = elem.previousElementSibling;

  if (lastMenu) return Number(lastMenu.dataset.menuNo) + 1;

  // 같은 레벨에 메뉴가 없을 경우
  return Number(masterMenuNo) + 1;
}

export { loadMenuData, loadListOfMenu };
