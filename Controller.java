
/**
* TextEditor++
*  Controller
*/

package appdata;





import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;








/**
*
*/
public class Controller{

	
	/**
	 * The text box
	 */
	@FXML
	private TextArea textBox;
	

	
	
	
	
	/**
	 * Show settings window
	 */
	public void showOptions(ActionEvent actn_evnt) {
		//The stage to show
		Stage arg0 = new Stage();
		
		//Parent component with the settings window
		try {
			Parent settings = FXMLLoader.load(Controller.class.getResource("settings.fxml"));
			
			//New scene with the parent component
			Scene arg1 = new Scene(settings);
			
			//set the window
			arg0.setTitle("Settings");
			arg0.setScene(arg1);
			arg0.setResizable(false);
			arg0.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showInternalMessageDialog(null,"Unable to load settings window!","Error",JOptionPane
					                     .ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * Show information window
	 */
	public void showInfo(ActionEvent actn_evnt) {
		//Main stage
		Stage arg4 = new Stage();
		
		//Scene with the parent component(information window)
		try {
			Scene arg5 = new Scene(FXMLLoader.load(Controller.class.getResource("info.fxml")));
			
			//set the window
			arg4.setTitle("About");
			arg4.setScene(arg5);
			arg4.setResizable(false);
			arg4.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	
	/**
	 * Show manual settings window
	 */
	public void showManualConfigurations(ActionEvent actn_evnt) {
		//The new stage with the settings window
		Stage stage = new Stage();
		
		try {
			stage.setTitle("Configuration");
			stage.setResizable(false);
			stage.setScene(new Scene(FXMLLoader.load(Controller.class.getResource("manual_settings.fxml"))));
			stage.show();
		}catch (IOException e1) {
			JOptionPane.showInternalMessageDialog(null,"Unable to load manual settings window!",
					    "Error",JOptionPane.ERROR_MESSAGE);
			
			System.out.println("Error while loading the fxml document..\n");
			e1.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * Get link button
	 */
     public void showConnectionLink(ActionEvent actn_evnt) {			
		//Stage with the window with the link
    	 Stage stg = new Stage();
    	 
    	 //set the stage
    	 try {
    		 stg.setTitle("Link");
    		 stg.setResizable(false);
    		 stg.setScene(new Scene(FXMLLoader.load(Controller.class.getResource("link.fxml"))));
    		 stg.show();
    	 }catch(IOException e1) {
    		 JOptionPane.showInternalMessageDialog(null, "Unable to load link window!",
    				        "Error",JOptionPane.ERROR_MESSAGE);
    		 System.out.println("Error while loading link.fxml\n");
    		 e1.printStackTrace();
    	 }
	 }
	
     
     
     
     /**
      * New file
      */
     public void createNewFile(ActionEvent actn_evnt) {
    	 //Show warning for the unsaved data
    	 JOptionPane.showInternalMessageDialog(null, "Unsaved data will be lost!",
    			 "Warning",JOptionPane.WARNING_MESSAGE);
    	 
    	  //Clear the text box
    	 textBox.setText("");
     }
     
     
     
     
     /**
      * Open a file
      */
     public void loadFile(ActionEvent actn_evnt) throws FileNotFoundException {
    	 //The new File
    	 //copy of the file in your system
    	 File doc;
    	 
    	 //File chooser to select the file in your system
    	 JFileChooser fl_chooser = new JFileChooser();
    	 
    	 //Scanner to scan the file content
    	 Scanner scan = null;
    	 
    	 //Hold the response from the file chooser
    	 int rspns;
    	 
    	 //File name extension filters
    	 FileNameExtensionFilter txt = new FileNameExtensionFilter("text file","txt");
    	 FileNameExtensionFilter java = new FileNameExtensionFilter("java file","java");
    	 
    	 //apply filters
    	 fl_chooser.setFileFilter(txt);
    	 fl_chooser.setFileFilter(java);
    	 
    	 //Show file chooser and get the response
    	 rspns = fl_chooser.showOpenDialog(null);
    	 
    	 //Hold the response from the file chooser(boolean)
    	 @SuppressWarnings("static-access")
    	 boolean HasSelectedFileToOpen = (rspns == fl_chooser.APPROVE_OPTION)
    			   ? true : false;
    	 
    	 //check if the file that is selected is a file
    	 if(HasSelectedFileToOpen) {
    		 //Create the file
    		 doc = new File(fl_chooser.getSelectedFile().getAbsolutePath());
    		 
    		 if(doc.isFile()) {
    			 //Create the scanner of the file
    			 scan = new Scanner(doc);
    			 
    			 //scan while the file has next line and copy the content
    			 while(scan.hasNextLine()) {
    				 String content = scan.nextLine()+"\n";
    				 
    				 //Apply the content from the file to the text box
    				 textBox.appendText(content);
    			 }
    		 }else {
    			 JOptionPane.showInternalMessageDialog(null,"Unsupported file!","Error",
    					 JOptionPane.ERROR_MESSAGE);
    		 }
    	 }else {
    		 JOptionPane.showInternalMessageDialog(null, "No file selected to open!","Warning",
    				     JOptionPane.WARNING_MESSAGE);
    	 }
     }
}


















