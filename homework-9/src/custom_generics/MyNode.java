package custom_generics;

public class MyNode<T> {

    public MyNode<T> previous;
    public MyNode<T> next;
    public T value;

    public MyNode(MyNode<T> previous, MyNode<T> next, T value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }
}
