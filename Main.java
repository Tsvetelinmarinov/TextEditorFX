
/**
 TextEditor++
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
	 * Hold the copied text from the text box
	 */
	private String copied_text;
	

	
	
	
	
	
	
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
		
		
		//File filters
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text file","txt");
		
		
		//apply filters
		file_chooser.setFileFilter(txt);
		
		
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
	
	
	
	
	/**
	 * Select all
	 */
	public void select_all(ActionEvent actn_evnt) {
		
		//Check if the text box has text
		boolean empty_box = textBox.getText().isEmpty() ? true : false;
		
		if(empty_box)
			//show warning
			JOptionPane.showInternalMessageDialog(null, "Empty text filed!",
					              "Warning",JOptionPane.WARNING_MESSAGE);
		
		if(!empty_box)
			//select all the text in the text box
			textBox.selectAll();
		
	}
	
	
	
	
	/**
	 * Copy some text
	 */
	public void cpy(ActionEvent actn_evnt) {
		
		//check if the text box has text
		boolean has_not_content = textBox.getText().isEmpty() ? true : false;
		
		
		//if has text copy it
		if(!has_not_content)
			copied_text = textBox.getSelectedText();
		
		//if has not text show warning
		if(has_not_content)
			JOptionPane.showInternalMessageDialog(null, "Empty field!",
					   "Warning",JOptionPane.WARNING_MESSAGE);
			
	}
	
	
	
	
	/**
	 * Paste
	 */
	public void paste(ActionEvent acton_evnt) {
		
		//Check if the string that holds the copied text is empty
		boolean has_not_copied_text = copied_text == "" ? true : false;
		
		
		//if has not copied text show warning
		if(has_not_copied_text)
			JOptionPane.showInternalMessageDialog(null, "No copied text!",
					 "Warning",JOptionPane.WARNING_MESSAGE);
		
		
		//if has copied text paste it
		if(!has_not_copied_text)
			textBox.appendText((String)get_cpy_txt());
		
	}
	
	
	
	
	/**
	 * Delete all
	 */
	public void dlt_all(ActionEvent actn_evnt) {
		
		//Check if the text box has content
		boolean text_box_is_empty = textBox.getText().isEmpty();
		
		
		//if the text box is empty show warning
		if(text_box_is_empty)
			JOptionPane.showInternalMessageDialog(null, "Empty text filed!",
					   "Warning",JOptionPane.WARNING_MESSAGE);
		
		
		//if the text box has content - show warning about unsaved data and delete it
		if(!text_box_is_empty) {
			JOptionPane.showInternalMessageDialog(null,"Unsaved data will be lost!",
					 "Warning",JOptionPane.WARNING_MESSAGE);
			
			textBox.setText("");
		}
		
	}
	
	
	
	
	
	
	/**
	 * Show settings
	 */
	public void show_configurations(ActionEvent actn_evnt) throws IOException {
		
		//New stage
		Stage settings_window = new Stage();
		
		//FXML Loader to load the UI from the fxml document
		FXMLLoader _UI_loader = new FXMLLoader(Main.class.getResource("settings.fxml"));
		
		//Scene with the UI
		Scene arg00 = new Scene(_UI_loader.load());
		
		
		//setting up the window
		settings_window.setTitle("Settings");
		settings_window.setResizable(false);
		settings_window.setScene(arg00);
		
		//show the settings window
		settings_window.show();
		
	}
	
	
	
	
	/**
	 * Show manual settings
	 */
	@SuppressWarnings("static-access")
	public void show_manual_config(ActionEvent actn_evnt) throws IOException {
		
		//Manual appearance configuration window
		Stage arg00 = new Stage();
		
		//FXML Loader to load the UI from the fxml document
		FXMLLoader _UI_LOADER_ = new FXMLLoader();
		
		//Scene with the UI
		Scene arg01 = new Scene(_UI_LOADER_.load(Main.class.getResource(
				                "manual_settings.fxml")));
		
		
		//set up the window
		arg00.setTitle("Manual aprearance configuration");
		arg00.setResizable(false);
		arg00.setScene(arg01);
		
		//show the manual appearance setting window
		arg00.show();
		
	}
	
	
	
	/**
	 * Show information window
	 */
	public void show_infor(ActionEvent actn_evnt) throws IOException {
		
		//new Stage
		Stage info_window = new Stage();
		
		//FXML Loader to load the UI from the fxml document
		FXMLLoader _LOADER_ = new FXMLLoader(Main.class.getResource("info.fxml"));
		
		//Scene with the UI
		Scene UI = new Scene(_LOADER_.load());
		
		
		//set the window
		info_window.setTitle("Information");
		info_window.setResizable(false);
		info_window.setScene(UI);
		
		//show the information window
		info_window.show();
		
	}
	
	
	
	
	/**
	 * Show window with link to my profile in Facebook
	 * Feel free to contact me!
	 */
	public void show_link(ActionEvent actn_evnt) throws IOException {
		
		//New stage
		Stage linkWindow = new Stage();
		
		//FXMLLoader to load the UI
		FXMLLoader _UI_ = new FXMLLoader();
		
		//Scene with the UI
		@SuppressWarnings("static-access")
		Scene _container_ = new Scene(_UI_.load(Main.class.getResource("link.fxml")));
		
		
		//set up the window
		linkWindow.setTitle("Link");
		linkWindow.setResizable(false);
		linkWindow.setScene(_container_);
		
		//show the link window
		linkWindow.show();
		
	}
	
	
	
	
	
	/**
	 * Getter for the copied text
	 */
	public String get_cpy_txt() { return copied_text; }
	
	
}














