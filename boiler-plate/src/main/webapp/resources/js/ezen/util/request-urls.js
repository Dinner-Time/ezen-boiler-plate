/**
 * @description controller url 정의
 * @author 박태훈
 * @since 2022-01-25
 */
// 로그인
export const PROCCESS_LOGIN = '/login/process';

// 공통 관리
const commonCodeBaseUrl = '/mes/commonCode';
export const CommonCodeUrl = {
  CODE_GROUP: `${commonCodeBaseUrl}/codeGroup`,
  COMMON_CODE: `${commonCodeBaseUrl}/commonCode`,
  CHILD_CODE: `${commonCodeBaseUrl}/childCode`,
};
