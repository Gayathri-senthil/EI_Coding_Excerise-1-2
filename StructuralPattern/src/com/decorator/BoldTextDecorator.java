package com.decorator;
public class BoldTextDecorator extends TextDecorator {
    public BoldTextDecorator(TextEditor decoratedTextEditor) {
        super(decoratedTextEditor);
    }

    @Override
    public void display() {
        System.out.print("**");
        decoratedTextEditor.display();
        System.out.print("**");
    }
}
