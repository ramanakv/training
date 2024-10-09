import java.util.HashMap;
import java.util.Map;

// Use the following settings different times
// -XX:+UseSerialGC -Xms1024m -Xmx1024m -verbose:gc
// run by reducing the size repeatedly
// -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
// -XX:+UseSerialGC -Xms128m -Xmx128m -verbose:gc -XX:+PrintGCDetails


public class App {

    private static Map<String, String> stringContainer = new HashMap<>();  

    public static void main(String[] args) {
        System.out.println("Start of program!");
        String str = "stringWithPrefix ";

        // Load Java Heap with 30 M java.lang.String instances
        for (int i = 0; i < 3000000; i++) {
            String newString = str + i;
            stringContainer.put(newString, newString);
     
     //       if(i%200000 == 0)
      //      	stringContainer = new HashMap<>();
     
        }
        stringContainer = new HashMap<>();   
        
        System.out.println("MAP size: " + stringContainer.size());

        // Explicit GC!
        System.out.println("GC requested");
      //  System.gc();

        // Remove 2 M out of 3 M
        for (int i = 0; i < 2; i++) {
            String newString = str + i;
            stringContainer.remove(newString);
        }

        System.out.println("MAP size: " + stringContainer.size());
        System.out.println("End of program!");
    }
}
