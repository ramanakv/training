package com.adapter;

public class AdapterFactory {
	
	public static TempAdapter getAdapter(String type) {
		
		if(type.equals("class"))
			 return new TempClassAdapter();
		else
			return new TempObjectAdapter();
	}

}
