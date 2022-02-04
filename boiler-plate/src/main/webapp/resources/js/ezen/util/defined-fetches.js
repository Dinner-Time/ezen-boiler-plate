/**
 * @description method별 fetch 정의
 *              get, delete method는 url에 parameter를 더해주는 방식으로 데이터를 보낸다
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

// method 방식 import
import RequestMethod from '../util/request-method.js';

async function getFetch(url) {
  const option = {
    method: RequestMethod.GET,
  };

  const fetched = await fetch(url, option);
  const data = await fetched.json();

  return data;
}

async function postFetch(url, data = {}) {
  const option = {
    method: RequestMethod.POST,
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  };

  const fetched = await fetch(url, option);
  const result = await fetched.json();

  return result;
}

async function putFetch(url, data = {}) {
  const option = {
    method: RequestMethod.PUT,
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  };

  const fetched = await fetch(url, option);
  const result = await fetched.json();

  return result;
}

async function deleteFetch(url) {
  const option = {
    method: RequestMethod.DELETE,
  };

  const fetched = await fetch(url, option);
  const data = await fetched.json();

  return data;
}

export { getFetch, postFetch, putFetch, deleteFetch };
