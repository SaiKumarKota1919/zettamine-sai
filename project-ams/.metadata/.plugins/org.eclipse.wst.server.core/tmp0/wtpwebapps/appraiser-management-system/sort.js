function sortResults(sortBy) {
  var tableBody = document.getElementById('resultsBody');
  var rows = Array.from(tableBody.getElementsByTagName('tr'));

   rows.sort(function(rowA, rowB) {
    var valueA = getCellValue(rowA, sortBy);
    var valueB = getCellValue(rowB, sortBy);

    if (valueA < valueB) return -1;
    if (valueA > valueB) return 1;
    return 0;
  });

  while (tableBody.firstChild) {
    tableBody.removeChild(tableBody.firstChild); // Clear existing rows
  }

  rows.forEach(function(row) {
    tableBody.appendChild(row); // Re-append sorted rows
  });
}

function getCellValue(row, sortBy) {
  var cellIndex = getColumnIndex(sortBy);
  return row.cells[cellIndex].innerText.toLowerCase();
}

function getColumnIndex(columnName) {
  var headerRow = document.querySelector('.search-results th:nth-child(1)'); // Adjust index if needed
  var headers = Array.from(headerRow.parentNode.children);
  return headers.findIndex(function(header) {
    return header.innerText.toLowerCase() === columnName.toLowerCase();
  });
}
