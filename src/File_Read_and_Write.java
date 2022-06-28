// 自定义类，可实现功能：
// 1、创建自定义文件名的文件
// 2、读入用户的输入内容并写入文件
// 3、读出所有已存在的"*.txt"文件
// 4、读出给定"*.txt"文件内容

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class File_Read_and_Write {

    private static final String ROOT = "." + File.separator;

    // 创建文件夹
    public void Create_Folder(String Folder_Path) {

        File Folder = new File(Folder_Path);
        boolean Folder_Exist = false; // 文件夹是否存在
        if (Folder.exists() && Folder.isDirectory()) {
            System.out.println("-->> 文件夹<" + Folder_Path + ">已存在!");
            Folder_Exist = true;
        } else {
            Folder_Exist = Folder.mkdirs();
            if (Folder_Exist) {
                System.out.println("-->> 文件夹<" + Folder_Path + ">已创建!");
            } else {
                System.out.println("-->> 警告：文件夹<" + Folder_Path + ">创建失败!");
            }
        }
    }

    // 指定路径下创建文件
    public File Create_File(String File_Path, String File_Name) throws IOException {

        // 判断文件夹是否存在
        File Folder = new File(File_Path);
        boolean Folder_Exist = false;
        if (!Folder.exists()) {
            Folder_Exist = Folder.mkdirs();
        } else {
            Folder_Exist = true;
        }
        File file;
        if (Folder_Exist) {
            // File file1 = new File(File_Path + File_Name);
            file = new File(File_Path + File_Name);
            if (file.exists()) {
                System.out.println("-->> 文件<" + File_Path + File_Name + ">已存在!");
            } else {
                boolean File_exist = file.createNewFile();
                if (File_exist) {
                    System.out.println("-->> 文件<" + File_Path + File_Name + ">创建成功!");
                } else {
                    System.out.println("-->> 警告：文件<" + File_Path + File_Name + ">创建失败!");
                }
            }
        } else {
            file = null;
        }
        return file;
    }

    // 根目录下创建文件
    public File Create_File(String File_Name) {

        File file = new File(ROOT + File_Name);
        if (!file.exists()) {
            System.out.println("-->> 警告：文件创建失败!");
            file = null;
        }
        return file;

    }


    // 读取指定文件夹下的文件列表
    public File[] File_List_Reader(String Folder_Path) {
        File[] File_List;
        File Folder = new File(Folder_Path);
        // 如果这个路径是文件夹
        if (Folder.isDirectory()) {
            // 获取路径下的所有文件
            File_List = Folder.listFiles();
            if (File_List.length > 0) {
                System.out.println("目录 <" + Folder_Path + "> 的文件如下：");
            }
            for (int i = 0; i < File_List.length; i++) {
                // 如果还是文件夹 递归获取里面的文件
                if (File_List[i].isDirectory()) {
                    //System.out.println("-->> 目录：" + File_List[i].getPath());
                    File_List_Reader(File_List[i].getPath());
                } else {
                    System.out.println("-->> " + File_List[i].getName());
                }
            }
        } else {
            System.out.println("-->> <" + Folder_Path + "> 不是文件夹");
            File_List = null;
        }
        return File_List;
    }

    // 文件内容写入
    public void File_Writer(File file_name, String Content_to_Write) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(file_name);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println(" <" + file_name + "> 写入的内容为：\n" + Content_to_Write);

            pw.println(Content_to_Write);
            pw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void File_Writer_Manual_Entry(File file_name) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (
                FileOutputStream fos = new FileOutputStream(file_name);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("请输入要写入 <" + file_name + "> 的内容（输入空行结束）：");
            while (true) {
                String Content_to_Write = scanner.nextLine().trim();
                //System.out.println("写入的内容为: " + Content_to_Write);
                if (Content_to_Write.trim().isBlank()) {
                    System.out.println("====== <" + file_name + "> 写入结束！======");
                    break;
                } else {
                    pw.println(Content_to_Write);
                    pw.flush();
                    System.out.println("-->> <" + file_name + "> 成功写入：<" + Content_to_Write + ">");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // 文件内容读取(UTF_8)
    public void File_Reader_UTF_8(File file_name) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(file_name);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader fr = new BufferedReader(isr);
        ) {
            String line = null;
            //System.out.println("-----------------------------------------------------------");
            System.out.println("-->> <" + file_name + "> 文件中的内容如下：");
            while ((line = fr.readLine()) != null) {
                System.out.println(line.trim());
            }
            //System.out.println("-----------------------------------------------------------");
        }
    }

    public void File_Reader_ASCII(File file_name) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(file_name);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.US_ASCII);
                BufferedReader fr = new BufferedReader(isr);
        ) {
            String line = null;
            //System.out.println("-----------------------------------------------------------");
            System.out.println("-->> <" + file_name + "> 文件中的内容如下：");
            while ((line = fr.readLine()) != null) {
                System.out.println(line.trim());
            }
            //System.out.println("-----------------------------------------------------------");
        }
    }

    // 以此读取文件夹下的所有文件内容
    public void Batch_File_Reader(String Folder_Path) throws IOException {
        File[] File_List;
        File Folder = new File(Folder_Path);
        // 如果这个路径是文件夹
        if (Folder.isDirectory()) {
            // 获取路径下的所有文件
            File_List = Folder.listFiles();
            for (File file_i : File_List) {
                // 如果还是文件夹 递归获取里面的文件
                if (file_i.isDirectory()) {
                    Batch_File_Reader(file_i.getPath());
                } else {
                    File_Reader_UTF_8(file_i);
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("-->> <" + Folder_Path + "> 不是文件夹");
            File_List = null;
        }
    }

}
