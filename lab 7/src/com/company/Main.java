package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String filename1="text.txt";
        String filename2="revtext.txt";
        List<String> list=new ArrayList<>();
        List<String> rev_list= new ArrayList<>();

        File file1=null;
        File file2=null;
        FileReader fileReader=null;
        Scanner scanner=null;
        FileWriter fileWriter=null;

        try{
            file1=new File(filename1);
            fileReader=new FileReader(file1);
            scanner=new Scanner(fileReader);

            System.out.println("Чтение строк из файла "+filename1);
            while(scanner.hasNext()){
                list.add(scanner.nextLine());
            }

            for (int i=0; i<list.size(); i++)
                System.out.println(list.get(i));

            System.out.println("\nСтроки в обратном порядке:");
            for (int i=list.size()-1; i>=0; i--)
                rev_list.add(list.get(i));

            for (int i=0; i<rev_list.size(); i++)
                System.out.println(rev_list.get(i));

            file2=new File(filename2);
            fileWriter=new FileWriter(file2);

            System.out.println("\nЗапись этих строк в файл.");
            for (int i=0; i< rev_list.size(); i++){
                String str= rev_list.get(i);
                fileWriter.write(str+"\n");
                fileWriter.flush();
            }
            System.out.println("Строки записаны в файл.");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("Закрытие потоков.");
                scanner.close();
                fileReader.close();
                fileWriter.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}