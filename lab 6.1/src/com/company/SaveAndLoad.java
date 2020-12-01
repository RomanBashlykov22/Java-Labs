package com.company;

import java.io.*;

public class SaveAndLoad {
    public static void save(Text text, String name){
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;

        try{
            fileOutputStream=new FileOutputStream(name);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(text);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (objectOutputStream!=null){
                try{
                    objectOutputStream.close();
                    fileOutputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static Text load(String name){
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        Text text=null;

        try{
            fileInputStream=new FileInputStream(name);
            objectInputStream=new ObjectInputStream(fileInputStream);
            text=(Text)objectInputStream.readObject();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            if (objectInputStream!=null){
                try{
                    objectInputStream.close();
                    fileInputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return text;
    }
}