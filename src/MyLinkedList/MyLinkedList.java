package MyLinkedList;

public class MyLinkedList<T> {
    private MyNode<T> firstNode;
    private MyNode<T> lastNode;

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new MyNode<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new MyNode<T>(null, firstNode, value);
            firstNode.setNextNode(lastNode);
        } else {
            MyNode<T> newNode = new MyNode<T>(null, lastNode, value);
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
            MyNode<T> currentNode = lastNode.getPreviousNode();
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

    private MyNode<T> getNode(int index) {
        if (firstNode == null)
            throw new RuntimeException("there aren't any values at list");

        MyNode<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public T get(int index) {
        if (index >= size()) {
            throw new RuntimeException("index is bigger than list size");
        }
        return getNode(index).getValue();
    }

    public int size() {
        if (firstNode == null) {
            return 0;
        }

        MyNode<T> currentNode = firstNode;
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
            MyNode<T> currentNode = getNode(index);
            MyNode<T> prevNodeFromCurrent = currentNode.getPreviousNode();
            MyNode<T> nextNodeFromCurrent = currentNode.getNextNode();
            prevNodeFromCurrent.setNextNode(nextNodeFromCurrent);
            nextNodeFromCurrent.setPreviousNode(prevNodeFromCurrent);
        }
    }

    @Override
    public String toString() {
        if (this.size() == 0)
            return "[]";

        String strList = "[";
        MyNode<T> currentNode = firstNode;

        while (currentNode.getNextNode() != null) {
            strList += currentNode.getValue() + ", ";
            currentNode = currentNode.getNextNode();
        }
        strList += currentNode.getValue() + "]";

        return strList;
    }


}
