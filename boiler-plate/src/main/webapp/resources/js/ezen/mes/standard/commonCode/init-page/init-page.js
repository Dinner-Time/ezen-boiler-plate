// 초기화 function
function initializePage(masterGrid, detailGrid, form, codeNm) {
  const { codeId, codeDesc } = form;
  detailGrid.clear(); // 그리드 초기화
  masterGrid.selectedRow = null;
  form.reset(); // 코드 정보 form 초기화
  codeNm.value = null;
  codeId.removeAttribute('readonly'); // 코드 정보 form의 readonly 삭제

  const ezenSelectList = document.querySelectorAll('ezen-select');

  [...ezenSelectList].forEach((select) => select.reset());

  const limitedTextArea = document.querySelector('limited-textarea');
  if (limitedTextArea) limitedTextArea.reset();
}

export { initializePage };
