package MyQueue;


public class MyQueue<T> {
    private MyNode<T> firstNode;

    private MyNode<T> getLastNode() {
        MyNode<T> currentNode = firstNode;
        if (currentNode == null)
            throw new RuntimeException("There is no any node");

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new MyNode<>(null, value);
        } else {
            getLastNode().setNextNode(new MyNode<>(null, value));
        }
    }

    public void clear() {
        firstNode = null;
    }

    public int size() {
        MyNode<T> currentNode = firstNode;
        int length = 0;
        if (currentNode != null) {
            while (currentNode != null) {
                length++;
                currentNode = currentNode.getNextNode();
            }
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

        MyNode<T> currentNode = firstNode;
        String queueStr = "[";

        while (currentNode.getNextNode() != null) {
            queueStr += currentNode.getValue() + ", ";
            currentNode = currentNode.getNextNode();
        }
        queueStr += currentNode.getValue() + "]";

        return queueStr;
    }
}
