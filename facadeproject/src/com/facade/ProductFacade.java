package com.facade;

import java.sql.Connection;

public class ProductFacade {

	DatabaseConnection dbc = new DatabaseConnection();
	ProductUtil util;

	public boolean isItemBelowROL(int ic) {
		Connection con = dbc.createConnection();
		util = new ProductUtil(con);

		int qty = util.getQuantity(ic);
		int rol = util.getMinLevel(ic);

		if (rol < qty)
			return false;
		else
			return true;

	}

}
