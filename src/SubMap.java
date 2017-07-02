import java.util.*;

public class SubMap {
	public static void main(String args[])
	{
		TreeMap<Integer,String> original = new TreeMap<Integer, String>();
		
		original.put(2,"b");
		original.put(3,"c");
		original.put(4,"d");
		original.put(5,"e");
		//   original.put(6,"f");
		original.put(7,"g");
		original.put(8,"i");;
		
		System.out.println("Original before changes + "+original);
		
		Map<Integer,String> partial = original.subMap(3,true,7,true);
		
		System.out.println("Submap "+partial);
		
		partial.put(5, "five");
		partial.put(6, "f");	
		
		System.out.println("Original after changes + "+original);
		
		//partial.put(20, "IllegalArguementException Thrown as outsite range of map");
		
		System.out.println("floorKey for 6 is "+original.floorKey(6));
		System.out.println("lowerKey for 6 is "+original.lowerKey(6));
	}
}
