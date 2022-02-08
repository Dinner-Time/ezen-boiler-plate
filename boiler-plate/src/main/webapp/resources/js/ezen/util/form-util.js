function formToJson(form) {
  const formData = new FormData(form);

  const obj = {};
  for (let entry of formData.entries()) {
    // entry[0] => input name
    // entry[1] => input value
    obj[entry[0]] = entry[1];
  }

  return obj;
}

export { formToJson };
