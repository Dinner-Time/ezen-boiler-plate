/**
 * @description 초기화 함수 정의
 * @author 박태훈
 * @since 2022-02-04
 */
'use strict'; // 엄격 모드 실행

/**
 * custom select 태그 초기화
 *  parameter는 object타입
 *    => { ezen-select 태그 내의 select 태그의 id(key) : 초기화 할 option 태그 value(value)}
 */
function initializeEzenSelect(initConditions) {
  const selectList = document.querySelectorAll('ezen-select');

  [...selectList].forEach((elem) => {
    const selectTagId = elem.querySelector('select').id; // select 태그의 id(key)
    elem.setValue(initConditions[selectTagId]); // value 초기화
  });
}

export { initializeEzenSelect };
