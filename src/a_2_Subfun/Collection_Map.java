package a_2_Subfun;

import java.util.HashMap;
import java.util.Map;

public class Collection_Map {
    public static void main(String[] args) {
        Collection_Map_Test();
    }

    public static void Collection_Map_Test() {
        // TODO 创建Map
        Map<String, String> map = createMap(10);

        // TODO 如果没有key，或者key可能对应的值就是null，那么就返回null
        System.out.println("key: key-0 的 value 为: " + map.get("key-0"));
        System.out.println(map.get(new Object()));
        System.out.println(map.get("key-999"));
        // TODO 注意：不是每种Map的实现都允许key或者value为null，使用时需要注意
        map.put(null, "value of null key");
        map.put("TestNull", null);
        System.out.println("key: null 的 value 为: " + map.get(null));
        System.out.println("key: TestNull 的 value 为: " + map.get("TestNull"));


        // TODO 删除key
        System.out.println("\n--------------删除key--------------");
        String keyToRemove = "key-9";
        System.out.println(keyToRemove + "对应的值是：" + map.get(keyToRemove));
        map.remove(keyToRemove);
        System.out.println("执行删除操作后，" + keyToRemove + "对应的值是：" + map.get(keyToRemove));


        // TODO 通过Entry类遍历Map
        System.out.println("\n--------------Entry遍历key和value--------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key为：" + entry.getKey() + "，value为：" + entry.getValue());
        }

        // TODO 遍历Map的value
        System.out.println("\n--------------遍历value--------------");
        for (String value : map.values()) {
            System.out.println(value);
        }


        // TODO 遍历Map的Key
        System.out.println("\n--------------遍历key--------------");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

    }


    // TODO 创建 HashMap 实例，并按照泛型的定义，向里面放入key和value
    private static Map<String, String> createMap(int size) {
        Map<String, String> ret = new HashMap<>();
        for (int i = 0; i < size; i++) {
            // TODO put的第一个为key，第二个为value
            //ret.put("key-" + i, String.valueOf(Math.random()*100));
            ret.put("key-" + i, String.format("%.2f", Math.random() * 100));
        }
        return ret;
    }

}
