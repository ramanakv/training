

employees =
	[
		{ empid: 100, name: "Asish", salary: 45000 },
		{ empid: 200, name: "Rajesh", salary: 55000 },
		{ empid: 300, name: "Santosh", salary: 62000 },
		{ empid: 400, name: "Ritu", salary: 35000 },
		{ empid: 500, name: "Gayatri", salary: 48000 }

	]

function show() {
	var tbltxt = "<table class='table table-hover table-striped table-bordered'><tr><th>Emp Id</th><th>Name</th><th>Salary</th></tr>"

	for (e of employees) {
		tbltxt = tbltxt + "<tr>";
		tbltxt = tbltxt + "<td>" + e.empid + "</td>"
		tbltxt = tbltxt + "<td>" + e.name + "</td>"
		tbltxt = tbltxt + "<td>" + e.salary + "</td>"
		tbltxt = tbltxt + "</tr>";
	}

	tbltxt = tbltxt + "</table>";

	document.getElementById("display").innerHTML = tbltxt;

}

function hide() {
	document.getElementById("display").innerHTML = "";
}

function save() {
	errors = "";
	// validate empid
	empid = document.getElementById("empid").value;
	empid = parseInt(empid);

	if (isNaN(empid))
		errors = errors + "please enter proper empid\n";

	//validate for non empty name
	name = document.getElementById("name").value;

	if (name == "")
		errors = errors + " Name cannot be blank\n";

	// validate salary
	salary = document.getElementById("salary").value;
	salary = parseInt(salary);
	if (isNaN(salary))
		errors = errors + "please enter proper salary";

	if (errors != "") {
		alert(errors)
		return
	}

	function checkDuplicate(e) {
		return e.empid == empid
	}

	// check for duplicate data


	if (employees.findIndex(e => e.empid == empid) != -1) { // using fat arrow function which is similar to lambda in java
		alert("Emp id " + empid + " already exists")
		return
	}


	emp = { empid, name, salary };
	employees.push(emp);

	show();
}

function clearAll() {
	document.getElementById("empid").value = ""
	document.getElementById("name").value = ""
	document.getElementById("salary").value = ""
}

function loadList() {
	var text = "<select onchange='showData(this.selectedIndex)'>"
	for (e of employees) {
		text = text + "<option value=" + e.empid + ">" + e.name + "</option>"
	}
	text = text + "</select>"

	document.getElementById('list').innerHTML = text
}

function showData(index) {
	emp = employees[index];
	empData = "<table class='table table-hover table-bordered'>"
	empData = empData + "<tr>" + "<td>Emp Id </td>" + "<td>" + emp.empid + "</td>" + "</tr>"

	empData = empData + "<tr>" + "<td>Name </td>" + "<td>" + emp.name + "</td>" + "</tr>"
	empData = empData + "<tr>" + "<td>Salary </td>" + "<td>" + emp.salary + "</td>" + "</tr>"
	empData = empData + "</table>"

	document.getElementById("data").innerHTML = empData;
}





