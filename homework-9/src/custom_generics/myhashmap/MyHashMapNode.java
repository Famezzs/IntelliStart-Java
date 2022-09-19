package custom_generics.myhashmap;

public class MyHashMapNode<K,V> {

    public MyHashMapNode<K,V> previous;
    public MyHashMapNode<K,V> next;
    public K key;
    public V value;

    public MyHashMapNode(MyHashMapNode<K, V> previous, MyHashMapNode<K, V> next, K key, V value) {
        this.previous = previous;
        this.next = next;
        this.key = key;
        this.value = value;
    }
}
