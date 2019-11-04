package MyHashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap m = new MyHashMap();
         m.put(0, 0);
         m.put(1, 1);
         m.put(2, 2);
         m.put(16, 16);
         m.put(0, 1);
        System.out.println(m.getValue(0));
         System.out.println(m.toString());
	}

}
