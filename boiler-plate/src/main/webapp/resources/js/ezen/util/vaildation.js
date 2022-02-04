/**
 * @description 유효성 검사 기능 정의
 * @author 박태훈
 * @since 2022-01-25
 */
/**
 * @description 유효성 검사 function
 * @param {HTMLButtonElement} button
 */
function vaildateRequestData(button) {
  const vaildateFor = button.id;
  const dataList = document.querySelectorAll(`[data-vaildate-for="${vaildateFor}"]`);

  try {
    [...dataList].forEach((elem) => {
      let { value } = elem;

      if (
        !value || // falsy(null, undefined, NaN, 0, '', false)확인
        value !== value.trim() // 양 끝 공백 확인
      ) {
        elem.focus();
        throw '입력 값을 확인해주세요';
      }
    });
  } catch (error) {
    console.dir(error);
    error.stack ? toastr.error(error.stack) : toastr.warning(error);
    return false;
  }
  return true;
}

function checkLimitText(tagForCheck, limitTextSize) {
  // 글자 수 제한 및 입력한 글자 수 출력
  // bootstrap의 floating labels 활용
  const floatingLabel = document.createElement('label');
  floatingLabel.setAttribute('for', tagForCheck.id);
  floatingLabel.innerHTML = `<b class="input-text-size">0</b>/${limitTextSize}bytes`;
  tagForCheck.parentElement.appendChild(floatingLabel);

  // 입력 시 값이 바뀌는 부분
  const changedValue = floatingLabel.querySelector('.input-text-size');

  // 글자 수 제한 확인 함수
  function check(e) {
    const { target, key } = e;

    // 입력한 글자 수 확인
    changedValue.innerHTML = target.value.length;

    // 입력 글자 수가 제한 글자 수를 넘어선 경우
    if (target.value.length > limitTextSize) {
      // 삭제중에는 글자수 제한 확인하지 않게 한다.
      if (key === 'Backspace') return;

      toastr.warning('입력 제한을 초과하였습니다.'); // 알림
      tagForCheck.blur(); // focus 제거
      tagForCheck.classList.add('is-invalid'); // 스타일을 위한 클래스 추가
    } else {
      tagForCheck.classList.contains('is-invalid') ? tagForCheck.classList.remove('is-invalid') : ''; // invalid 클래스 삭제
    }
  }

  // 이벤트 정의
  tagForCheck.addEventListener('keyup', check);
  tagForCheck.addEventListener('keydown', check);
  tagForCheck.addEventListener('paste', check);
}

export { vaildateRequestData, checkLimitText };
