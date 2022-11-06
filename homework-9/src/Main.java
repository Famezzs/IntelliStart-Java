import custom_generics.myhashmap.MyHashMap;
import custom_generics.myhashmap.MyHashMapNode;
import custom_generics.myqueue.MyQueue;
import custom_generics.mystack.MyStack;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();

        for (int i = 1; i <= 10; ++i) {
            map.put("key" + i, "value" + i);
        }

        for (int i = 1; i <= 10; ++i) {
            System.out.println(map.get("key" + i).value);
        }
    }
}
