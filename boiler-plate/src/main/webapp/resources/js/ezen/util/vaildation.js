/**
 * @description 유효성 검사 기능 정의
 * @author 박태훈
 * @since 2022-01-25
 */
'use strict'; // 엄격 모드 실행

/**
 *
 *
 * @description 유효성 검사를 진행할 input과 연결된 label styling
 *
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
 *
 *
 * @description 유효성 검사 function
 *    유효성 검사를 진행할 태그들에 data-vaildate-for를 정의한다.
 *    data-vaildate-for가 같은 태그들을 묶어서 유효성 검사를 진행한다.
 *
 *    is-invalid class 포함 여부도 확인한다.
 * @param {String} vaildateFor
 *    유효성 검사를 진행할 태그에 정의된 data-validate-for 값
 *
 * @returns {HTMLElement}
 *    유효성 검사를 통과하지 못한 HTMLElement
 *    모든 태그가 유효할 경우 null 반환
 */
function vaildateRequestData(vaildateFor) {
  const dataList = document.querySelectorAll(`[data-vaildate-for="${vaildateFor}"]`); // 유효성 검사를 진행할 태그 선택
  const isInvalid = document.querySelectorAll('.is-invalid'); // is-invalid 선택

  // 예외 처리 진행
  try {
    // isInvalid 확인
    if (isInvalid.length > 0) {
      isInvalid[0].focus();
      throw isInvalid[0];
    }

    // data-vaildate-for 확인
    [...dataList].forEach((elem) => {
      let { value } = elem; // 비구조화(value)

      const falsyWithOutZero = value || value === 0;

      if (
        !falsyWithOutZero || // 0을 제외한 falsy(null, undefined, NaN, '', false)확인
        value !== value.trim() // 양 끝 공백 포함 확인
      ) {
        elem.focus();
        throw elem;
      }
    });
  } catch (error) {
    return error;
  }
  return null;
}

export { setValidationStyle, vaildateRequestData };
