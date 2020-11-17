import Data.User;
import Folder.FolderUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by DevHyeon on 2020.11.17
 * PC : MacBook Pro (16-inch, 2019)
 * OS Version : macOS Catalina - 10.15.7(19H2)
 * */
public class MainUI {

    public static void main(String[] args) {
        System.out.println("Create Project");
        //Create Folder
        FolderUtils.createFolder();

        //Delete Folder
//        FolderUtils.deleteFolder();

        //Delete Files
//        FolderUtils.deleteFiles();


        //CreateData
        ArrayList<User> userList = createList();
        for (User user : userList) {
            System.out.println(user.toString());
        }

    }

    /* Create Data */
    public static ArrayList<User> createList() {
        ArrayList<User> users = new ArrayList<>();
        for (int i=0; i<10; i++) {
            User user = new User();
            user.setUserUnqId("KEY"+i);
            user.setUserName("DevHyeon"+i);
            user.setUserAge(20+i);
            user.setUserGender("Gender");
            user.setUserBirth("birth:"+i);
            users.add(user);
        }
        System.out.println("create.");
        return users;
    }
}


