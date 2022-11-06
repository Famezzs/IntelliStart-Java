package custom_generics.myhashmap;

public class MyHashMapNode<K,V> {
    public K key;
    public V value;
    public MyHashMapNode<K,V> next;

    public MyHashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public MyHashMapNode(K key, V value, MyHashMapNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
