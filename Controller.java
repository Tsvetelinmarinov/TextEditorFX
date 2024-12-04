/**
* TextEditor++
*  Controller
*/

package appdata;





import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.Random;
import java.util.ResourceBundle;








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
	 * Show tips window
	 */
	public void showInstruction(ActionEvent actn_evnt) {
		//Stage with the parent scene
		Stage stg = new Stage();
		
		try {
			//set up the stage
			stg.setTitle("Tips");
			stg.setResizable(false);
			stg.setScene(new Scene(FXMLLoader.load(Controller.class.getResource("tips.fxml"))));
			stg.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		    JOptionPane.showInternalMessageDialog(null, "Unable to load source from tips.fxml","Error",
		    		                 JOptionPane.ERROR_MESSAGE);	
		
			e.printStackTrace();
		}
	}

	
	
	
}


















