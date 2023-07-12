package MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList<Integer> myList = new MyLinkedList<Integer>();

        System.out.println("Add elements");
        for (int i = 0; i < 10; i++) {
            myList.add(i);
            System.out.println(myList);
        }

        System.out.println("=========================");
        System.out.println("Linked list size");
        System.out.println("myList.size() = " + myList.size());

        System.out.println("=========================");
        System.out.println("get element by index");
        System.out.println("myList.get(3) = " + myList.get(3));

        System.out.println("=========================");
        System.out.println("remove element by index");
        System.out.println("Original list:\n" + myList);
        myList.remove(0);
        System.out.println("removed element with index 0:\n" + myList);
        myList.remove(myList.size() - 1);
        System.out.println("removed element with index myList.size()-1:\n" + myList);
        myList.remove(myList.size() / 2);
        System.out.println("removed element with index myList.size()/2:\n" + myList);

        System.out.println("=========================");
        System.out.println("clear all list");
        myList.clear();
        System.out.println(myList);
    }
}
