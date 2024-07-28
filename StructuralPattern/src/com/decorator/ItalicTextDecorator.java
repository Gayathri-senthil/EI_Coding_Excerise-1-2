package com.decorator;
public class ItalicTextDecorator extends TextDecorator {
    public ItalicTextDecorator(TextEditor decoratedTextEditor) {
        super(decoratedTextEditor);
    }

    @Override
    public void display() {
        System.out.print("_");
        decoratedTextEditor.display();
        System.out.print("_");
    }
}