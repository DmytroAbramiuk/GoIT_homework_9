package MyLinkedList;

import Node.DoubleLinkedNode;

public class MyLinkedList<T> {
    private DoubleLinkedNode<T> firstNode;
    private DoubleLinkedNode<T> lastNode;

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new DoubleLinkedNode<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new DoubleLinkedNode<T>(null, firstNode, value);
            firstNode.setNextNode(lastNode);
        } else {
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(null, lastNode, value);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
    }

    public void clear() {
        if (firstNode == null) {
            firstNode = null;
            return;
        } else if (lastNode == null) {
            return;
        }

        while (firstNode != null) {
            DoubleLinkedNode<T> currentNode = lastNode.getPreviousNode();
            lastNode = null;
            currentNode.setNextNode(null);
            lastNode = currentNode;

            if (currentNode.getPreviousNode() == null) {
                firstNode = null;
                lastNode = null;
                return;
            }
        }
    }

    private DoubleLinkedNode<T> getNode(int index) {
        if (firstNode == null)
            throw new RuntimeException("there aren't any values at list");

        DoubleLinkedNode<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new RuntimeException("Specified index does not exist");
        }
        return getNode(index).getValue();
    }

    public int size() {
        if (firstNode == null) {
            return 0;
        }

        DoubleLinkedNode<T> currentNode = firstNode;
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNextNode();
        }

        return length;
    }

    public void remove(int index) {
        if (index < 0 || index >= size())
            throw new RuntimeException("Specified index does not exist");

        if (index == 0) {
            firstNode = firstNode.getNextNode();
            firstNode.setPreviousNode(null);
        } else if (index == size() - 1) {
            lastNode = lastNode.getPreviousNode();
            lastNode.setNextNode(null);
        } else {
            DoubleLinkedNode<T> currentNode = getNode(index);
            DoubleLinkedNode<T> prevNodeFromCurrent = currentNode.getPreviousNode();
            DoubleLinkedNode<T> nextNodeFromCurrent = currentNode.getNextNode();
            prevNodeFromCurrent.setNextNode(nextNodeFromCurrent);
            nextNodeFromCurrent.setPreviousNode(prevNodeFromCurrent);
        }
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "[]";

        String strList = "[";
        DoubleLinkedNode<T> currentNode = firstNode;

        while (currentNode.getNextNode() != null) {
            strList += currentNode.getValue() + ", ";
            currentNode = currentNode.getNextNode();
        }
        strList += currentNode.getValue() + "]";

        return strList;
    }
}
