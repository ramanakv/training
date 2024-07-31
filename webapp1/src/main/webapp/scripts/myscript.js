

function calculate(option) {

	x = document.getElementById("num1").value;
	y = document.getElementById("num2").value;

	x = parseInt(x);
	y = parseInt(y);

	if (isNaN(x) || isNaN(y)) {
		alert("please enter valid integers");
		return
	}

	switch (option) {
		case 'A': result = x + y;
			break;
		case 'S': result = x - y;
			break;
		case 'M': result = x * y;
			break;
		case 'D': result = x / y;
	}


	document.getElementById("demo").innerHTML = "Result: " + result;
}

function clearValues() {
	document.getElementById("num1").value = "";
	document.getElementById("num2").value = "";
	document.getElementById("demo").innerHTML = "";
	document.getElementById("demo").class=""
}