package com.company.io;

import com.company.Models.AccountInfo;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class DAOClass {
    //protected AccountInfo user;
    private static final String address = "C:\\Users\\dinhh\\1908-aug09-java-aug\\Project_0\\com\\company\\resources\\data.txt";
    private static HashMap<String, AccountInfo> customer_data = new HashMap<>();

    public AccountInfo Read(String userName) {
        try {
            FileInputStream istream = new FileInputStream(address);
            ObjectInputStream ois = new ObjectInputStream(istream);
            this.customer_data = (HashMap<String, AccountInfo>) ois.readObject();
            ois.close();
            return customer_data.get(userName);
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
        return null;
    }

    public void Write(String userName, AccountInfo user){
        try {
            FileOutputStream fileout = new FileOutputStream(address);
            ObjectOutputStream output = new ObjectOutputStream(fileout);

            customer_data.put(userName, user);
            output.writeObject(customer_data);
            output.close();
            fileout.close();


        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
