/**
 * Program logical class
 */

package appdata;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.io.File;

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
    public void openLocalFile(TextArea textArea) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        File document;
        Scanner scanner;

        document = fileChooser.showOpenDialog(null);

        if (document.isFile()) {
            scanner = new Scanner(document);

            while (scanner.hasNextLine()) {
                String content = scanner.nextLine() + "\n";
                textArea.appendText(content);
            }
        }
    }


}
