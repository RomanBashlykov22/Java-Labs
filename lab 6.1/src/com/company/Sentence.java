package com.company;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Sentence implements Serializable {
    private List<Word> sentence;

    public Sentence(){
        sentence=new LinkedList<>();
    }

    public void addWord(Word word){
        sentence.add(word);
    }

    public void addWord(String word){
        Word w=new Word(word);
        sentence.add(w);
    }

    public String getSentenceString(){
        String s=new String();

        for (Word words: sentence) {
            s=s.concat(words.getWord()).concat(" ");
        }
        return s;
    }

    public List getSentenceList(){
        return sentence;
    }

    @Override
    public String toString(){
        return "Предложение - "+getSentenceString();
    }
}