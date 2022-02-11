/**
 * @description custom html elements 정의
 * @author 박태훈
 * @since 2022-01-25
 */
'use strict'; // 엄격 모드 실행

import ErrorMessage from './error-message.js';

/**
 * web component 예시
 */
class ExampleWebComponent extends HTMLElement {
  constructor() {
    // 클래스 초기화. 속성이나 하위 노드는 접근할 수는 없다.
    super();
  }
  static get observedAttributes() {
    // 모니터링 할 속성 이름
    // <tag-name example="example"></tag-name>
    return ['example'];
  }
  connectedCallback() {
    // DOM에 추가되었다. 렌더링 등의 처리를 하자.
    this.start();
  }
  disconnectedCallback() {
    // DOM에서 제거되었다. 엘리먼트를 정리하는 일을 하자.
    this.stop();
  }
  attributeChangedCallback(attrName, oldVal, newVal) {
    // 속성이 추가/제거/변경되었다.
    this[attrName] = newVal;
  }
  adoptedCallback(oldDoc, newDoc) {
    // 다른 Document에서 옮겨져 왔음
    // 자주 쓸 일은 없을 것.
  }
  start() {
    // 필요에 따라 메서드를 추가할 수 있다.
    // 이 클래스 인스턴스는 HTMLElement이다.
    // 따라서 `document.querySelector('current-time').start()`로 호출할 수 있다.
    this.stop();
    this._timer = window.setInterval(() => {
      this.innerText = new Date().toLocaleString(this.locale);
    }, 1000);
  }
  stop() {
    // 이 메서드 역시 CurrentTime클래스의 필요에 의해 추가했다.
    if (this._timer) {
      window.clearInterval(this._timer);
      this._timer = null;
    }
  }
}
// <example-web-component> 태그가 ExampleWebComponent 클래스를 사용하도록 한다.
// customElements.define('example-web-component', ExampleWebComponent);

/**
 * 커스텀 select 태그
 */
export class EzenSelect extends HTMLElement {
  constructor() {
    super();
  }

  static get observedAttributes() {
    // 모니터링 할 속성 이름
    return ['name'];
  }

  connectedCallback() {
    // select tag 생성
    this.makeSelectTag();

    // dropdown 생성
    this.makeDropdown();

    // dropdown 클릭 이벤트 추가
    this.setDropdowClickHandler();

    /**
     * dropdown에 변경사항이 있을 경우 해당 변경사항이 select태그에도 적용되어야 한다.
     * 이를 구현하기 위해 mutation observer를 사용한다.
     */
    const observer = new MutationObserver(() => {
      const selectedValue = this.querySelector('.active').dataset.value;
      this.selectProps.tag.value = selectedValue;

      // select의 값이 변경되었을때 실행할 함수
      if (this.change) {
        this.change();
      }
    });

    // 화면에 보이는 select 태그의 내용이 변경될때 observer 실행
    observer.observe(this.dropdownProps.selected, {
      childList: true,
    });
  }

  attributeChangedCallback(attrName, oldVal, newVal) {
    this[attrName] = newVal;
  }

