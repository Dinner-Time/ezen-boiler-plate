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
function saveChildrenCode(e) {
  console.log('하위 코드 목록');
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

  if (executeSave === 1) {
    toastr.success('저장이 완료되었습니다.');
    newBtn.click();
  } else {
    toastr.warning('저장에 실패했습니다.');
  }
}

export { saveChildrenCode, saveMasterCodeInfo };
