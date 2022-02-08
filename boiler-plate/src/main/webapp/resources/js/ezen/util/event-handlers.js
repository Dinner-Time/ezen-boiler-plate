/**
 * @description input에서 enter키 입력시 실행 함수
 * @param {Event} 이벤트 변수의 target
 * @param {HTMLButtonElement} 버튼
 */
function keyUpEnterHandler({ key }, button) {
  if (key !== 'Enter') return;
  button.click();
}

export { keyUpEnterHandler };
