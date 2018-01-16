/**
 * 
 */

function loadReimbursementsViewFromEmployeeNavbar() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById("submitReimbursementBtn").addEventListener("click", submitReimbursement, false);
			document.getElementById("reimbursementStatusFilter").addEventListener("change", loadReimbursements, false);
			loadReimbursements();
		}
	}
	xhr.open("GET", "ajaxReimbursements", true);
	xhr.send();
}