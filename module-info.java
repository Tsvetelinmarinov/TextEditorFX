
/**
 * TextEditor++
 */

module appdata {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	
	opens appdata to javafx.fxml;
	exports appdata;
}
