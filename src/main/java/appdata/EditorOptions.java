/**
 * Editor options
 */

package appdata;

import javafx.scene.control.TextArea;

/**
 *
 */
public class EditorOptions {


    //Съдържа текста от едитора
    private String textAreaContent;



    //Селектирай целия текст
    public void selectAllTheText(TextArea textArea) {
        textArea.selectAll();
    }




    //Копирай текст
    public void copySelectedText(TextArea textArea) {
        boolean hasText = !textArea.getText().isEmpty();

        if (hasText) {
            setTextAreaContent(textArea.getSelectedText());
        }
    }



    //Постави копирания текст
    public void pasteCopiedText(TextArea textArea) {
        boolean hasCopiedText = !getTextAreaContent().isEmpty();

        if (hasCopiedText) {
            textArea.appendText(getTextAreaContent());
        }
    }




    //Изтрий всичко
    public void deleteContent(TextArea textArea) {
        textArea.setText("");
    }





    private String getTextAreaContent() {
        return textAreaContent;
    }

    private void setTextAreaContent(String text) {
        this.textAreaContent = text;
    }

}