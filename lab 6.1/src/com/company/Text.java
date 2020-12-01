package com.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Text implements Serializable {
    private List<Sentence> sentences;
    private String title;

    public Text(){
        sentences=new LinkedList<>();
        title="Без заголовка";
    }

    public void addText(String text){
        Sentence sen=new Sentence();
        String[] arr=text.split(" ");
        for (String s: arr) {
            Word w=new Word(s);
            sen.addWord(w);
        }
        sentences.add(sen);
    }

    public void addText(Word word){
        Sentence s=new Sentence();
        s.addWord(word);
        sentences.add(s);
    }

    public void addText(Sentence s){
        sentences.add(s);
    }

    public String getTextString(){
        String s=new String();

        for (Sentence sen: sentences) {
            s=s.concat(sen.getSentenceString()).concat(" ");
        }
        return s;
    }

    public List getTextList(){
        return sentences;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void textOutput(){
        System.out.println(getTextString());
    }

    public void titleOutput(){
        System.out.println(getTitle());
    }

    @Override
    public String toString(){
        return "\t\tЗаголовок текста - "+getTitle()+".\nТекст - "+getTextString();
    }
}
