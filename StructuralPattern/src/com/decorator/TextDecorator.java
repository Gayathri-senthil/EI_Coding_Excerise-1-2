package com.decorator;
public abstract class TextDecorator implements TextEditor {
    protected TextEditor decoratedTextEditor;

    public TextDecorator(TextEditor decoratedTextEditor) {
        this.decoratedTextEditor = decoratedTextEditor;
    }

    public void display() {
        decoratedTextEditor.display();
    }
}
