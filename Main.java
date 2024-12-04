/**
 * TextEditor++
 *  Simple text editor for every day use
 */

package appdata;







import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;






/**
*
*/
public class Main extends Application {

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) { launch(args); }
	
	
	
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		//Parent component with the fxml document
		Parent root = FXMLLoader.load(Main.class.getResource("editor.fxml"));
		
		//Scene with content
		Scene arg1 = new Scene(root);
		
		//apply design to the scene
		arg1.getStylesheets().add(Main.class.getResource("clasic_theme.css")
			               .toExternalForm());
		
		//setting up the stage
		arg0.setTitle("TextEditor++");
		arg0.setResizable(false);
		arg0.setScene(arg1);
		arg0.show();
	}
	
	
}