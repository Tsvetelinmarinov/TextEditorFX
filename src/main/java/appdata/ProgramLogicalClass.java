/**
 * Program logical class
 */

package appdata;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 */
public class ProgramLogicalClass {

    //Създай нов файл
    public void createNewFile(TextArea textArea) {
        JOptionPane.showMessageDialog(
                null,
                "Unsaved data will be lost!",
                "Warning",
                JOptionPane.WARNING_MESSAGE
        );

        boolean hasNotText = textArea.getText().isEmpty();

        if (! hasNotText) {
            textArea.setText("");
        }
    }



    //Отвори файл от сисметама
    public void openLocalFile(TextArea textArea) throws Exception {
        FileChooser fileChooser = new FileChooser();
        File document;
        Scanner scanner;

        document = fileChooser.showOpenDialog(null);

        if (document.isFile()) {
            scanner = new Scanner(document);

            while (scanner.hasNextLine()) {
                String fileContent = scanner.nextLine() + "\n";
                textArea.appendText(fileContent);
            }
        }
        else {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid file!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }

    }



    //Запамети файл на компютъра
    public void exportDataToLocalFile(TextArea textArea) throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        File file;
        PrintWriter outputStream;

        FileNameExtensionFilter txt = new FileNameExtensionFilter("text file", "txt");

        fileChooser.setFileFilter(txt);

        int fileChooserResponse = fileChooser.showSaveDialog(null);

        boolean pathIsSelected = fileChooserResponse == JFileChooser.APPROVE_OPTION;

        if (pathIsSelected) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            outputStream = new PrintWriter(file);
            outputStream.println(textArea.getText());
            outputStream.close();
        }
        else {
            JOptionPane.showMessageDialog(
                    null,
                    "Path is not selected!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }



    //Отвори нов прозорец
    public void createNewWindow(Scene scene) {
        Stage stage = new Stage();
        stage.setTitle("TextEditor++");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    //Рестарт
    public void rebootApplication(Stage stage, TextArea textArea) {
        boolean hasContent = !textArea.getText().isEmpty();

        if (hasContent) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Unsaved data will be lost!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            textArea.setText("");
        }

        stage.close();
        stage.show();
    }



    //Изход от програмата
    public void terminateApplication(TextArea textArea) {
        boolean hasText = !textArea.getText().isEmpty();

        if (hasText) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Unsaved data will be lost!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }

        System.exit(0);
    }

}