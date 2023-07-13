package MyQueue;


import Node.SinglyLinkedNode;

public class MyQueue<T> {
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
        if (firstNode == null)
            throw new RuntimeException("No elements in queue");

        return firstNode.getValue();
    }

    public T poll() {
        if (firstNode == null)
            throw new RuntimeException("No elements in queue");

        T valueOfFirstElement = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        return valueOfFirstElement;
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
