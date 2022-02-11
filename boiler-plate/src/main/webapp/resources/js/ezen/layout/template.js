/**
 * @description 화면 상단의 네비게이션 구현
 * @author 박태훈
 * @since 2022-02-04
 */
import { MenuNavigation } from '../util/web-components.js';

customElements.define('menu-navigation', MenuNavigation);

// input number에 e, +, - 입력 막기
const inputNumbers = document.querySelectorAll('input[type="number"]');
[...inputNumbers].forEach((input) => {
  input.onkeydown = inputHandler;
});

// javascript 로 추가되는 input에도 적용하기 위한 observer
const observer = new MutationObserver((entries) => {
  entries.forEach((entry) => {
    entry.addedNodes.forEach((elem) => {
      if (elem.tagName === 'INPUT' && elem.type === 'number') elem.onkeydown = inputHandler;
    });
  });
});
observer.observe(document.body, {
  childList: true,
});

function inputHandler(e) {
  const { key } = e;

  return !(
    key === 'e' || //
    key === 'E' || //
    key === '-' || //
    key === '+'
  );
}
