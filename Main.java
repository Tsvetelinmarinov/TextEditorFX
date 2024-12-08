
/**
* TextEditor++
*/

package appdata;






import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;







/**
 * 
 */
public class Main extends Application{

	
	
	/**
	 * The text box
	 */
	@FXML
	private TextArea textBox;
	

	
	
	
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[]args) { launch(args); }
	
	
	
	
	
	
	@Override
	public void start(Stage arg00) throws Exception {
		// TODO Auto-generated method stub
		//FXMLLoader to load the UI from the fxml document
		FXMLLoader _loader_ = new FXMLLoader(Main.class.getResource(
				          "editor.fxml"));
		
		//Parent component to hold the UI
		Parent _root_ = _loader_.load();
		
		//New scene with the UI
		Scene arg1 = new Scene(_root_);
		
		//Applying design to the scene
		arg1.getStylesheets().add(Main.class.getResource(
				"classic_theme.css").toExternalForm());
		
		//setting up the stage with the scene
		arg00.setTitle("TextEditor++");
		arg00.setResizable(false);
		arg00.setScene(arg1);
		
		//show the stage
		arg00.show();
	}
	
	
	
	
	
	
	/**
	 * New file
	 */
	public void create_file(ActionEvent actn_evnt) {
		
		//show warning about unsaved data
		JOptionPane.showInternalMessageDialog(null, 
		  "Unsaved data will be lost!", "Warning",
				 JOptionPane.WARNING_MESSAGE);
		
		//Delete everything from the text box
		textBox.setText("");
		
	}
	
	
	
	
	
	/**
	 * Open file
	 */
	public void load_local_file(ActionEvent actn_evnt) throws IOException {
		
		//The new file copy of the local file in your system
		File document;
		
		
		//Scanner to scan the content in the local file
		Scanner scann;
		
		
		//File chooser to select a local file
		JFileChooser file_chooser = new JFileChooser();
		
		
		//Holds the response from the file chooser
		int response;
		
		
		//Show file chooser and get the response
		response = file_chooser.showOpenDialog(null);
		
	    
		//convert the response to boolean for system use
		@SuppressWarnings("static-access")
		boolean has_selected_file = (response == file_chooser.APPROVE_OPTION)
				 ? true : false;
		
		
		//If has selected file to open create the scanner and the file
		if(has_selected_file) {
			document = new File(file_chooser.getSelectedFile().
					   getAbsolutePath());
			
			scann = new Scanner(document);
			
			//Check if the document is actually a file
			if(document.isFile()) {
				//scan the file content unit the end line
				while(scann.hasNextLine()) {
					//Holds the file content
					String content = scann.nextLine()+"\n";
					
					//append content to the new file in the text box
					textBox.appendText(content);
				}
			}
			
			//close the scanner to avoid direct contact with the system
			scann.close();
		}
		
	}
	
	
	
	
	/**
	 * Save your file
	 */
	public void export_data_to_local_file(ActionEvent actn_evnt)throws IOException{

		//The new file for your system
		File file;
		
		
		//PrintWriter to write the text from the text box in the new file
		PrintWriter _printer_ = null;
		
		
		//File chooser to choose the name and the directory of the new file
		JFileChooser file_chooser = new JFileChooser();
		
		
		//Holds the response from the file chooser
		int response;
		
		
		//show dialog and choose location
		response = file_chooser.showSaveDialog(null);
		
		//convert the response to a boolean value for system use
		@SuppressWarnings("static-access")
		boolean path_is_selected = (response == file_chooser.
				     APPROVE_OPTION) ?
				       true : false;
		
		
		//Check if the file path is selected
		//if true -- create the file and the printer
		if(path_is_selected) {
			
			file = new File(file_chooser.getSelectedFile().getAbsolutePath());
			
			_printer_ = new PrintWriter(file);
			
			//Print the text from the text box to the new file
			_printer_.println(textBox.getText());
			
			//close the printer to avoid direct access to the system
			_printer_.close();
		}
		
	}
	
	
	
	
	/**
	 * Show new window
	 */
	public void duplicate(ActionEvent actn_evnt) throws IOException {
		
		//Create a new window
		Stage stg = new Stage();
		
		//Scene
		Scene scn = new Scene(FXMLLoader.load(Main.class.getResource("editor.fxml")));
		
		//Apply design to the scene
		scn.getStylesheets().add(Main.class.getResource("classic_theme.css")
				        .toExternalForm());
		
		//configure the window
		stg.setScene(scn);
		stg.setTitle("TextEditor++");
		stg.setResizable(false);
		
		//show the new window
		stg.show();
	}
	
	
	
	
	
	/**
	 * Restart
	 */
	public void reboot(ActionEvent actn_evnt) throws IOException {
		
		//new instance
		Stage stage = new Stage();
		
		Scene scn = new Scene(FXMLLoader.load(Main.class.getResource("editor.fxml")));
		
		//apply design
		scn.getStylesheets().add(Main.class.getResource("classic_theme.css")
				.toExternalForm());
		
		//set the new window
		stage.setTitle("TextEditor++");
		stage.setScene(scn);
		stage.setResizable(false);
		
		//show the new window
		stage.show();
		
	}
	
	
	
	
	/**
	 * Close the application
	 */
	public void terminate(ActionEvent actn_evnt) {
		
		//Terminate window
		System.exit(0);
		
	}
	
	
	
	
}
