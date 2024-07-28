package com.decorator;
public class BasicTextEditor implements TextEditor {
    private String text;

    public BasicTextEditor(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println(text);
    }
}