  /**
   * 실제로 controller에 값을 넘기는 역할을 해줄 select태그 생성
   */
  makeSelectTag() {
    // 태그 생성시 부여한 name과 id
    const { name, id } = this;

    // 태그 생성시 함께 생성한 option태그들
    const options = this.querySelectorAll('option');

    // select 태그 생성
    const select = document.createElement('select');
    select.style.display = 'none'; // 보이지 않게 설정
    select.name = name; // name부여
    select.id = id; // id부여

    // 태그 생성시 생성한 option태그를 새로 생성한 select태그 자식으로 이동
    [...options].forEach((option, idx) => {
      select.append(option);
    });

    // 해당 태그에 생성한 select태그 추가
    this.append(select);

    // 생성한 select 태그를 class내부의 다른 function에서 접근할 수 있도록
    // 해당 태그의 property에 추가
    this.selectProps = {
      tag: select,
      options: select.querySelectorAll('option'),
    };

    // 해당 태그의 id, name 삭제
    this.removeAttribute('id');
    this.removeAttribute('name');
  }
  /**
   * 화면에 보일 dropdown 생성
   */
  makeDropdown() {
    const dropdown = document.createElement('div');
    dropdown.classList.add('dropdown'); // style적용을 위한 class 부여

    // html 작성
    dropdown.innerHTML = `
      <a
         class="btn btn-primary dropdown-toggle d-flex justify-content-between align-items-center ezen-dropdown"
         href="#"
         role="button"
         id="ezenDropdown"
         data-bs-toggle="dropdown"
         aria-expanded="false"
       ></a>

       <ul class="dropdown-menu" aria-labelledby="ezenDropdown">
       </ul>
    `;

    // 화면에 보이는 select의 내용을 select 태그의 value로 설정
    const selected = dropdown.querySelector('#ezenDropdown');
    selected.innerHTML = this.selectProps.options[0].innerHTML;

    /**
     * option태그를 대신해서 화면에 보여질 dropdown-item 생성
     *  select태그의 option의 수 만큼 반복문 실행
     *  li태그와 a태그를 생성하고 a태그의 내용을 option태그의 내용으로 설정한 이후
     *  dropdown에 추가
     */
    const dropdownUlTag = dropdown.querySelector('ul');
    [...this.selectProps.options].forEach((option) => {
      const dropdownLiTag = document.createElement('li');

      const dropdownATag = document.createElement('a');
      dropdownATag.href = '#';
      dropdownATag.classList.add('dropdown-item');
      dropdownATag.dataset.value = option.value;
      dropdownATag.innerHTML = option.innerHTML;

      dropdownLiTag.appendChild(dropdownATag);

      dropdownUlTag.appendChild(dropdownLiTag);
    });

    // 해당 태그에 dropdown추가
    this.append(dropdown);

    // 생성한 dropdown을 class내부의 다른 function에서 접근할 수 있도록
    // 해당 태그의 property에 추가
    this.dropdownProps = {
      wrap: dropdown,
      selected: selected,
      options: dropdown.querySelectorAll('ul li a'),
    };
  }

  /**
   * dropdown 클릭시 이벤트 정의
   */
  setDropdowClickHandler() {
    const { selected, options } = this.dropdownProps;

    // option에 해당하는 태그 클릭시 active class를 toggle한다.
    [...options].forEach((option) => {
      option.addEventListener('click', (e) => {
        const { target } = e;

        // active class를 가진 태그가 있다면 active class 제거
        const actived = this.querySelector('.active');
        // const actived = target.closest('ul').querySelector('.active');
        if (actived) actived.classList.remove('active');

        // 현재 클릭한 태그에 active class 추가
        target.classList.add('active');

        // 화면에 보이는 dropdown의 내용을 클릭한 태그의 내용으로 설정
        selected.innerHTML = target.innerHTML;
      });
    });
  }

  /**
   * @description 값 변경시 호출할 이벤트
   * @param {Function} func 실행할 함수
   */
  setChangeHandler(func) {
    this.change = func;
  }

  /**
   * @description 값 변경 함수
   *    data-value가 parameter와 같은 dropdown을 찾아서 해당 요소 클릭
   * @param {*} value
   */
  setValue(value) {
    [...this.dropdownProps.options].forEach((option) => {
      option.dataset.value === value ? option.click() : '';
    });
  }

  reset() {
    this.dropdownProps.options[0].click();
  }
}

/**
 * menu navigaion 태그
 */
export class MenuNavigation extends HTMLElement {
  constructor() {
    super();
  }
  static get observedAttributes() {
    return ['parent', 'child'];
  }
  connectedCallback() {
    // 태그를 만들어서 붙여주는 작업을 한다.
    this.render();

    // head의 title변경
    document.querySelector('head title').innerHTML = this.child;
  }

