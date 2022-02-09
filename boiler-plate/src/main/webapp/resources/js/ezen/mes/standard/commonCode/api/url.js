const baseUrl = '/mes/commonCode';

const requestUrl = {
  CODE_GROUP_LIST: `${baseUrl}/codeGroup`,
  MASTER_CODE_LIST: `${baseUrl}/masterCode`,
  DETAIL_CODE_LIST: `${baseUrl}/childCode`,

  SAVE_MASTER_CODE: `${baseUrl}/save/master`,
  SAVE_DETAIL_CODE: `${baseUrl}/save/children`,
};

export default requestUrl;
