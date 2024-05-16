package com.facade;

import java.sql.Connection;

public class StoreUtil {

	StoreData getStoreData(int id, Connection con) {

		// data retieved from database
		return new StoreData(id, 192, 200);
	}

}
