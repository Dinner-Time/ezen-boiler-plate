/**
 * @description 로그인 페이지 메인 javscript
 * @author 박태훈
 * @since 2022-01-25
 */
import { vaildateRequestData } from '../util/vaildation.js';
import RequestMethod from '../util/request-method.js';
import Cookie from '../util/cookie.js';
import { getDate } from '../util/date.js';
import { keyUpEnterHandler } from '../util/event-handlers.js';

/**
 * 로그인 실패 시 처리
 */
loginFailureHandler(document.querySelector('#checkError').dataset.error);

/**
 * DOM 선택
 */
const form = document.querySelector('#loginForm'); // 로그인 form 선택
const { loginBtn, userId, password } = form; // 비구조화(로그인 버튼, 아이디 input, 비밀번호 input)

/**
 * 아이디 저장 여부 확인
 */
if (Cookie.getCookie(`ezen_saveId`)) {
  form.isSaveId.checked = true;
  form.userId.value = Cookie.getCookie(`ezen_saveId`);
}

/**
 * 로그인 버튼 클릭 이벤트 정의
 */
loginBtn.addEventListener('click', loginClickHandler);
// 아이디, 비밀번호 입력 칸에서 enter키 입력시 로그인 실행
userId.addEventListener('keyup', (e) => keyUpEnterHandler(e, loginBtn));
password.addEventListener('keyup', (e) => keyUpEnterHandler(e, loginBtn));

// ============================== function 정의 ==============================
/**
 * @description 로그인 버튼 클릭시 실행할 function
 * @param {Event} 이벤트 변수의 target
 */
function loginClickHandler({ target }) {
  // 유효성 검사 실행
  const vaildation = vaildateRequestData(target.id);
  if (vaildation) {
    vaildation.name === 'userId' ? toastr.warning('아이디가 입력되지 않았습니다.') : toastr.warning('비밀번호가 입력되지 않았습니다.');
    return;
  }
  // 로그인 form 선택
  const form = document.querySelector('#loginForm');
  // id 저장
  saveId(form);
  // 로그인 요청 수행
  sendRequest(form);
}

/**
 * @description 아이디 저장 기능 구현
 * @param {HTMLFormElement} form element의 userId
 */
function saveId({ isSaveId, userId }) {
  let expdate;
  // 기본적으로 30일동안 기억하게 함. 일수를 조절하려면 * 30에서 숫자를 조절하면 됨
  // 아이디 저장이 체크되어 있으면
  if (isSaveId.checked) {
    expdate = getDate(30); // 30일
  } else {
    expdate = getDate(-1); // 어제(쿠키 폐기 일자를 어제로 설정하기 때문에 쿠키 자동 폐기)
  }
  Cookie.setCookie(`ezen_saveId`, userId.value, expdate);
}

/**
 * @description 로그인 실행
 * @param {HTMLFormElement} form
 */
function sendRequest(form) {
  form.action = '/login/process';
  form.method = RequestMethod.POST;
  form.submit();
}

/**
 * @description 로그인 실패 처리 함수
 * @param {String} message
 */
function loginFailureHandler(message) {
  if (!message) return;
  toastr.error(message);
}
