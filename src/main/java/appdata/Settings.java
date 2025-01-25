/**
 * TextEditorFX Settings
 */

package appdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.*;

/**
 *
 */
public class Settings {


    private Stage settingsStage = new Stage();
    private AnchorPane settingsRoot = new AnchorPane();
    private Scene settingsUI = new Scene(settingsRoot, 800, 800);
    private Label fontSection = new Label("Font");
    private Label themeSection = new Label("Appearance");
    private Label fontFamily = new Label("font");
    private Label fontSize = new Label("size");
    private Label fontStyle = new Label("style");
    private Label fontColor = new Label("color");
    private String[] localFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private ObservableList<String> fonts = FXCollections.observableArrayList(localFonts);
    private String[] styles = {"normal", "bold", "italic"};
    private ObservableList<String> stylesList = FXCollections.observableArrayList(styles);
    private ComboBox<String> fontBox = new ComboBox<String>(fonts);
    private SpinnerValueFactory<Integer> sizeSpin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 20);
    private Spinner<Integer> sizeSpinner = new Spinner<Integer>(sizeSpin);



    /**
     *
     */
    public Settings() {
        settingsRoot.setStyle("-fx-background-color: WHITE;");

        fontSection.setFont(Font.font(
                "System",
                FontWeight.NORMAL,
                FontPosture.REGULAR,
                16
        ));
        fontSection.setPrefSize(150, 20);
        fontSection.setLayoutX(350);
        fontSection.setLayoutY(25);
        settingsRoot.getChildren().add(fontSection);



        settingsStage.setTitle("Appearance settings");
        settingsStage.setScene(settingsUI);
        settingsStage.setResizable(false);
        settingsStage.show();
    }


}