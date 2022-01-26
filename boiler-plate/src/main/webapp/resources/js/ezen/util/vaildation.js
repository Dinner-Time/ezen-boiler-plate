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

export { vaildateRequestData };
