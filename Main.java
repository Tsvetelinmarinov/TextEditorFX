/**
* TextEditor++
*/

package appdata;





import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import java.io.*;
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
        * Holds the copied text
	*/
	private String cpyText;
	
	
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
	
	
	
	 /**
        * Launch the application 
        * @param stg
        * @throws java.lang.Exception
        */
	@Override
	public void start(Stage arg0) throws Exception { build_app(); }
	
	



	
	/**
        * Build the application
	*/
	private void build_app(){

               /**
		 * Parent component
		 */
		_root_ = new AnchorPane();


		Stage arg0 = new Stage();
		
		
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
		 * show the application
		 */
		arg0.show();
		

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
		export.setOnAction(command -> {
			try {
				new _SYSTEM_().export_data();
			}catch(IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showInternalMessageDialog(null,"Error exporting file!",
						"ERROR",JOptionPane.ERROR_MESSAGE);
				
				e.printStackTrace();
			}
		});
		
		
		/**
		 * new window
		 */
		newWindow = new MenuItem("new window");
		fileMenu.getItems().add(newWindow);
		newWindow.setOnAction(command -> new _SYSTEM_()._clone_());
		
		
		/**
		 * restart
		 */
		reboot = new MenuItem("restart");
		fileMenu.getItems().add(reboot);
		reboot.setOnAction(command -> new _SYSTEM_().reboot(arg0));
		
		
		/**
		 * close
		 */
		terminate = new MenuItem("close");
		fileMenu.getItems().add(terminate);
		terminate.setOnAction(command -> new _SYSTEM_().terminate());


		/**
		 * select all 
		 */
		selectAll = new MenuItem("select all");
		editMenu.getItems().add(selectAll);
		selectAll.setOnAction(command -> new _SYSTEM_().select_all());
		
		
		/**
		 * copy
		 */
		cpy = new MenuItem("copy");
		editMenu.getItems().add(cpy);
		cpy.setOnAction(command -> new _SYSTEM_().cpy());
		
		
		/**
		 * paste
		 */
		paste = new MenuItem("paste");
		editMenu.getItems().add(paste);
		paste.setOnAction(command -> new _SYSTEM_().paste_copied_text());
		
		
		/**
		 * delete all
		 */
		dltAll = new MenuItem("delete all");
		editMenu.getItems().add(dltAll);
		dltAll.setOnAction(command -> new _SYSTEM_().delete_text());


		 /**
                 * appearance
                 */
                appear = new MenuItem("appearance");
                optionsMenu.getItems().add(appear);
		appear.setOnAction(command -> new _SYSTEM_().show_config_win());


                 /**
                 * information
                 */
                info = new MenuItem("information");
                optionsMenu.getItems().add(info);
		
	}



	/**
     * Main functionality
     */
    private class _SYSTEM_{


        /**
         * Create new file
         */
        private void mk_file(){

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
        			
        		}else JOptionPane.showInternalMessageDialog(null, 
        				"Error while creating file!",
        				 "Error",JOptionPane.ERROR_MESSAGE);
        		
        		
        	}else JOptionPane.showInternalMessageDialog(null,"Nothing selected!","Warning",
							      JOptionPane.WARNING_MESSAGE);
		

        }



	     /**
         * Export data to local file in the computer
         */
        @SuppressWarnings("static-access")
        private void export_data() throws IOException {
        	
        	//File chooser to select the file path
        	JFileChooser file_chooser = new JFileChooser();
        	
        	
        	//The new file
        	File export_file;
        	
        	
        	//Print writer to write the text from the text box
        	//to the new file
        	PrintWriter _PRINTER_ = null;
        	
        	
        	//Holds the response from the file chooser
        	int resp;
        	
        	
        	//Holds boolean value of the response for system use
        	boolean PATH_IS_SELECTED;
        	
        	
        	
        	//show file manager and select the path and the name of the
        	//new file and get the response
        	resp = file_chooser.showSaveDialog(null);
        	
        	
        	//convert the response to a boolean value
        	PATH_IS_SELECTED = (resp == file_chooser.APPROVE_OPTION)
        			? true : false;
        	
        	
        	//if path is selected create the new file
        	if(PATH_IS_SELECTED) {
        		
        		export_file = new File(file_chooser.getSelectedFile().getAbsolutePath());
        		
        		//create the printer
        		_PRINTER_ = new PrintWriter(export_file);
        		
        		//print the text from the text box to the new file
        		_PRINTER_.println(textBox.getText());
        		
        		//close the printer to avoid direct access to the system
        		_PRINTER_.close();
        		
        	}
        	
        	
        }



	 /**
        * Open new window 
        */
        private void _clone_(){   
            
            //new stage
            Stage arg00 = new Stage();
            
            //New scene
            Scene arg01 = (Scene) arg1;
            
            //set up the new window
            arg00.setTitle("TextEditor++");
            arg00.setResizable(false);
            arg00.setScene(arg01);
            
            //show the new window
            arg00.show();
            
        } 



        /**
        * Restart the application 
        */
        private void reboot(Stage window){
            
            //show warning about unsaved data
            JOptionPane.showInternalMessageDialog(null,"Unsaved data will be lost",
                "Warning",JOptionPane.WARNING_MESSAGE)
            ;
            
            
            //close current window
            window.close();
            
            
            //make window
            Stage arg000 = new Stage();
            
            //set the default UI
            Scene _UI_ = (Scene) arg1;
            
            //delete the text from the text box
            textBox.setText("");
            
            //set the window
            arg000.setTitle("TextEditor++");
            arg000.setResizable(false);
            arg000.setScene(_UI_);
            
            //show the new window
            arg000.show();
            
        }




	/**
        * Close the application 
        */
        private void terminate() {
        	
        	//Ask
        	int rspn = JOptionPane.showInternalConfirmDialog(null, "Do you really want to quit?",
        			  "You are about to quit",JOptionPane.YES_NO_OPTION);
        	
        	//Convert the response from the option window to a boolean value for system use
        	boolean WANT_TO_QUIT = (rspn == JOptionPane.YES_OPTION) ? true : false;
        	
        	
        	//Check the response
        	// if true -- terminate the application
        	if(WANT_TO_QUIT) System.exit(0);
        	
        }




	 /**
         * Select all the text in the text box
         */
        private void select_all() {
        	
        	//Check if the text box has text
        	boolean _HAS_NOT_CONTENT_ = textBox.getText().isEmpty() ? true : false;
        	
        	
        	//if has text in the box, select it
        	if(!_HAS_NOT_CONTENT_) textBox.selectAll();
        	
        	//if has not text in the box show warning
        	else JOptionPane.showInternalMessageDialog(null, "Empty text filed!",
        			  "Warning",JOptionPane.WARNING_MESSAGE);
        	
        }
        
        
        
        /**
         * Copy text
         */
        private void cpy() {
        	
        	//check if the text box has text
        	boolean HAS_TEXT = (textBox.getText().isEmpty()) ? false : true;
        	
        	
        	//if has text, copy it
        	if(HAS_TEXT) cpyText = (String)textBox.getSelectedText();
        	
        	//if has not text show warning
        	else JOptionPane.showInternalMessageDialog(null, "Empty text filed!",
        			 "Warning",JOptionPane.WARNING_MESSAGE);
        	
        }
        
        
        
        
        /**
         * Paste copied text
         */
        private void paste_copied_text() {
        	
        	//check if the string that holds the copied text is empty
        	boolean _HAS_COPIED_TEXT_ = get_cpy_txt().isEmpty() ? false : true; 
        	
        	//if has copied text, paste it
        	if(_HAS_COPIED_TEXT_) textBox.appendText((String)get_cpy_txt());
        	
        	//else show warning
        	else JOptionPane.showMessageDialog(null, "No copied text!","Warning",
        			 JOptionPane.WARNING_MESSAGE);
        	
        }




        /**
         * Delete all the text in the text box
         */
        private void delete_text() {

            //check if the text box has text
            boolean _HAS_TEXT_ = textBox.getText().isEmpty() ? false : true;

            //if the text box has text delete it
            if(_HAS_TEXT_) textBox.setText("");

                //if the text box has not text show warning
            else JOptionPane.showMessageDialog(null,
                    "Empty text filed!","Warning",
                    JOptionPane.WARNING_MESSAGE
            );

        }




	 /**
         * Show settings window
         */
        private void show_config_win(){

            //New stage
            Stage arg010 = new Stage();

            //Anchor pare as a root component
            AnchorPane _CONFIG_ROOT_ = new AnchorPane();
            _CONFIG_ROOT_.setStyle("-fx-background:WHITE;");

            //New scene
            Scene arg011 = new Scene(_CONFIG_ROOT_,800,570);

            //Spacer
            Separator sp1 = new Separator();
            sp1.setLayoutX(0);
            sp1.setLayoutY(33);
            sp1.setPrefWidth(340);
            sp1.setPrefHeight(5);
            _CONFIG_ROOT_.getChildren().add(sp1);

            //Spacer
            Separator sp2 = new Separator();
            sp2.setLayoutX(470);
            sp2.setLayoutY(33);
            sp2.setPrefWidth(350);
            sp2.setPrefHeight(5);
            _CONFIG_ROOT_.getChildren().add(sp2);

            //Logo label
            Label appear_logo = new Label("Configure font");
            appear_logo.setFont(new Font("JetBrains Mono",17));
            appear_logo.setStyle("-fx-text-fill:rgb(60,60,60);");
            appear_logo.setLayoutX(350);
            appear_logo.setLayoutY(20);
            appear_logo.setPrefWidth(120);
            _CONFIG_ROOT_.getChildren().add(appear_logo);

            //Font family label
            Label f_family = new Label("font");
            f_family.setFont(new Font((String)appear_logo.getFont().getFamily(),17));
            f_family.setStyle("-fx-text-fill:rgb(60,60,60);");
            f_family.setLayoutX(40);
            f_family.setLayoutY(100);
            _CONFIG_ROOT_.getChildren().add(f_family);

            //Holds the local font names
            String[] sys_fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getAvailableFontFamilyNames()
            ;
            ObservableList<String> fonts = FXCollections.observableArrayList(sys_fonts);


            //Combo box with the theme names
            ComboBox<String> font_box = new ComboBox<String>(fonts);
            font_box.setLayoutX(80);
            font_box.setLayoutY(102);
            font_box.setPrefWidth(200);
            font_box.setPrefHeight(17);
            font_box.setValue((String)textBox.getFont().getFamily());
            _CONFIG_ROOT_.getChildren().add(font_box);
            font_box.setCellFactory(listView -> new ListCell<String>() {
                @Override protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setFont(Font.font(item, 14));
                    } else {
                        setText(null);
                        setFont(Font.font(14));
                    }
                }
            });
            /*
            font_box.setButtonCell(new ListCell<String>() {
                @Override protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setFont(Font.font(item, 14));
                    } else {
                        setText(null);
                        setFont(Font.font(14));
                    }
                }
            });
            */
            font_box.setOnAction(command -> {
               textBox.setFont(new Font((String)font_box.getValue(),textBox.getFont().getSize()));
            });


            //Font size label
            Label f_size = new Label("size");
            f_size.setFont(new Font((String)appear_logo.getFont().getFamily(),17));
            f_size.setStyle("-fx-text-fill:rgb(60,60,60);");
            f_size.setLayoutX(320);
            f_size.setLayoutY(100);
            _CONFIG_ROOT_.getChildren().add(f_size);


            //Spinner model for the size spinner
            SpinnerValueFactory<Integer> f_size_spin_mdl = new SpinnerValueFactory
                    .IntegerSpinnerValueFactory(0,50,20)
            ;


            //Font size spinner
            Spinner<Integer> size_spin = new Spinner<Integer>(f_size_spin_mdl);
            size_spin.setLayoutX(360);
            size_spin.setLayoutY(100);
            size_spin.setPrefWidth(70);
            size_spin.setPrefHeight(30);
            size_spin.setStyle("-fx-font-family:'Fira Code';");
            size_spin.setStyle("-fx-background-color:WHITE;");
	    size_spin.setStyle("-fx-font-size:20;");
            _CONFIG_ROOT_.getChildren().add(size_spin);
            size_spin.valueProperty().addListener((
                     arg00,
                     arg01,
                     arg02) -> {

                     textBox.setFont(new Font((String)textBox.getFont().getFamily(),
                             (int)size_spin.getValue()))
                     ;

            });




	    //Font style label
            Label f_style = new Label("style");
            f_style.setFont((Font)appear_logo.getFont());
            f_style.setStyle("-fx-text-fill:rgb(60,60,60);");
            f_style.setLayoutX(470);
            f_style.setLayoutY(100);
            _CONFIG_ROOT_.getChildren().add(f_style);


            //hold the font style string representations
            String[] f_s = { "normal","bold","italic" };

            //Converted f_s
            ObservableList<String> f_ss = FXCollections.observableArrayList(f_s);

            //Combo box with the options
            ComboBox<String> style_box = new ComboBox<String>(f_ss);
            style_box.setValue("normal");
            style_box.setPrefWidth(100);
            style_box.setPrefHeight(17);
            style_box.setLayoutX(515);
            style_box.setLayoutY(102);
            _CONFIG_ROOT_.getChildren().add(style_box);
            style_box.valueProperty().addListener((
                   String box_value = style_box.getValue();

                           if(Objects.equals(box_value, "normal")) {
                               textBox.setFont(Font.font((String)textBox.getFont().getFamily(),
                                       FontWeight.NORMAL,(int)textBox.getFont().getSize())
                               );
                           }

                           if(Objects.equals(box_value, "bold")){
                               textBox.setFont(Font.font((String)textBox.getFont().getFamily(),
                                       FontWeight.BOLD,(int)textBox.getFont().getSize())
                               );
                           }

                           if(Objects.equals(box_value,"italic")){
                               textBox.setFont(Font.font((String)textBox.getFont().getFamily(),
                                       FontPosture.ITALIC,(int)textBox.getFont().getSize())
                               );
                           }
            );




	     //Font color label
            Label f_clr = new Label("color");
            f_clr.setFont((Font)appear_logo.getFont());
            f_clr.setStyle("-fx-text-fill:rgb(60,60,60);");
            f_clr.setLayoutX(655);
            f_clr.setLayoutY(100);
            _CONFIG_ROOT_.getChildren().add(f_clr);


            //Color picker to pick a color or create new one
            ColorPicker clrpckr = new ColorPicker();
            clrpckr.setPrefWidth(90);
            clrpckr.setPrefHeight(25);
            clrpckr.setLayoutX(706);
            clrpckr.setLayoutY(101);
	    String style_prop = textBox.getStyle();
            Color editor_fore = get_clr_txt(style_prop);
            clrpckr.setValue(editor_fore);
            _CONFIG_ROOT_.getChildren().add(clrpckr);
            clrpckr.setOnAction(command -> {
                //Get the color from the color picker
                Color color = clrpckr.getValue();

                //apply changes
                textBox.setStyle("-fx-text-fill:" + string_to_hex(color) + ";");

            });



            /**
             * Reset font button
             */
            Button reset_font = new Button("reset defaults");
            reset_font.setFont(new Font("System",15));
            reset_font.setPrefWidth(200);
            reset_font.setPrefHeight(15);
            reset_font.setLayoutX(300);
            reset_font.setLayoutY(200);
            _CONFIG_ROOT_.getChildren().add(reset_font);
            reset_font.setOnAction(command -> {
               textBox.setFont(new Font("Consolas",20));
               textBox.setStyle("-fx-font-style:normal;");
               textBox.setStyle("-fx-text-fill:BLACK;");
               font_box.setValue((String)textBox.getFont().getFamily());
               size_spin.getValueFactory().setValue(((int)textBox.getFont().getSize()));
               style_box.setValue("normal");
               clrpckr.setValue(Color.BLACK);
            });



	    //Theme section label
            Label theme_section = new Label("Configure theme");
            theme_section.setFont((Font)appear_logo.getFont());
            theme_section.setStyle("-fx-text-fill:rgb(60,60,60);");
            _CONFIG_ROOT_.getChildren().add(theme_section);
            theme_section.setLayoutX(365);
            theme_section.setLayoutY(300);


            //Spacer
            Separator sp3 = new Separator();
            sp3.setPrefWidth(355);
            sp3.setPrefHeight(5);
            sp3.setLayoutX(0);
            sp3.setLayoutY(312);
            _CONFIG_ROOT_.getChildren().add(sp3);


            //Spacer
            Separator sp4 = new Separator();
            sp4.setPrefWidth(340);
            sp4.setPrefHeight(5);
            sp4.setLayoutX(502);
            sp4.setLayoutY(312);
            _CONFIG_ROOT_.getChildren().add(sp4);

		
	    

            //set the window
            arg010.setTitle("Appearance");
            arg010.setResizable(false);
            arg010.setScene(arg011);

            //show the settings window
            arg010.show();

        }

	    
	

    }


    /**
     * Getter for the copied text
     */
    private String get_cpy_txt() { return cpyText; }


     /**
     * Get the text representation of a color
     */
    private Color get_clr_txt(TextArea arg0){

        //Get the styles
        String style = textBox.getStyle();

        //Extract the color params from the style property
        String clr_str = extract_clr_from_css_prop(style);

        //Convert the text to a color
        return Color.web(clr_str);

    }




    /**
     * Trim color parameters from java fx css property
     */
    private String extract_clr_from_css_prop(String arg01){

        //Default color string if the other from the css property is missing
        String clr_str = "#000000";

        String[] props = arg01.split(";");

        //Loop over properties and cut the unuseful parth if the css property
        for(String prop : props){
            if(prop.trim().startsWith("-fx-text-fill:")){
                clr_str = prop.split(":")[1].trim();
                break;
            }
        }

        return clr_str;

    }




    /**
     * Convert a color string to hex string
     */
    private String string_to_hex(Color arg03){

        return String.format(
                "#%02X%02X%02X",
                (int)(arg03.getRed() * 255),
                (int)(arg03.getGreen() * 255),
                (int)(arg03.getBlue() * 255)
        );

    }
	
	
}
