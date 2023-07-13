package Stack;

import Node.SinglyLinkedNode;

public class MyStack<T> {
    private SinglyLinkedNode<T> firstNode;

    private SinglyLinkedNode<T> getLastNode() {
        if (firstNode == null)
            throw new RuntimeException("There is no any node");

        SinglyLinkedNode<T> currentNode = firstNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new SinglyLinkedNode<>(null, value);
        } else {
            getLastNode().setNextNode(new SinglyLinkedNode<>(null, value));
        }
    }

    public void remove(int index) {
        if (index >= size() || index < 0)
            throw new RuntimeException("Specified index does not exist");

        int currentIndex = 0;
        SinglyLinkedNode<T> currentNode = firstNode;

        while (currentIndex != index - 1) {
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }

        SinglyLinkedNode<T> nextAfterNodeToRemove = currentNode.getNextNode().getNextNode();
        currentNode.setNextNode(nextAfterNodeToRemove);
    }

    public void clear() {
        firstNode = null;
    }

    public int size() {
        if (firstNode == null)
            return 0;

        SinglyLinkedNode<T> currentNode = firstNode;
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNextNode();
        }
        return length;
    }

    public T peek() {
        if (firstNode == null) {
            throw new RuntimeException("There isn't any element in stack");
        }

        SinglyLinkedNode<T> currentNode = firstNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }

    public T pop() {
        if (firstNode == null) {
            throw new RuntimeException("There isn't any element in stack");
        }

        T firstStackElement = getLastNode().getValue();

        SinglyLinkedNode<T> currentNode = firstNode;
        while (currentNode.getNextNode().getValue() != firstStackElement) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(null);

        return firstStackElement;
    }

    @Override
    public String toString() {
        if (firstNode == null)
            return "[]";

        SinglyLinkedNode<T> currentNode = firstNode;
        String queueStr = "[";

        while (currentNode.getNextNode() != null) {
            queueStr += currentNode.getValue() + ", ";
            currentNode = currentNode.getNextNode();
        }
        queueStr += currentNode.getValue() + "]";

        return queueStr;
    }
}
