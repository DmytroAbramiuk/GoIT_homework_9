package MyQueue;

public class MyNode<T> {
    private MyNode<T> nextNode;
    private T value;

    public MyNode(MyNode<T> nextNode, T value) {
        this.nextNode = nextNode;
        this.value = value;
    }

    public MyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
