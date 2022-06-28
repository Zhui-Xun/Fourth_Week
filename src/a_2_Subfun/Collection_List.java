package a_2_Subfun;

import java.util.*;

public class Collection_List {
    public static void main(String[] args) {

        Create_Collection_List();

    }

    public static void Create_Collection_List() {

        ArrayList arraylist = new ArrayList();
        printCollection(arraylist);
        printCollection(addElementsToCollection(arraylist));
        printCollection(addElementsToCollection(new LinkedList()));
        printList((List) addElementsToCollection(new ArrayList()));

    }

    public static Collection addElementsToCollection(Collection collection) {
        System.out.println("向 <" + collection.getClass() + "> 中添加元素:");
        for (int i = 0; i < 5; i++) {
            collection.add("str-" + (i % 5));
        }
        return collection;
    }

    public static void printCollection(Collection collection) {
        // System.out.println();
        System.out.println("输出 <" + collection.getClass() + "> 中的元素，共" + collection.size() + "个: ");
        try {
            for (Object element : collection) {
                System.out.println(element);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("=======================================\n");
    }

    public static void printList(List list) {
        //System.out.println();
        System.out.println("输出 <" + list.getClass() + "> 中的元素，共" + list.size() + "个");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
