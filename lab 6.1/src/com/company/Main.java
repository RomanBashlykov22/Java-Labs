package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Word word1=new Word("Лабораторная");
        Word word2=new Word("работа");

        Sentence sentence1=new Sentence();
        sentence1.addWord(word1);
        sentence1.addWord(word2);
        sentence1.addWord("номер");
        sentence1.addWord("6.");

        Sentence sentence2=new Sentence();
        sentence2.addWord("Задание");
        sentence2.addWord("первое.");

        Text text1=new Text();
        text1.addText(sentence1);
        text1.addText(sentence2);
        text1.setTitle("ООП Java");
        System.out.println(text1.toString());

        Text text2=new Text();
        text2.addText("Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст, заголовок текста.");
        text2.setTitle("Задача 1");
        System.out.println("\t\t"+text2.getTitle()+"\n"+text2.getTextString());

        SaveAndLoad.save(text1, "text1.txt");
        SaveAndLoad.save(text2, "text2.txt");
        Text loadText1=SaveAndLoad.load("text1.txt");
        Text loadText2=SaveAndLoad.load("text2.txt");
        System.out.println("Загруженный текст 1: "+loadText1);
        System.out.println("Загруженный текст 2: "+loadText2);
    }
}

