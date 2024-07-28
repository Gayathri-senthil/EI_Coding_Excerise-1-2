package com.decorator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text: ");
        String inputText = scanner.nextLine();

        TextEditor textEditor = new BasicTextEditor(inputText);

        while (true) {
            System.out.println("Enter the style (bold, italic, both, none) or 'exit' to quit: ");
            String style = scanner.nextLine();

            if (style.equalsIgnoreCase("exit")) {
                break;
            }

            if (style.equalsIgnoreCase("bold")) {
                textEditor = new BoldTextDecorator(new BasicTextEditor(inputText));
            } else if (style.equalsIgnoreCase("italic")) {
                textEditor = new ItalicTextDecorator(new BasicTextEditor(inputText));
            } else if (style.equalsIgnoreCase("both")) {
                textEditor = new ItalicTextDecorator(new BoldTextDecorator(new BasicTextEditor(inputText)));
            } else {
                textEditor = new BasicTextEditor(inputText);
            }

            textEditor.display();
            System.out.println();
        }

        scanner.close();
    }
}

