package com.company;

import java.io.Serializable;

public class Word implements Serializable {
    private String word;

    public Word(String word){
        this.word=word;
    }

    public String getWord(){
        return word;
    }

    @Override
    public String toString(){
        return "Слово - "+getWord();
    }
}
