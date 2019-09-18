package com.company.io;

import com.company.Models.AccountInfo;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class DAOClass {
    //protected AccountInfo user;
    protected static final String file = "C:\\Users\\dinhh\\1908-aug09-java-aug\\Project_0\\com\\company\\resources\\data.txt";
    protected static HashMap<String, AccountInfo> data = new HashMap();

    public static HashMap<String, AccountInfo> getData() {
        return data;
    }

    public DAOClass() {
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            this.data =  (HashMap<String, AccountInfo>) fileInput.readObject();
            fileInput.close();
            //data.get(userName).getUserInfo();

        }
        catch(FileAlreadyExistsException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public AccountInfo Read(String userName){
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            Object userInfo =  fileInput.readObject();
            fileInput.close();
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
        try {
            ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
            data.put(userName, user);
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
