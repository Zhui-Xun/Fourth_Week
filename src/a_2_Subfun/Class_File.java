package a_2_Subfun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Class_File {

    private static final String ROOT = "." + File.separator;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Class_File_Test();

    }

    public static void Class_File_Test() throws IOException {
        // TODO 文件夹操作
        File dir = createDirs();
        System.out.println("\n是否要对文件夹 <" + dir.toString() + "> 进行重命名?(yes or no)");
        String DirToRename = scanner.next().trim().toUpperCase();
        File newDir;
        if (DirToRename.equals("YES")) {
            newDir = renameDir(dir);
            System.out.println("文件夹已重命名为：<" + newDir + ">");
        } else {
            newDir = dir;
        }
        if (newDir == null) return;


        // TODO 文件操作
        // 创建文件
        System.out.println("\n------------------------------------------");
        String fileName = createFiles(newDir);
        System.out.println("------------------------------------------\n");

        // 文件重命名
        System.out.println("\n------------------------------------------");
        System.out.println("是否要对文件 <" + fileName + "> 进行重命名?(yes or no)");
        String FileToRename = scanner.next().trim().toUpperCase();
        String fileNameNew;
        if (FileToRename.equals("YES")) {
            fileNameNew = renameFiles(newDir, fileName);
        } else {
            fileNameNew = fileName;
        }
        System.out.println("------------------------------------------\n");

        // 删除文件
        System.out.println("\n------------------------------------------");
        deleteFiles(newDir, fileNameNew);
        System.out.println("------------------------------------------\n");

        // 删除文件夹
        deleteDir(newDir);
    }

    private static void deleteDir(File newDir) {

        System.out.println("删除文件夹？ (yes or no)");
        String deleteDir = scanner.next().trim().toUpperCase();
        // 删除文件夹的前提是文件夹是空的，否则将删除失败
        if (newDir.listFiles().length > 0) {
            System.out.println("文件夹下存在文件，删除失败！");
        } else if (deleteDir.equals("YES")) {
            System.out.println("文件夹 <" + newDir + "> 删除: " + newDir.delete());
        }

    }

    private static void deleteFiles(File newDir, String fileNameNew) {

        System.out.println("删除文件？ (yes or no)");
        String deleteFiles = scanner.next().trim().toUpperCase();

        if (deleteFiles.equals("YES")) {
            for (int i = 0; i < 10; i++) {
                File fn = new File(newDir, fileNameNew + "-" + i + ".txt");
                if (fn.delete()) {
                    System.out.println("文件 <" + fn.toString() + "> 删除成功!");
                } else {
                    System.out.println("文件 <" + fn.toString() + "> 删除失败!!!");
                }
            }
        }

    }

    private static String renameFiles(File newDir, String fileName) {
        System.out.println("请输入新的文件名的前缀：");
        String fileNameNew = scanner.next().trim();

        for (int i = 0; i < 10; i++) {
            File f = new File(newDir, fileName + "-" + i + ".txt");
            File fn = new File(newDir, fileNameNew + "-" + i + ".txt");
            System.out.println("重命名文件 <" + f.getName() + "> ：" + f.renameTo(fn));
        }
        return fileNameNew;
    }

    private static String createFiles(File newDir) throws IOException {
        System.out.println("请输入文件名的前缀：");
        String fileName = scanner.next().trim();

        for (int i = 0; i < 10; i++) {

            File f = new File(newDir, fileName + "-" + i + ".txt");
            if (f.createNewFile()) {
                System.out.println("文件 <" + f.getName() + "> 创建成功!");
            } else {
                if (f.exists()) {
                    System.out.println("文件 <" + f.getName() + "> 已存在!");
                } else {
                    System.out.println("文件 <" + f.getName() + "> 创建失败!!!");
                }
            }
        }
        return fileName;
    }

    private static File renameDir(File dir) {
        System.out.println("请输入新的文件夹的名字：");
        String newDirName = scanner.next().trim();
        File newDir = new File(dir.getParentFile(), newDirName);
        boolean renameSuccess = dir.renameTo(newDir);
        if (renameSuccess) {
            System.out.println("改名为 <" + newDirName + "> 成功");
        } else {
            System.out.println("改名为 <" + newDirName + "> 失败");
            return null;
        }
        return newDir;
    }

    private static File createDirs() {
        List<String> pathList = new ArrayList<>();
        while (true) {
            System.out.println("请输入文件路径（如果为空则结束）：");
            String path = scanner.nextLine();
            if (path.isBlank()) {
                break;
            }
            pathList.add(path);
        }

        return createDir(pathList.toArray(new String[0]));
    }

    private static File createDir(String... restPaths) {
        String rest = joinRestDir(restPaths);
        File dir = new File(ROOT, rest);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("文件夹 <" + dir.toString() + "> 已存在!");
            return dir;
        } else {
            boolean createSuccess = dir.mkdirs();
            if (createSuccess) {
                System.out.println("文件夹 <" + ROOT + rest + "> 已创建！");
                return dir;
            } else {
                throw new IllegalArgumentException("无法在" + ROOT + "下创建" + rest);
            }
        }
    }

    private static String joinRestDir(String... restPaths) {
        return Arrays.stream(restPaths).map(String::trim).collect(Collectors.joining(File.separator));
    }

}

