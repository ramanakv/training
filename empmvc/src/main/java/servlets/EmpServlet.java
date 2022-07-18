package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Employee;
import service.EmpService;

@WebServlet("/getEmpData")
public class EmpServlet extends HttpServlet {

	EmpService service;

	public void init() {

		service = new EmpService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		String view = "";

		switch (action) {

		case "Show":
			view = service.getEmployee(request);
			break;

		case "Save":
			view = service.saveEmployee(request);
			break;
			
		case "Delete":
			view = service.deleteEmployee(request);
			break;

		}

		RequestDispatcher rd = request.getRequestDispatcher(view + ".jsp");
		rd.forward(request, response);

	}

}
