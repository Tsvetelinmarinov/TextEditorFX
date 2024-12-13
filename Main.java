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
		 * set up the window
		 */
		arg0.setTitle("TextEditor++");
		arg0.setResizable(false);
		arg0.setScene(arg1);


		/**
                * Build the application and show it on the screen
                */
		build_app();

		
		/**
		 * show the application
		 */
		arg0.show();
		
	}
	
	

	/**
        * Build the application
	*/
	private void build_app(){

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
		newFile.setOnAction(command -> new _SYSTEM_().mk_file());

		
		/**
		 * open
		 */
		load = new MenuItem("open");
		fileMenu.getItems().add(load);
		load.setOnAction(command -> {
			try {
				new _SYSTEM_().get_local_file();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showInternalMessageDialog(null,"Directory not found!",
						"ERROR",JOptionPane.ERROR_MESSAGE);
				
				e.printStackTrace();
			}
		});
		
		
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
		
	}



	/**
     * Main functionality
     */
    public class _SYSTEM_{


        /**
         * Create new file
         */
        public void mk_file(){

            //Show warning about unsaved data
            JOptionPane.showInternalMessageDialog(null,"Unsaved data will be lost!",
                    "Warning",JOptionPane.WARNING_MESSAGE
            );


            //Delete the text from the text box
            textBox.setText("");

        }



	    /**
         * Open local file in the text box
         */
        @SuppressWarnings("static-access")
        private void get_local_file() throws IOException {
        	
        	//File chooser to select a file
        	JFileChooser chooser = new JFileChooser();
        	
        	
        	//The new file - copy of the local file selected with the 
        	//file chooser
        	File document;
        	
        	
        	//Scanner to scan the content of the local file
        	Scanner _SCAN_ = null;
        	
        	
        	//Holds the text content of the local file
        	String content;
        	
        	
        	//Holds the response from the file chooser
        	int response;
        	
        	
        	//Holds the boolean value of the file chooser response
        	//for system use
        	boolean _HAS_SELECTED_FILE_;
        	
        	
            //File name extension filters
        	FileNameExtensionFilter txt = new FileNameExtensionFilter("text file","txt");
        	
        	
        	//apply filters
        	chooser.setFileFilter(txt);
        	
        	
        	
        	//Show file manager
        	response = chooser.showOpenDialog(null);
        	
        	
        	//Convert the return value from the file chooser to a boolean for
        	//system use
        	_HAS_SELECTED_FILE_ = (response == chooser.APPROVE_OPTION)
        			? true : false;
        	
        	
        	//Check the response
        	//if true - make the file and the scanner
        	if(_HAS_SELECTED_FILE_) {
        		
                document = new File(chooser.getSelectedFile().getAbsolutePath());
   	
        		//check if the file is created
        		if(document.isFile()) {
        			
        			//create the scanner
        			_SCAN_ = new Scanner(document);
        			
        			while(_SCAN_.hasNextLine()) {
        				
        				//scan the file content until the next line
        				//and get the text
        				content = _SCAN_.nextLine()+"\n";
        				
        				//append the text to the text box
        				textBox.appendText(content);
        				
        			}
        			
        			//close the scanner to avoid direct contact with the system
        			_SCAN_.close();
        			
        		}
        		
        		
        	}else{
			JOptionPane.showInternalMessageDialog(null,"Nothing selected!","Warning",
							      JOptionPane.WARNING_MESSAGE);
		}
        	
        	
        }

	    

    }
	
	
}
