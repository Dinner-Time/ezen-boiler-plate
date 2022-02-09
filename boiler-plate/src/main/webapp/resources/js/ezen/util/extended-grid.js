import ErrorMessage from './error-message.js';

class UtilGrid extends tui.Grid {
  constructor(opt) {
    super(opt);
  }

  saveData(data) {
    this.resetData(data);
    this.savedData = data;
  }

  saveSelectedRow(row) {
    this.selectedRow = row;
  }

  vaildateColumn(columnNames) {
    this.finishEditing();

    try {
      columnNames.forEach((column) => {
        this.getColumnValues(column).forEach((value) => {
          if (!value && value !== 0) throw ErrorMessage.CHECK_INPUT;
        });
      });
    } catch (error) {
      ErrorMessage.toastrErrorMessage(error);
      return false;
    }

    return true;
  }
}

export default UtilGrid;
