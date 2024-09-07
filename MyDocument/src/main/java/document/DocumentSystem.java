package document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DocumentSystem {

    // DO NOT MODIFY
    private static final String FOLDER_NAME = "output";
    private static final Stack<Memento> mementoUndo = new Stack<>();
    private static final Stack<Memento> mementoRedo = new Stack<>();


    public static Document createDocument(){
        return new Document(0.0, null);
    }

    private static void saveState(Stack<Memento> mementoStack, Document document) {
        mementoStack.push(document.createMemento());
    }

    private static void restoreState(Stack<Memento> mementoStack, Document document) {
        Memento lastMemento = mementoStack.pop();
        document.setMemento(lastMemento);
    }

    public static void append(Document document, String text) {
        saveState(mementoUndo, document);
        mementoRedo.clear();
        document.append(text);

    }

    public static void undo(Document document) {
        if (!mementoUndo.isEmpty()) {
            saveState(mementoRedo, document);
            restoreState(mementoUndo, document);
        }
    }

    public static void redo(Document document) {
        if (!mementoRedo.isEmpty()) {
            saveState(mementoUndo, document);
            restoreState(mementoRedo, document);
        }
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