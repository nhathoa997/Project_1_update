package com.company.io;

import com.company.Models.EmployeeAccount;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class EmpDAO {
    private static final String file = "C:\\Users\\dinhh\\1908-aug09-java-aug\\Project_0\\com\\company\\resources\\empdata.txt";
    private static HashMap<String, EmployeeAccount> emp_data = new HashMap();

    public EmployeeAccount Read(String userName) {
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            this.emp_data =  (HashMap<String, EmployeeAccount>) fileInput.readObject();
            fileInput.close();
            return (EmployeeAccount) emp_data.get(userName);

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


    public void Write(String userName, EmployeeAccount user){
        try {
            ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
            emp_data.put(userName, user);
            fileOutput.writeObject(emp_data);
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
