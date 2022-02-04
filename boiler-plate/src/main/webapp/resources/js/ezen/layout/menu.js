/**
 * @description 메뉴 기능 구현
 * @author 박태훈
 * @since 2022-02-04
 */

// 로고 이미지 클릭시 홈 화면으로
document.querySelector('.ezen-menu-wrap .offcanvas-title').addEventListener('click', () => {
  leavePageTrace('/');
});

// 페이지 이동 link
const pageLinks = document.querySelectorAll('.move-page-link-wrap li');

[...pageLinks].forEach((link) => {
  link.addEventListener('click', (e) => {
    e.preventDefault();
    const { target } = e;
    const { pageLink, pageNo } = target.closest('li').dataset;

    if (!pageLink) return; // pageLink가 없을 경우 종료
    leavePageTrace(pageLink, pageNo); // 페이지 오픈
  });
});

/**
 * 지금 열려는 페이지가 탭에 띄워져있는 경우
 *  탭이 더 늘어나지 않고 이전 탭을 종료하고 새 탭을 띄우는 함수
 *
 *  ** 해당 function이 어떻게 작동하는지 정확하게 파악되어있지 않음 **
 */
function leavePageTrace(pageLink, pageNo = 0) {
  // 이미 열려있는 페이지인지 확인
  const windowObjHistorySearch = {}; //null;
  winObj = eval('windowObjHistorySearch.M' + pageNo);

  // 요청 url
  const pageUrl = pageNo === 0 ? pageLink : `/mes/${pageNo}?pageLink=${pageLink}`;

  if (!winObj) {
    // 열려있지 않은 페이지인 경우
    // 페이지 열기
    winObj = window.open(pageUrl, pageNo);
  } else {
    // 열려있는 페이지인 경우
    // 열려있는 페이지를 닫고
    if (winObj.closed) {
      // 페이지 열기
      winObj = window.open(pageUrl, pageNo);
    }
  }
  // focus 제거
  winObj.blur();
  // 새로 연 페이지에 focus
  winObj.focus();
}
