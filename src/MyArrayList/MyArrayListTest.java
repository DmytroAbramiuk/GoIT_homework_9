package MyArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>(2);

        System.out.println("Add elements");
        for (int i = 1; i <= 5; i++) {
            list.add(i);
            System.out.println(list);
        }

        System.out.println("Get elements");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }

        System.out.println("Remove element");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

        System.out.println("Size of list");
        System.out.println("list.size() = " + list.size());

        System.out.println("Clear list");
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
