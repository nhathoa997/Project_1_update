package com.company.io;

import com.company.Models.AccountInfo;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class EmpDAO {
    protected static final String file = "C:\\Users\\dinhh\\1908-aug09-java-aug\\src\\com\\company\\resources\\empData";
    protected static HashMap<String, AccountInfo> data = new HashMap();

    public AccountInfo Read(String userName){
        try{
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            Object userInfo =  fileInput.readObject();
            fileInput.close();
            System.out.println("Have been Read");
            //data.get(userName).getUserInfo();
            return (AccountInfo) data.get(userName);
        }
        catch(FileAlreadyExistsException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Write(String userName, AccountInfo user){
        try{
            ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
            data.put(userName, user);
            System.out.println("Have been Written");
            fileOutput.writeObject(data);
            fileOutput.close();

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
