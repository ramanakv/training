
import static com.cg.trg.sort.SortUtils.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;;

public class TestMain1 {

	public static void main(String[] args) {

		String[][] array = { 
				{"2023-10-21","10:21:05","CRITICAL","failed"},
				{"2021-10-21","10:21:05","CRITICAL","message"},
				{"2020-10-21","11:21:05","ERROR", "failed"},
				{"2020-10-21","13:21:05","ERROR" ,"failed"},
				{"2023-10-21","17:21:05","CRITICAL","error"},
				{"2019-10-05","02:21:05","INFO","failed"},
				{"2022-01-21","05:21:05","CRITICAL","message"},
				{"2023-10-21","17:21:05","ERROR","error"},
				{"2019-10-05","02:21:05","CRITICAL","failed"},
				{"2023-10-21","17:21:05","ERROR","error"}
		};
		
		List<List<String>> list = new ArrayList<>();
		
		for(int i=0;i<array.length;i++) {
			List<String> l =Arrays.asList(array[i]);
			list.add(l);
		}
		
		
		sortMessages(list).forEach(System.out::println);
	
		
	}

	static List<List<String>> sortMessages(List<List<String>>  list){
		List<List<String>> newList = list.stream()
				.filter(l -> l.get(2).equals("CRITICAL") || l.get(2).equals("ERROR"))
				.collect(Collectors.toList());
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		
		Comparator<List<String>>  comp =
				
				Comparator.comparing(l->l.get(2));
				
			comp = comp.thenComparing(l-> LocalDateTime.parse(l.get(0)+"T"+l.get(1)));
			
		//		(l1,l2)-> LocalDateTime.parse(l1.get(0)+l1.get(1), df).compareTo(LocalDateTime.parse(l2.get(0)+l2.get(1),df));	
				
		newList =
		newList.stream()
		.sorted(comp)
		.collect(Collectors.toList());
		
		return newList;


	}
}
