package MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        System.out.println("Add elements");
        for (int i = 0; i < 5; i++) {
            myQueue.add(i);
            System.out.println(myQueue);
        }

        System.out.println("=========================");
        System.out.println("Queue's size");
        System.out.println("myQueue.size() = " + myQueue.size());

        System.out.println("=========================");
        System.out.println("Return first element from queue");
        System.out.println(myQueue);
        System.out.println("myQueue.peek() = " + myQueue.peek());

        System.out.println("=========================");
        System.out.println("Return first element from queue and delete it");
        System.out.println(myQueue);
        System.out.println("myQueue.peek() = " + myQueue.poll());
        System.out.println(myQueue);

        System.out.println("=========================");
        System.out.println("Clear queue");
        System.out.println(myQueue);
        myQueue.clear();
        System.out.println(myQueue);
    }
}
