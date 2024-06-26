

emps = [
	{empid:100,name:"Ramana",salary:45000},
	{empid:200,name:"Arun",salary:25000},
	{empid:300,name:"Sailesh",salary:32000},
	{empid:400,name:"Ishaan",salary:45000}
]

function makeTable(){
	
	str = "<table class='table table-striped'><thead><tr><th>Emp Id</th><th>Name</th><th>Salary</th></tr></thead>"
	str = str + "<tbody>"
	for(e of emps){	
		str = str +"<tr><td>"+e.empid+"</td><td>"+e.name+"</td><td>"+e.salary+"</td></tr>"
	}
	str = str+ "</tbody></table>"
	
	return str
}

function showTable(){
	
	tbl = makeTable()
	document.getElementById('display').innerHTML=tbl
}

function save(){
	eid= parseInt(document.getElementById('empid').value)
	nm=document.getElementById('name').value
	sal=parseInt(document.getElementById('salary').value)
	
	emp ={empid:eid,name:nm,salary:sal}
	emps.push(emp)
	showTable()
}