  attributeChangedCallback(attrName, oldVal, newVal) {
    this[attrName] = newVal;
  }

  render() {
    const wrap = document.createElement('div');
    wrap.classList.add('d-flex');
    wrap.classList.add('justify-content-between');
    wrap.classList.add('align-items-center');

    const title = document.createElement('span');
    title.classList.add('ezen-title');
    title.innerHTML = this.child;

    const navWrap = document.createElement('span');
    navWrap.classList.add('menu-navigation');

    const home = document.createElement('span');
    home.classList.add('menu-navigation-home');

    const parentMenu = document.createElement('span');
    parentMenu.innerHTML = this.parent;

    const childMenu = document.createElement('span');
    childMenu.innerHTML = this.child;

    navWrap.append(home, parentMenu, childMenu);

    wrap.append(title, navWrap);
    this.append(wrap);

    if (window.innerWidth > 1810) this.openSelectedMenu();
  }

  openSelectedMenu() {
    document.querySelector('.ezen-toggle-menu').click();

    const menus = document.querySelectorAll('.offcanvas-body span');
    const menu = [...menus].filter((elem) => elem.innerText.includes(this.child))[0];

    const menuContainer = menu.closest('.collapse');
    const parentMenu = menuContainer.previousElementSibling.firstElementChild;

    parentMenu.click();
    menu.parentElement.focus();
  }
}

export class LimitedTextArea extends HTMLElement {
  constructor() {
    // 클래스 초기화. 속성이나 하위 노드는 접근할 수는 없다.
    super();
  }

  static get observedAttributes() {
    // 모니터링 할 속성 이름
    // <tag-name example="example"></tag-name>
    return ['name', 'height', 'limit'];
  }

  connectedCallback() {
    // DOM에 추가되었다. 렌더링 등의 처리를 하자.
    this.render();
  }

  attributeChangedCallback(attrName, oldVal, newVal) {
    // 속성이 추가/제거/변경되었다.
    this[attrName] = newVal;
  }

  render() {
    const formFloating = document.createElement('div');
    formFloating.classList = 'form-floating';

    const textarea = document.createElement('textarea');
    textarea.classList = 'form-control ezen-input-text mt-2';
    textarea.id = this.id;
    textarea.name = this.name;
    textarea.placeholder = this.name;
    textarea.style.resize = 'none';
    textarea.style.height = this.height;

    const floatingLabel = document.createElement('label');
    floatingLabel.setAttribute('for', textarea.id);
    floatingLabel.innerHTML = `<b>0</b>/${this.limit}bytes`;

    this.removeAttribute('id');
    this.removeAttribute('name');
    this.removeAttribute('height');

    this.observing = floatingLabel.firstElementChild;
    this.textarea = textarea;

    textarea.addEventListener('keyup', (e) => this.checkLimit(e));
    textarea.addEventListener('keydown', (e) => this.checkLimit(e));
    textarea.addEventListener('paste', (e) => this.checkLimit(e));

    formFloating.append(textarea, floatingLabel);
    this.append(formFloating);
  }

  checkLimit(e) {
    const { target, key } = e;

    // 입력한 글자 수 확인
    this.observing.textContent = target.value.length;

    // 입력 글자 수가 제한 글자 수를 넘어선 경우
    if (target.value.length > Number(this.limit)) {
      // 삭제중에는 글자수 제한 확인하지 않게 한다.
      if (key === 'Backspace') return;

      toastr.warning(ErrorMessage.OUT_OF_TEXT_LIMIT); // 알림
      target.blur(); // focus 제거
      target.classList.add('is-invalid'); // 스타일을 위한 클래스 추가
    } else {
      target.classList.contains('is-invalid') ? this.textarea.classList.remove('is-invalid') : ''; // invalid 클래스 삭제
    }
  }

  setValue(value) {
    this.textarea.value = value;
    this.checkLimit({ target: this.textarea });
  }

  reset() {
    this.textarea.value = '';
    this.observing.textContent = 0;
  }
}
