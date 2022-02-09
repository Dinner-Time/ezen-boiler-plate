import { initializeEzenSelect, initializeTextLimit } from '../../../../util/initializations.js';

// 초기화 function
function initializePage(masterGrid, detailGrid, form, codeNm) {
  const { codeId, codeDesc } = form;
  detailGrid.clear(); // 그리드 초기화
  masterGrid.selectedRow = null;
  form.reset(); // 코드 정보 form 초기화
  codeNm.value = null;
  codeId.removeAttribute('readonly'); // 코드 정보 form의 readonly 삭제

  initializeEzenSelect({ codeGroup: 'MES', isEnabled: '1' }); // custom select 초기화
  initializeTextLimit(codeDesc); // 텍스트 제한 element 초기화
}

export { initializePage };
