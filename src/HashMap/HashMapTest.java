package HashMap;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();

        System.out.println("================put element================");
        hashMap.put("first", 1);
        hashMap.put("second", 2);
        hashMap.put("third", 3);
        hashMap.put("fourth", 4);
        hashMap.put("fifth", 5);
        hashMap.put("sixth", 6);
        hashMap.put("seventh", 7);
        hashMap.put("eighth", 8);
        hashMap.put("ninth", 9);
        hashMap.put("ten", 10);
        hashMap.put("eleven", 11);
        hashMap.put("twelve", 12);
        hashMap.put("thirteen", 13);
        hashMap.put("fourteen", 14);
        hashMap.put("fifteen", 15);
        hashMap.put("sixteen", 16);
        hashMap.put("seventeen", 17);
        hashMap.put("eighteen", 18);
        hashMap.put("nineteen", 19);
        hashMap.put("twenty", 20);
        System.out.println(hashMap);

        System.out.println("================size of hashMap================");
        System.out.println("hashMap.size() = " + hashMap.size());

        System.out.println("================get element by key================");
        System.out.println("hashMap.get(\"ninth\") = " + hashMap.get("ninth"));

        System.out.println("================remove element by key================");
        System.out.println("remove key first");
        hashMap.remove("first");
        System.out.println(hashMap + "\n");
        System.out.println("remove key thirteen");
        hashMap.remove("thirteen");
        System.out.println(hashMap + "\n");
        System.out.println("remove key ninth");
        hashMap.remove("ninth");
        System.out.println(hashMap);

        System.out.println("================clear hashMap================");
        hashMap.clear();
        System.out.println(hashMap);
    }
}
