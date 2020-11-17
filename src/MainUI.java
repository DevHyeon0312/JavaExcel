import Data.User;
import Folder.FolderUtils;

import java.util.ArrayList;

/**
 * Created by DevHyeon on 2020.11.17
 * */
public class MainUI {

    public static void main(String[] args) {
        System.out.println("Create Project");
        //Create Folder
//        FolderUtils.createFolder();

//        FolderUtils.deleteFolder();

        FolderUtils.deleteFiles();
    }

//    private static ArrayList<User> createList() {
//        ArrayList<User> users = new ArrayList<>();
//        for (int i=0; i<10; i++) {
//            User user = new User();
//            user.setUserUnqId("KEY"+i);
//            user.setUserName("DevHyeon"+i);
//            user.setUserAge(20+i);
//            user.setUserGender("Gender");
//            user.setUserBirth("birth:"+i);
//        }
//        return users;
//    }
}


