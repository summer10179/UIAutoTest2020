package TestUi.Utils;


import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static boolean createFile(String destFileName) throws IOException {
        File file=new File(destFileName);
        if(file.exists()){
            System.out.println("创建单个文件"+destFileName+"失败，目标文件已存在！");
            return false;
        }
        if(destFileName.endsWith(File.separator)){
            System.out.println("创建单个文件"+destFileName+"失败，目标文件已存在！");
            return false;
        }

        //判断目标文件所在的目录是否存在
        if(!file.getParentFile().exists()){
            System.out.println("目录文件所在目录不存在，准备创建它！");
            if(!file.getParentFile().mkdirs()){
                System.out.println("创建目标文件所在目录失败！");
                return false;
            }
        }

        if(file.createNewFile()){
            System.out.println("单个文件"+destFileName+"创建成功！");
            return true;
        }else{
            System.out.println("单个文件"+destFileName+"创建失败！");
            return false;
        }

    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已存在！");
            return false;
        }
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }

}
