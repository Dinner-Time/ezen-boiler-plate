/**
 * @description 쿠키 관련 class
 * @author 박태훈
 * @since 2022-01-25
 */
class Cookie {
  constructor() {}

  /**
   * @description 쿠키 저장
   * @param {string} name => 저장할 이름(key)
   * @param {string} value => 저장할 값(value)
   * @param {Date} expires => 쿠키 삭제 날짜
   */
  static setCookie(name, value, expires) {
    document.cookie = `ezen_${name}=${encodeURI(value)};path=/;expires=${expires.toGMTString()}`;
  }

  /**
   * @description 쿠키 불러오기
   * @param {string} name => 저장되어 있는 이름(key)
   * @returns
   */
  static getCookie(name) {
    let offset = document.cookie.indexOf(`${name}=`);
    if (offset === -1) return;
    offset += name.length + 1;

    let end = document.cookie.indexOf(';', offset);
    if (end === -1) end = document.cookie.length;

    return decodeURI(document.cookie.substring(offset, end));
  }
}

export default Cookie;
