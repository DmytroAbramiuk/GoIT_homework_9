package MyLinkedList;

import Node.DoubleLinkedNode;

public class MyLinkedList<T> {
    private DoubleLinkedNode<T> firstNode;
    private DoubleLinkedNode<T> lastNode;
    private int size = 0;

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
        size++;
    }

    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Specified index does not exist");
        }
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
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
        indexCheck(index);
        return getNode(index).getValue();
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        indexCheck(index);

        if (index == 0) {
            firstNode = firstNode.getNextNode();
            firstNode.setPreviousNode(null);
            size--;
        } else if (index == size() - 1) {
            lastNode = lastNode.getPreviousNode();
            lastNode.setNextNode(null);
            size--;
        } else {
            DoubleLinkedNode<T> currentNode = getNode(index);
            DoubleLinkedNode<T> prevNodeFromCurrent = currentNode.getPreviousNode();
            DoubleLinkedNode<T> nextNodeFromCurrent = currentNode.getNextNode();
            prevNodeFromCurrent.setNextNode(nextNodeFromCurrent);
            nextNodeFromCurrent.setPreviousNode(prevNodeFromCurrent);
            size--;
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
