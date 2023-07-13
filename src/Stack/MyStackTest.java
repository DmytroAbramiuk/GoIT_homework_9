package Stack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        System.out.println("Add elements");
        for (int i = 0; i < 5; i++) {
            myStack.add(i);
            System.out.println(myStack);
        }

        System.out.println("=========================");
        System.out.println("Queue's size");
        System.out.println("stack.size() = " + myStack.size());

        System.out.println("=========================");
        System.out.println("Return first element from stack");
        System.out.println(myStack);
        System.out.println("stack.peek() = " + myStack.peek());

        System.out.println("=========================");
        System.out.println("Remove element by index from stack");
        System.out.println(myStack);
        myStack.remove(3);
        System.out.println(myStack);

        System.out.println("=========================");
        System.out.println("Return first element from stack and delete it");
        System.out.println(myStack);
        System.out.println("stack.pop() = " + myStack.pop());
        System.out.println(myStack);

        System.out.println("=========================");
        System.out.println("Clear stack");
        System.out.println(myStack);
        myStack.clear();
        System.out.println(myStack);
    }
}
