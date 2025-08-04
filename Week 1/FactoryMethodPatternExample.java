// File: FactoryMethodPatternExample.java

import java.io.PrintStream;

import javax.swing.text.Document;

/**
 * The main test class to demonstrate the Factory Method Pattern.
 */
public class FactoryMethodPatternExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern Demo ---");

        // The client code decides which factory to use.
        // The factory then handles the creation of the specific object.

        // Create a Word document using its factory
        System.out.println("\nUsing WordDocumentFactory...");
        new WordDocumentFactory();
        // Create a PDF document using its factory
        System.out.println("\nUsing PdfDocumentFactory...");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        ((PrintStream) myPdfDoc).close();

        // Create an Excel document using its factory
        System.out.println("\nUsing ExcelDocumentFactory...");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document myExcelDoc = excelFactory.createDocument();
        ((PrintStream) myExcelDoc).close();
    }
}
