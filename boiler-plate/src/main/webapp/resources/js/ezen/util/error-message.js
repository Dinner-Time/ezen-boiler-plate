/**
 * @description 에러 메세지 정의
 * @author 박태훈
 * @since 2022-02-04
 */
const error = {
  UNKNOWN: '알 수 없는 에러가 발생했습니다.',
  CHECK_INPUT: '비어있거나 잘못된 값이 있습니다.',
  INVALID: '저장할 수 없는 값이 있습니다.',
  OUT_OF_TEXT_LIMIT: '입력 제한을 초과하였습니다.',
  SAVE_ERROR: '저장에 실패하였습니다.',

  /**
   * 발생한 에러 log
   *    해당 함수에서 정의된 에러는 일반 String이다.
   *    해당 함수에서 정의하지 않은 에러는 Error객체이다.
   *    => Error객체는 stack property를 가지므로 stack property의 존재 유무로
   *       사용자에게 보여지는 메세지를 정의한다.
   */
  toastrErrorMessage: (error) => {
    console.dir(error);
    error.stack ? toastr.error(ErrorMessage.UNKNOWN) : toastr.warning(error);
  },
};

export default error;
