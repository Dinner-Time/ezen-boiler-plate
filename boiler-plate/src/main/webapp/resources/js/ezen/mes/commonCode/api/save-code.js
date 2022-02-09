/**
 * @description 저장 API 호출
 * @author 박태훈
 * @since 2022-02-09
 */

import { postFetch } from '../../../util/defined-fetches.js';
import { formToJson } from '../../../util/form-util.js';
import { vaildateRequestData } from '../../../util/vaildation.js';

const newBtn = document.querySelector('#newBtn');

// 하위 코드 목록 저장
async function saveChildrenCode(grid, masterCodeId) {
  if (!masterCodeId) {
    toastr.warning('코드목록에서 선택한 코드가 없습니다.');
    return;
  }

  if (!grid.vaildateColumn(['codeId', 'codeNm', 'codeDesc'])) return;

  const moreRequest = { parentCode: masterCodeId };
  const requestData = [];
  const data = grid.getData();

  data.forEach((row) => {
    requestData.push({ ...row, ...moreRequest });
  });

  const executeSave = await postFetch('/mes/commonCode/save/children', requestData);

  executeSaveCallback(executeSave);
}

// 코드 정보 저장
async function saveMasterCodeInfo(e, form) {
  const { target } = e;
  if (!vaildateRequestData(target.id)) return; // 유효성 검사 이후 저장 실행

  /**
   * request data
   * -- parameter로 넘겨받은 form의 데이터와
   * -- 추가로 넣어줄 데이터를 합쳐준다.
   */
  const moreRequest = {
    parentCode: document.querySelector('#codeGroup').value,
  };
  const requestData = { ...formToJson(form), ...moreRequest };

  // api 호출
  const executeSave = await postFetch('/mes/commonCode/save/master', requestData);

  executeSaveCallback(executeSave);
}

function executeSaveCallback(executeSave) {
  if (executeSave === 1) {
    toastr.success('저장이 완료되었습니다.');
    newBtn.click();
  } else {
    toastr.warning('저장에 실패했습니다.');
  }
}

export { saveChildrenCode, saveMasterCodeInfo };
