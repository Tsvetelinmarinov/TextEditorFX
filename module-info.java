/**
 * 
 */
module TextEditorFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	
	opens appdata to javafx.graphics, javafx.fxml;
}
