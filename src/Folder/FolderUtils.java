package Folder;

import java.io.File;

/**
 * Created by DevHyeon on 2020.11.17
 * PC : MacBook Pro (16-inch, 2019)
 * OS Version : macOS Catalina - 10.15.7(19H2)
 * */
public class FolderUtils {

    /* Folder Create */
    public static void createFolder() {
        String root = new File("").getPath();
        String path = root+"Excels"; //폴더 경로
        File Folder = new File(path);

        //if not exist Created Folder.
        if (!Folder.exists()) {
            try{
                Folder.mkdir(); //Created Folder
                System.out.println(path+"SUCCESS.");
            }
            catch(Exception e){
                e.getStackTrace();
                System.out.println(path+"FAIL.");
            }
        } else {
            System.out.println(path+"EXISTED.");
        }
    }

    /* Folder Delete */
    public static void deleteFolder() {
        String root = new File("").getPath();
        String path = root+"Excels"; //폴더 경로
        File Folder = new File(path);

        while(Folder.exists()) {
            File[] folder_list = Folder.listFiles(); //파일리스트 얻어오기

            for (int j = 0; j < folder_list.length; j++) {
                folder_list[j].delete(); //파일 삭제
                System.out.println("파일이 삭제되었습니다.");
            }

            if(folder_list.length == 0 && Folder.isDirectory()){
                Folder.delete(); //대상폴더 삭제
                System.out.println("폴더가 삭제되었습니다.");
            }
        }
    }


    /* Files Delete in Folder */
    public static void deleteFiles() {
        String root = new File("").getPath();
        String path = root+"Excels"; //폴더 경로
        File Folder = new File(path);

        while(Folder.exists()) {
            File[] folder_list = Folder.listFiles(); //파일리스트 얻어오기

            for (int j = 0; j < folder_list.length; j++) {
                folder_list[j].delete(); //파일 삭제
                System.out.println("파일이 삭제되었습니다.");
            }

            break;
        }
    }
}
