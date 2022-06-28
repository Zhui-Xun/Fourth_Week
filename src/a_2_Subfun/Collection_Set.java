package a_2_Subfun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Collection_Set {
    public static void main(String[] args) {

        printCollection(addElementsToCollection(new HashSet()));
        printCollection(addElementsToCollection(new ArrayList()));

    }

    public static Collection addElementsToCollection(Collection collection) {

        System.out.println("向 <" + collection.getClass() + "> 中添加元素:");
        for (int i = 0; i < 5; i++) {
            collection.add("字符串-" + (i % 5));
        }
        return collection;

    }

    public static void printCollection(Collection collection) {
        //System.out.println();
        System.out.println("================================================");
        System.out.println("输出 <" + collection.getClass() + "> 中的元素，共" + collection.size() + "个");
        try {
            for (Object element : collection) {
                System.out.println(element);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("================================================\n");
    }

}
