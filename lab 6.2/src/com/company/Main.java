package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan=new Scanner(System.in);

        String nameFile1="random.txt";
        String nameFile2="sort.txt";

        int size=0;
        try {
            System.out.print("Введите размер массива: ");
            if (scan.hasNextInt())
                size = scan.nextInt();
            else
                throw new Exception("Вы ввели не число");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        int[] array=new int[size];
        int[] arrayread=new int[size];
        int[] sortarrayread=new int [size];
        for (int i=0; i<size; i++)
            array[i]=(int)(Math.random()*100);

        File file1=null;
        FileWriter fileWriter1=null;
        FileReader fileReader1=null;
        Scanner scanner1=null;
        File file2=null;
        FileWriter fileWriter2=null;
        FileReader fileReader2=null;
        Scanner scanner2=null;

        try{
            file1=new File(nameFile1);
            fileWriter1=new FileWriter(file1);

            System.out.println("Запись начального массива в файл.");
            for (int i=0; i<size; i++){
                fileWriter1.write(array[i]+" ");
                fileWriter1.flush();
            }

            System.out.println("Чтение массива из файла:");
            fileReader1=new FileReader(file1);
            scanner1=new Scanner(fileReader1);

            for (int i=0; i<size; i++){
                arrayread[i]=scanner1.nextInt();
                System.out.print(arrayread[i]+" ");
            }
            System.out.println();

            System.out.println("Массив отсортирован.");
            Arrays.sort(arrayread);
            file2=new File(nameFile2);
            fileWriter2=new FileWriter(file2);

            System.out.println("Запись отсортированного массива в файл.");
            for (int i=0; i<size; i++){
                fileWriter2.write(arrayread[i]+" ");
                fileWriter2.flush();
            }

            System.out.println("Чтение отсортированного массива из файла:");
            fileReader2=new FileReader(file2);
            scanner2=new Scanner(fileReader2);

            for (int i=0; i<size; i++){
                sortarrayread[i]=scanner2.nextInt();
                System.out.print(sortarrayread[i]+" ");
            }
            System.out.println();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("Закрытие потоков.");
                fileWriter1.close();
                fileReader1.close();
                scanner1.close();
                fileWriter2.close();
                fileReader2.close();
                scanner2.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
