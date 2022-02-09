function searchByCodeNm(grid, keyword) {
  const data = grid.savedData;
  const filtered = data.filter((elem) => elem.codeNm.includes(keyword.trim()));
  grid.resetData(filtered);
}

export { searchByCodeNm };
