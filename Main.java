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
	 * New file menu item
	 */
	private MenuItem newFile;
	
	
	/**
	 * Open menu item
	 */
	private MenuItem load;
	
	
	/**
	 * Save menu item
	 */
	private MenuItem export;
	
	
	/**
	 * New window menu item
	 */
	private MenuItem newWindow;
	
	
	/**
	 * Restart menu item
	 */
	private MenuItem reboot;
	
	
	/**
	 * Exit menu item
	 */
	private MenuItem terminate;


	/**
	 * Select all menu item
	 */
	private MenuItem selectAll;
	
	
	/**
	 * Copy menu item
	 */
	private MenuItem cpy;
	
	
	/**
	 * Paste menu item
	 */
	private MenuItem paste;
	
	
	/**
	 * Delete menu item
	 */
	private MenuItem dltAll;
	

        /**
        *Appearance settings menu item
        */
        private MenuItem appear;


        /**
        * About menu item
        */
        private MenuItem info;

	
	
	
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
		 * new file
		 */
		newFile = new MenuItem("new file");
		fileMenu.getItems().add(newFile);

		
		/**
		 * open
		 */
		load = new MenuItem("open");
		fileMenu.getItems().add(load);
		
		
		/**
		 * save
		 */
		export = new MenuItem("save");
		fileMenu.getItems().add(export);
		
		
		/**
		 * new window
		 */
		newWindow = new MenuItem("new window");
		fileMenu.getItems().add(newWindow);
		
		
		/**
		 * restart
		 */
		reboot = new MenuItem("restart");
		fileMenu.getItems().add(reboot);
		
		
		/**
		 * close
		 */
		terminate = new MenuItem("close");
		fileMenu.getItems().add(terminate);


		/**
		 * select all 
		 */
		selectAll = new MenuItem("select all");
		editMenu.getItems().add(selectAll);
		
		
		/**
		 * copy
		 */
		cpy = new MenuItem("copy");
		editMenu.getItems().add(cpy);
		
		
		/**
		 * paste
		 */
		paste = new MenuItem("paste");
		editMenu.getItems().add(paste);
		
		
		/**
		 * delete all
		 */
		dltAll = new MenuItem("delete all");
		editMenu.getItems().add(dltAll);


		 /**
                 * appearance
                 */
                appear = new MenuItem("appearance");
                optionsMenu.getItems().add(appear);


                 /**
                 * information
                 */
                info = new MenuItem("information");
                optionsMenu.getItems().add(info);
		
		
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
