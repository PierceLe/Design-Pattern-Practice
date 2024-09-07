package document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DocumentSystem {

    // DO NOT MODIFY
    private static final String FOLDER_NAME = "output";
//    private static final Stack<MemetoDocument>

    public static Document createDocument(){
        return null;
    }

    public static void append(Document document, String text) {

    }

    public static void undo(Document document) {

    }

    public static void redo(Document document) {

    }

    public static void main(String[] args) {
        // DO NOT MODIFY
        test();
    }

    public static void test(){
        // DO NOT MODIFY
        Document document = createDocument();
        File folder = new File(FOLDER_NAME);
        folder.mkdir();

        int i = 0;

        while (i < 3){
            append(document, String.format("Line %d", i));
            i += 1;
        }

        writeDocumentToFile(document, String.format("original.txt", i));

        undo(document);
        writeDocumentToFile(document, "1-undo.txt");
        undo(document);
        writeDocumentToFile(document, "2-undo.txt");

        redo(document);
        writeDocumentToFile(document, "3-redo.txt");
        redo(document);
        writeDocumentToFile(document, "4-redo.txt");
    }


    public static void writeDocumentToFile(Document document, String filename){
        // DO NOT MODIFY
        try (FileWriter writer = new FileWriter(FOLDER_NAME + "/" + filename)) {
            writer.write(document.toString());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
    }
}