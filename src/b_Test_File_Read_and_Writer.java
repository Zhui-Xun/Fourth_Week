import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class b_Test_File_Read_and_Writer {
    public static void main(String[] args) throws IOException {
        // 类的实现
        File_Read_and_Write FILE = new File_Read_and_Write();
        Scanner scanner = new Scanner(System.in);

        // 文件路径设置
        String ROOT = "." + File.separator;
        String folder_Path = (ROOT + "File_Test");

        // 测试文件夹创建
        System.out.println("--------------------------------------------");
        System.out.println("====== 创建文件夹 ======");
        FILE.Create_Folder(folder_Path);
        FILE.Create_Folder(folder_Path + File.separator + "二级目录");
        FILE.Create_Folder(folder_Path + File.separator + "二级目录" + File.separator + "三级目录");
        // 输入自定义文件夹
        System.out.println("请输入要创建的文件夹路径：");
        String New_Folder_Path = scanner.nextLine().trim();
        FILE.Create_Folder(ROOT + New_Folder_Path);
        System.out.println("--------------------------------------------\n");

        // 测试文件创建
        System.out.println("--------------------------------------------");
        System.out.println("====== 创建文件 ======");
        File file1 = FILE.Create_File(folder_Path + File.separator, "Test_txt_1.txt");
        File file2 = FILE.Create_File(folder_Path + File.separator, "Test_txt_2.txt");
        File file3 = FILE.Create_File(folder_Path + File.separator + "二级目录" + File.separator, "Test_txt_3.txt");
        File file4 = FILE.Create_File(folder_Path + File.separator + "二级目录" + File.separator + "三级目录" + File.separator, "Test_txt_4.txt");
        System.out.println("--------------------------------------------\n");

        // 测试文件写入
        System.out.println("--------------------------------------------");
        System.out.println("====== 文件内容写入 ======");
        FILE.File_Writer(file1, "第一行，123\n第二行，456\n第三行，789");
        FILE.File_Writer_Manual_Entry(file2); // 手动输入内容
        System.out.println("--------------------------------------------\n");


        // 测试读文件夹下的文件列表
        System.out.println("--------------------------------------------");
        System.out.println("====== 读取指定文件夹下的文件列表 ======");
        File[] File_List = FILE.File_List_Reader(folder_Path);
        System.out.println("--------------------------------------------\n");

        // 测试读取指定文件的文件内容
        System.out.println("--------------------------------------------");
        System.out.println("====== 读取指定文件的文件内容 ======");
        FILE.File_Reader_UTF_8(file1);
        System.out.println("--------------------------------------------\n");

        // 测试读取指定文件下所有文件的文件内容
        System.out.println("--------------------------------------------");
        System.out.println("====== 读取指定文件下所有文件的文件内容 ======");
        FILE.Batch_File_Reader(ROOT + "实验记录");
        System.out.println("--------------------------------------------\n");
    }
}
