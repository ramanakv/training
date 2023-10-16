package com.cg.trg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cg.trg.data.Employee;

public class EmployeeUtility {

	public static Map<Integer, Integer> getYearwise(List<Employee> list) {

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (Employee e : list) {
			int year = e.getDob().getYear();
			if (map.containsKey(year)) {
				int count = map.get(year);
				count++;
				map.put(year, count);
			} else {
				map.put(year, 1);
			}
		}

		return map;
	}

	public static Map<Character, List<Employee>> getGenderwise(List<Employee> list) {

		Map<Character, List<Employee>> map = new HashMap<Character, List<Employee>>();

		map.put('M', new ArrayList<Employee>());
		map.put('F', new ArrayList<Employee>());
		map.put('O', new ArrayList<Employee>());

		
		Iterator<Employee> itr = list.iterator();
		while(itr.hasNext()) {
			Employee e = itr.next();
			switch (e.getGender()) {
			case 'M':
				List<Employee> l = map.get('M');
				l.add(e);
				break;
			case 'F':
				map.get('F').add(e);
				break;
			default:
				map.get('O').add(e);
				break;

			}

		}

		return map;
	}
}
