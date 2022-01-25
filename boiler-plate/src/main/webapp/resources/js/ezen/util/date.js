/**
 * @description 오늘부터 day일 이후의 날짜를 알려주는 function
 * @param {number} day
 */
function getDate(day = 0) {
  const date = new Date();
  date.setTime(date.getTime() + 1000 * 3600 * 24 * day);
  return date;
}

export { getDate };
