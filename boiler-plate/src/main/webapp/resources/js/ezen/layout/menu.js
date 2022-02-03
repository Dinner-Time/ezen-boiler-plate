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

    if (!pageLink) return;
    leavePageTrace(pageLink, pageNo);
  });
});

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
