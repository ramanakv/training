module mod.map {
	requires mod.service;
	provides com.service.EmployeeService with com.map.provider.EmployeeMapService;
}
