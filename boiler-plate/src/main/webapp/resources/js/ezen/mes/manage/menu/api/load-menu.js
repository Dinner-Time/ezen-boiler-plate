import { getFetch } from '../../../../util/defined-fetches.js';
import { form, delBtn } from '../DOM/reusable-DOMs.js';

async function loadListOfMenu() {
  const data = await getFetch('/manage/menu/all');

  const menuContainerList = document.querySelectorAll('[data-bs-parent="#menuManageAccordion"] .list-group-flush');

  // 자식 tag clear
  initContainer(menuContainerList);

  // 받아온 data로 자식태그 생성 및 추가
  const listItemList = setChildMenuList(data);

  // 메뉴 추가용 빈 메뉴 생성 및 추가
  const lastListItemList = setAddMenu(menuContainerList);

  // 클릭 이벤트 추가
  [...listItemList, ...lastListItemList].forEach((item) => {
    item.addEventListener('click', clickEventHandler);
  });
}

/**
 * 자식 tag clear
 *
 * @param {*} containerList
 */
function initContainer(containerList) {
  [...containerList].forEach((container) => {
    while (container.hasChildNodes()) {
      container.removeChild(container.firstChild);
    }
  });
}

/**
 *
 *
 * @param {*} data
 */
function setChildMenuList(data) {
  const listItemList = [];

  data.forEach((menu) => {
    const container = document.querySelector(`#menu-manage-${menu.masterMenu} .list-group-flush`);

    const listItem = document.createElement('button');
    listItem.classList = 'btn list-group-item list-group-item-action';
    listItem.dataset.menuNo = menu.menuNo;
    listItem.innerText = menu.menuNm;

    listItemList.push(listItem);
    container.append(listItem);
  });

  return listItemList;
}

/**
 *
 *
 * @param {*} containerList
 */
function setAddMenu(containerList) {
  const listItemList = [];

  [...containerList].forEach((menu) => {
    const lastListItem = document.createElement('button');
    lastListItem.classList = 'btn list-group-item list-group-item-action last-item';

    listItemList.push(lastListItem);
    menu.append(lastListItem);
  });

  return listItemList;
}

/**
 *
 *
 * @param {*} e
 */
function clickEventHandler(e) {
  const { target } = e;

  const actived = document.querySelector('#menuManageAccordion .list-group-item.active');
  if (actived) actived.classList.remove('active');

  target.classList.add('active');

  loadMenuData(target);
}

async function loadMenuData(elem) {
  const { masterMenu, menuNo, menuNm, menuOrder, menuDesc, redirectUrl } = form;

  masterMenu.value = await findMasterMenuNo(elem);
  menuNo.value = await findChildMenuNo(elem, masterMenu.value);

  const data = await getFetch(`/manage/menu/${menuNo.value}`);

  [menuNm, menuOrder, menuDesc, redirectUrl].forEach((elem) => {
    const { name } = elem;
    elem.value = data[name];
    if (elem === menuDesc) menuDesc.closest('limited-textarea').setValue(data[name]);
  });

  !menuNm.value ? (delBtn.style.display = 'none') : (delBtn.style.display = 'block');
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

export { loadListOfMenu };
