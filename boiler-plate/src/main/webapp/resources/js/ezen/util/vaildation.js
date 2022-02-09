/**
 * @description 유효성 검사 기능 정의
 * @author 박태훈
 * @since 2022-01-25
 */
'use strict'; // 엄격 모드 실행

import ErrorMessage from './error-message.js';

/**
 * @description 유효성 검사를 진행할 input과 연결된 label styling
 * @param {String} vaildateFor
 *    유효성 검사를 진행할 태그에 정의된 data-validate-for 값
 *    해당 parameter에 값을 주지 않았을 경우
 *    data-validate-for가 정의된 input과 연결된 모든 label에 스타일 부여
 */
function setValidationStyle(vaildateFor = null) {
  const requiredData = !vaildateFor
    ? document.querySelectorAll('[data-vaildate-for]')
    : document.querySelectorAll(`[data-vaildate-for="${vaildateFor}"]`);

  // 선택된 label들에 style이 적용된 class 부여
  [...requiredData].forEach((elem) => document.querySelector(`label[for="${elem.id}"]`).classList.add('ezen-required'));
}

/**
 * @description 유효성 검사 function
 *    유효성 검사를 진행할 태그들에 data-vaildate-for를 정의한다.
 *    data-vaildate-for가 같은 태그들을 묶어서 유효성 검사를 진행한다.
 *
 *    is-invalid class 포함 여부도 확인한다.
 * @param {String} vaildateFor
 *    유효성 검사를 진행할 태그에 정의된 data-validate-for 값
 */
function vaildateRequestData(vaildateFor) {
  // data-vaildate-for에 parameter가 정의된 태그 모두 선택
  const dataList = document.querySelectorAll(`[data-vaildate-for="${vaildateFor}"]`);

  const isInvalid = document.querySelectorAll('.is-invalid'); // is-invalid 선택

  // 예외 처리 진행
  try {
    // isInvalid 확인
    if (isInvalid.length > 0) {
      isInvalid[0].focus();
      throw ErrorMessage.INVALID;
    }

    // data-vaildate-for 확인
    [...dataList].forEach((elem) => {
      let { value } = elem; // 비구조화(value)

      const falsyWithOutZero = value || String(value) === '0';

      if (
        !falsyWithOutZero || // 0을 제외한 falsy(null, undefined, NaN, '', false)확인
        value !== value.trim() // 양 끝 공백 포함 확인
      ) {
        elem.focus();
        throw ErrorMessage.CHECK_INPUT;
      }
    });
  } catch (error) {
    ErrorMessage.toastrErrorMessage(error);
    return false;
  }
  return true;
}

/**
 * @description 글자 수 제한 기능 및 style
 *    bootstrap의 floating labels 활용
 *    사용자에게 현재 입력한 글자 수 및 제한 글자 수를 보여주고
 *    입력 글자 수가 제한 글자 수를 넘어서는 경우 에러 발생 처리
 * @param {HTMLElement} tagForCheck
 *    input, textarea
 * @param {Number} limitTextSize
 *    최대 입력 가능한 글자 수
 */
function checkLimitText(tagForCheck, limitTextSize) {
  // 글자 수 제한 및 입력한 글자 수 출력
  const floatingLabel = document.createElement('label');
  floatingLabel.setAttribute('for', tagForCheck.id);
  floatingLabel.innerHTML = `<b class="input-text-size">0</b>/${limitTextSize}bytes`;
  tagForCheck.parentElement.appendChild(floatingLabel);

  // 입력 시 값이 바뀌는 부분 선택
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

      toastr.warning(ErrorMessage.OUT_OF_TEXT_LIMIT); // 알림
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

export { setValidationStyle, vaildateRequestData, checkLimitText };
