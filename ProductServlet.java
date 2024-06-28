package com.del;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.myfaces.shared.util.HashMapUtils;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashMap<Integer, Product> products = new HashMap<>();

	public void init(ServletConfig config) throws ServletException {
		products.put(100, new Product(100, "Television", 56000));
		products.put(200, new Product(200, "Wireless Router", 10000));
		products.put(300, new Product(300, "Mobile", 34000));
		products.put(400, new Product(400, "Hard Disk", 2500));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("REQ");

		if (action.equals("Get Product")) {
			String pidStr = request.getParameter("PID");

			int pid = Integer.parseInt(pidStr);
			Product prod = products.get(pid);

			if (prod == null) {
				String message = "Product with id " + pid + " not found";

				request.setAttribute("response", message);
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("pr", prod);
				RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
				rd.forward(request, response);
			}

		}
		else {
			String pidStr = request.getParameter("PID");

			int pid = Integer.parseInt(pidStr);
			Product prod = products.get(pid);
			
			String name = request.getParameter("PNM");
			
			String prStr = request.getParameter("PRC");

			double prc = Double.parseDouble(prStr);
			
			Product p = new Product(pid,name,prc);
			
			if(products.containsKey(pid)) {
				String message = "Product with id " + pid + " already exists";

				request.setAttribute("response", message);
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			else {
				
				products.put(pid, p);
				
				String message = "Product with id " + pid + " successfully saved";

				request.setAttribute("response", message);
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				
			}
			

		}
	}

}
