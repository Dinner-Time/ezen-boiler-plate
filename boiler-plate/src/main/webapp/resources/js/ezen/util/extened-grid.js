class UtilGrid extends tui.Grid {
  constructor(opt) {
    super(opt);
  }

  saveData(data) {
    this.resetData(data);
    this.savedData = data;
  }
}

export default UtilGrid;
