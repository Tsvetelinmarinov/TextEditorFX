/**
* TextEditor++
*/

package appdata;





import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import java.io.*;
import javafx.beans.value.*;
import javafx.beans.property.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;







/**
 * 
 */
public class Main extends Application{
	
	
	
	/**
	 * The root container
	 */
	private AnchorPane _root_;
	
	
	/**
	 * Main scene with the UI
	 */
	private Scene arg1;
	
	
	/**
	 * Text box
	 */
	private TextArea textBox;
	

	/**
	 * Menu bar
	 */
	private MenuBar menuBar;
	
	
	/**
	 * File menu
	 */
	private Menu fileMenu;
	
	
	/**
	 * Edit menu
	 */
	private Menu editMenu;
	
	
	/**
	 * Options menu
	 */
	private Menu optionsMenu;
	
	
	/**
	 * Help menu
	 */
	private Menu helpMenu;
	
	
	
	
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) { launch(args); }
	
	
	
	
	
	
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * Parent component
		 */
		_root_ = new AnchorPane();
		
		
		/**
		 * New scene
		 */
		arg1 = new Scene(_root_,850,550);

		//apply design to the scene
		arg1.getStylesheets().add(Main.class.getResource("classic_theme.css")
				                 .toExternalForm());
		
		/**
		 * Text box
		 */
		textBox = new TextArea();
		textBox.setFont(new Font("Fira Code Regular",16));
		textBox.setStyle("-fx-text-fill:BLACK;");
		textBox.setLayoutX(0);
		textBox.setLayoutY(45);
		textBox.setPrefWidth(_root_.getWidth());
		textBox.setPrefHeight(_root_.getHeight() - 45);
		//Create a drop shadow effect
		textBox.setEffect(new DropShadow());
		textBox.getStyleClass().add("text_box");
		_root_.getChildren().add(textBox);


		/**
		 * Menu bar
		 */
		menuBar = new MenuBar();
		menuBar.setBorder(null);
		menuBar.setLayoutX(0);
		menuBar.setLayoutY(0);
		menuBar.setPrefWidth(230);
		menuBar.setPrefHeight(30);
		menuBar.getStyleClass().add("menu_bar");
		_root_.getChildren().add(menuBar);
		
		
		/**
		 * File menu
		 */
		fileMenu = new Menu("File");
		menuBar.getMenus().add(fileMenu);
		
		
		/**
		 * Edit menu
		 */
		editMenu = new Menu("Edit");
		menuBar.getMenus().add(editMenu);
		
		
		/**
		 * Options menu
		 */
		optionsMenu = new Menu("Options");
		menuBar.getMenus().add(optionsMenu);
		
		
		/**
		 * Help menu
		 */
		helpMenu = new Menu("Help");
		menuBar.getMenus().add(helpMenu);
		
		
		
		/**
		 * set up the window
		 */
		arg0.setTitle("TextEditor++");
		arg0.setResizable(false);
		arg0.setScene(arg1);
		
		/**
		 * show the application
		 */
		arg0.show();
		
	}
	
	
	
	
	
	
}
