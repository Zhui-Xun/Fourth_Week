// 1、Java异常处理
// 2、Collection类中的List、Set、Map
// 3、Java中的File类

import a_2_Subfun.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class a2_Exception_and_Collection_and_Map {
    public static void main(String[] args) throws MyException, IOException {

        // 1.1、Java RTE异常处理
        Caller_1 caller1 = new Caller_1();

//        System.out.println("====== RTE调用开始 ======");
//        caller1.caller2_RTException();
//        System.out.println("====== RTE调用结束 ======");

        // 1.2、Java EX异常处理
//        System.out.println("====== EX调用开始 ======");
//        caller1.caller2_Exception();
//        System.out.println("====== EX调用结束 ======");


        // 2.1、Collection—List
//        Collection_List collection_list = new Collection_List();
//        collection_list.Create_Collection_List();

        // 2.2、Collection—Set
//        Collection_Set collection_set = new Collection_Set();
//        collection_set.printCollection(collection_set.addElementsToCollection(new HashSet()));
//        collection_set.printCollection(collection_set.addElementsToCollection(new ArrayList()));

        // 2.3、Collection—Map
//        Collection_Map collection_map = new Collection_Map();
//        collection_map.Collection_Map_Test();

        // 3、File类
        Class_File class_file = new Class_File();
        class_file.Class_File_Test();




    }
}




