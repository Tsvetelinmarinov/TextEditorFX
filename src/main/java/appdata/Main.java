/**
* TextEditorFX
*/

package appdata;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

/**
*
*/
public class Main extends Application {

    //System components
    private Stage mainStage;
    private Scene mainScene;
    private AnchorPane root = new AnchorPane();
    private MenuBar menuBar = new MenuBar();
    private Menu fileMenu = new Menu("File");
    private Menu optionsMenu = new Menu("Options");
    private Menu editMenu = new Menu("Edit");;
    private Menu helpMenu = new Menu("Help");;
    private MenuItem load = new Menu("open file");;
    private MenuItem export = new Menu("save as");;
    private MenuItem newFile = new MenuItem("new file");
    private MenuItem newWindow = new MenuItem("new window");
    private MenuItem reboot = new MenuItem("restart");
    private MenuItem close = new MenuItem("close");
    private MenuItem selectAll = new MenuItem("select all");
    private MenuItem copy = new MenuItem("copy");
    private MenuItem paste = new MenuItem("paste");
    private MenuItem deleteAll = new MenuItem("delete all");
    private MenuItem appearance = new MenuItem("appearance");
    private MenuItem info = new MenuItem("information");
    private TextArea textBox = new TextArea();



    /**
     *
     */
    public static void main(String[] args) {
        launch(args);
    }




    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        ProgramLogicalClass systemLogic = new ProgramLogicalClass();

        root.setStyle("-fx-background-color:WHITE;");

        mainScene = new Scene(root, 1000, 800);

        stage.setScene(mainScene);
        stage.setTitle("TextEditor++");
        stage.setResizable(false);
        stage.show();



        menuBar.setPrefWidth(root.getWidth());
        menuBar.setPrefHeight(30);
        menuBar.setLayoutX(0);
        menuBar.setLayoutY(0);
        menuBar.setStyle("-fx-background-color:WHITE;");
        root.getChildren().add(menuBar);


        fileMenu.setStyle("-fx-font-size:16");
        editMenu.setStyle("-fx-font-size:16");
        optionsMenu.setStyle("-fx-font-size:16");
        helpMenu.setStyle("-fx-font-size:16");

        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(editMenu);
        menuBar.getMenus().add(optionsMenu);
        menuBar.getMenus().add(helpMenu);


        textBox.setFont(Font.font(
                "Consolas",
                FontWeight.NORMAL,
                FontPosture.REGULAR,
                17
        ));
        textBox.setStyle("-fx-background-color:WHITE;");
        textBox.setLayoutX(0);
        textBox.setLayoutY(60);
        textBox.setPrefSize(root.getWidth(), root.getHeight() - 60);
        textBox.setEffect(new DropShadow());
        textBox.setStyle("-fx-border-style: none");
        root.getChildren().add(textBox);


        newFile.setStyle("-fx-font-size: 16;");
        fileMenu.getItems().add(newFile);
        newFile.setOnAction(event -> systemLogic.createNewFile(textBox));

        load.setStyle("-fx-font-size: 16;");
        fileMenu.getItems().add(load);
        load.setOnAction(event -> {
            try {
                systemLogic.openLocalFile(textBox);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        export.setStyle("-fx-font-size: 16;");
        fileMenu.getItems().add(export);
        export.setOnAction(event -> {
            try {
                systemLogic.exportDataToLocalFile(textBox);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        newWindow.setStyle("-fx-font-size: 16;");
        fileMenu.getItems().add(newWindow);

        reboot.setStyle("-fx-font-size: 16;");
        fileMenu.getItems().add(reboot);

        close.setStyle("-fx-font-size: 16;");
        fileMenu.getItems().add(close);

        selectAll.setStyle("-fx-font-size: 16;");
        editMenu.getItems().add(selectAll);

        copy.setStyle("-fx-font-size: 16;");
        editMenu.getItems().add(copy);

        paste.setStyle("-fx-font-size: 16;");
        editMenu.getItems().add(paste);

        deleteAll.setStyle("-fx-font-size: 16;");
        editMenu.getItems().add(deleteAll);

        appearance.setStyle("-fx-font-size: 16;");
        optionsMenu.getItems().add(appearance);

        info.setStyle("-fx-font-size: 16;");
        helpMenu.getItems().add(info);

    }
}