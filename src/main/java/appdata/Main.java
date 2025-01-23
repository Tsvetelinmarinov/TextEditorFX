/**
 * TextEditor++
 */

package appdata;





import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import java.awt.GraphicsEnvironment;
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
     * @param arg0
     * @throws java.lang.Exception
     */
    @SuppressWarnings("exports")
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
        _root_.setStyle("-fx-background-color:WHITE;");


        Stage arg0 = new Stage();


        /**
         * New scene
         */
        arg1 = new Scene(_root_,850,550);

        //apply design to the scene
        //arg1.getStylesheets().add(Main.class.getResource("classic_theme.css")
        // .toExternalForm());


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
        textBox.setFont(new Font("Consolas",16));
        textBox.setStyle("-fx-text-fill:BLACK;");
        textBox.setLayoutX(0);
        textBox.setLayoutY(45);
        textBox.setPrefWidth(_root_.getWidth());
        textBox.setPrefHeight(_root_.getHeight() - 45);
        //Create a drop shadow effect
        textBox.setEffect(new DropShadow());
        //textBox.getStyleClass().add("text_box");
        _root_.getChildren().add(textBox);


        /**
         * Menu bar
         */
        menuBar = new MenuBar();
        menuBar.setBorder(null);
        menuBar.setLayoutX(0);
        menuBar.setLayoutY(0);
        menuBar.setPrefWidth(_root_.getWidth());
        menuBar.setPrefHeight(30);
        //menuBar.getStyleClass().add("menu_bar");
        menuBar.setStyle("-fx-background-color:WHITE;");
        _root_.getChildren().add(menuBar);


        /**
         * File menu
         */
        fileMenu = new Menu("File");
        fileMenu.setStyle("-fx-font-size:14;");
        menuBar.getMenus().add(fileMenu);


        /**
         * Edit menu
         */
        editMenu = new Menu("Edit");
        editMenu.setStyle("-fx-font-size:14;");
        menuBar.getMenus().add(editMenu);


        /**
         * Options menu
         */
        optionsMenu = new Menu("Options");
        optionsMenu.setStyle("-fx-font-size:14;");
        menuBar.getMenus().add(optionsMenu);


        /**
         * Help menu
         */
        helpMenu = new Menu("Help");
        helpMenu.setStyle("-fx-font-size:14;");
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
        info.setStyle("-fx-font-size:14;");
        helpMenu.getItems().add(info);
        info.setOnAction(command -> new _SYSTEM_().show_info_win());

    }











    /**
     * Main functionality
     */
    private final class _SYSTEM_{



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
            FileNameExtensionFilter docx = new FileNameExtensionFilter("document", "docx");
            FileNameExtensionFilter java = new FileNameExtensionFilter("java file", "java");
            FileNameExtensionFilter html = new FileNameExtensionFilter("html document", "html");
            FileNameExtensionFilter cs = new FileNameExtensionFilter("C# file", "cs");
            FileNameExtensionFilter cpp = new FileNameExtensionFilter("C++ file", "cpp");
            FileNameExtensionFilter header = new FileNameExtensionFilter("C++ header file", "h");
            FileNameExtensionFilter css = new FileNameExtensionFilter("style sheet", "css");
            FileNameExtensionFilter js = new FileNameExtensionFilter("java script file", "js");
            FileNameExtensionFilter xml = new FileNameExtensionFilter("xml configuration", "xml");
            FileNameExtensionFilter fxml = new FileNameExtensionFilter("fxml document", "fxml");


            //apply filters
            chooser.setFileFilter(txt);
            chooser.setFileFilter(docx);
            chooser.setFileFilter(java);
            chooser.setFileFilter(html);
            chooser.setFileFilter(cs);
            chooser.setFileFilter(cpp);
            chooser.setFileFilter(header);
            chooser.setFileFilter(css);
            chooser.setFileFilter(js);
            chooser.setFileFilter(xml);
            chooser.setFileFilter(fxml);



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
                    "Warning",JOptionPane.WARNING_MESSAGE
            );

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
                    "Warning",JOptionPane.WARNING_MESSAGE
            );

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
            Scene arg011 = new Scene(_CONFIG_ROOT_,830,570);

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
            sp2.setPrefWidth(360);
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
                    .IntegerSpinnerValueFactory(0,50,(int)textBox.getFont().getSize());
            ;


            //Font size spinner
            Spinner<Integer> size_spin = new Spinner<Integer>(f_size_spin_mdl);
            size_spin.setLayoutX(360);
            size_spin.setLayoutY(100);
            size_spin.setPrefWidth(70);
            size_spin.setPrefHeight(17);
            size_spin.setStyle("-fx-font-family:'Fira Code';");
            size_spin.setStyle("-fx-background-color:WHITE;");
            size_spin.setStyle("-fx-font-size:14;");
            _CONFIG_ROOT_.getChildren().add(size_spin);
            size_spin.valueProperty().addListener((
                    arg00,
                    arg01,
                    arg02) -> {
                textBox.setFont(new Font((String)textBox.getFont().getFamily(),(int)size_spin.getValue()));
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
            Color editor_fore = get_clr_from_style(style_prop);
            clrpckr.setValue(editor_fore);
            _CONFIG_ROOT_.getChildren().add(clrpckr);
            clrpckr.setOnAction(command -> {
                //Get the color from the color picker
                Color color = clrpckr.getValue();

                //apply changes
                textBox.setStyle("-fx-text-fill:" + clr_to_hex(color) + ";");

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
                textBox.setFont(new Font("Consolas",16));
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



            //Holds the theme options
            String[] themes = { "classic","dark","gray" };
            //Convert the string array to observable array list
            ObservableList<String> theme_options = FXCollections.observableArrayList(themes);


            //Theme box with the theme option
            ComboBox<String> theme_box = new ComboBox<String>(theme_options);
            theme_box.setValue("classic");
            theme_box.setPrefWidth(100);
            theme_box.setPrefHeight(20);
            theme_box.setLayoutX(250);
            theme_box.setLayoutY(348);
            theme_box.setStyle("-fx-font-size:14;");
            _CONFIG_ROOT_.getChildren().add(theme_box);


            //Theme label
            Label theme = new Label("theme");
            theme.setFont((Font)appear_logo.getFont());
            theme.setLayoutX(190);
            theme.setLayoutY(348);
            _CONFIG_ROOT_.getChildren().add(theme);


            //Configure appearance manual
            Button mnl_config = new Button("configure appearance manual");
            mnl_config.setFont((Font)reset_font.getFont());
            mnl_config.setPrefSize(250,18);
            mnl_config.setLayoutX(400);
            mnl_config.setLayoutY(348);
            _CONFIG_ROOT_.getChildren().add(mnl_config);
            mnl_config.setOnAction(command -> {
                //Anchor pane
                AnchorPane _MNL_CONFIG_ROOT_ = new AnchorPane();
                _MNL_CONFIG_ROOT_.setStyle("-fx-background-color:WHITE;");

                //New Stage
                Stage mnl_stg = new Stage();

                //New scene with the root
                Scene mnl_scene = new Scene(_MNL_CONFIG_ROOT_,500,300);

                //Spacer
                Separator sp00 = new Separator();
                sp00.setPrefSize(500,5);
                sp00.setLayoutX(0);
                sp00.setLayoutY(25);
                _MNL_CONFIG_ROOT_.getChildren().add(sp00);

                //Font label
                Label mnl_font = new Label("editor foreground");
                mnl_font.setFont((Font)appear_logo.getFont());
                mnl_font.setLayoutX(50);
                mnl_font.setLayoutY(50);
                _MNL_CONFIG_ROOT_.getChildren().add(mnl_font);

                //Font color picker
                ColorPicker pick = new ColorPicker();
                pick.setPrefSize(90, 25);
                pick.setLayoutX(205);
                pick.setLayoutY(53);
                //get the style string of the text box
                String text_box_style = textBox.getStyle();
                //Get the foreground of the text box
                Color txt_fore = get_clr_from_style(text_box_style);
                //Set it default value to the color picker
                pick.setValue(txt_fore);
                _MNL_CONFIG_ROOT_.getChildren().add(pick);
                pick.setOnAction(cmd -> {
                    //Get the selected color
                    Color clr = pick.getValue();

                    //set it to be foreground of the text box font
                    textBox.setStyle("-fx-text-fill:" + clr_to_hex(clr) + ";");
                });

                //reset foreground button
                Button rst_fore = new Button("reset");
                rst_fore.setPrefSize(60, 17);
                rst_fore.setLayoutX(390);
                rst_fore.setLayoutY(51);
                _MNL_CONFIG_ROOT_.getChildren().add(rst_fore);
                rst_fore.setOnAction(cmd -> pick.setValue(Color.BLACK));

                //Spacer
                Separator sp01 = new Separator();
                sp01.setPrefSize(400, 5);
                sp01.setLayoutX(50);
                sp01.setLayoutY(90);
                _MNL_CONFIG_ROOT_.getChildren().add(sp01);

                //Label
                Label mnl_txt_box_back = new Label("editor background");
                mnl_txt_box_back.setFont((Font)appear_logo.getFont());
                mnl_txt_box_back.setStyle("-fx-text-fill:rgb(60,60,60);");
                mnl_txt_box_back.setLayoutX(50);
                mnl_txt_box_back.setLayoutY(120);
                _MNL_CONFIG_ROOT_.getChildren().add(mnl_txt_box_back);

                //Application background color chooser
                ColorPicker app_back = new ColorPicker();
                app_back.setPrefSize(90,25);
                app_back.setLayoutX(205);
                app_back.setLayoutY(121);
                //set the application background color as default
                //color of the application background color picker
                String app_back_style = _root_.getStyle();
                Color app_back_clr = get_back_clr_from_style(app_back_style);
                app_back.setValue(app_back_clr);
                _MNL_CONFIG_ROOT_.getChildren().add(app_back);
                app_back.setOnAction(cmd -> {
                    Color clr = app_back.getValue();
                    _root_.setStyle("-fx-background-color:" + clr_to_hex(clr) + ";");
                });


                //Reset button
                Button rst_app_back = new Button("reset");
                rst_app_back.setFont((Font)rst_fore.getFont());
                rst_app_back.setPrefSize(60,17);
                rst_app_back.setLayoutX(390);
                rst_app_back.setLayoutY(120);
                _MNL_CONFIG_ROOT_.getChildren().add(rst_app_back);
                rst_app_back.setOnAction(cmd -> {
                    _root_.setStyle("-fx-background-color:WHITE;");
                    app_back.setValue(Color.WHITE);
                });


                //Spacer
                Separator sp02 = new Separator();
                sp02.setPrefSize(400,5);
                sp02.setLayoutX(50);
                sp02.setLayoutY(160);
                _MNL_CONFIG_ROOT_.getChildren().add(sp02);


                //Menu bar color label
                Label menu_clr = new Label("menu background");
                menu_clr.setFont((Font)mnl_txt_box_back.getFont());
                menu_clr.setLayoutX(50);
                menu_clr.setLayoutY(190);
                _MNL_CONFIG_ROOT_.getChildren().add(menu_clr);


                //Menu bar color chooser
                ColorPicker menu_bar_clr = new ColorPicker();
                menu_bar_clr.setPrefSize(90, 25);
                menu_bar_clr.setLayoutX(205);
                menu_bar_clr.setLayoutY(190);
                Color menu_bar_back = get_back_clr_from_style(menuBar.getStyle());
                menu_bar_clr.setValue(menu_bar_back);
                menu_bar_clr.setOnAction(cmd -> {
                    //get selected color from the color picker
                    Color clr = menu_bar_clr.getValue();

                    //Set the color as a background color of the menu bar
                    menuBar.setStyle("-fx-background-color:" + clr_to_hex(clr) + ";");
                });
                _MNL_CONFIG_ROOT_.getChildren().add(menu_bar_clr);


                //Reset menu bar background
                Button rst_menu_bar_clr = new Button("reset");
                rst_menu_bar_clr.setFont((Font)rst_fore.getFont());
                rst_menu_bar_clr.setPrefSize(60, 17);
                rst_menu_bar_clr.setLayoutX(390);
                rst_menu_bar_clr.setLayoutY(190);
                rst_menu_bar_clr.setOnAction(cmd -> {
                    menu_bar_clr.setValue(Color.WHITE);
                    menuBar.setStyle("-fx-background-color:WHITE;");
                });
                _MNL_CONFIG_ROOT_.getChildren().add(rst_menu_bar_clr);

                //Spacer
                Separator sp04 = new Separator();
                sp04.setPrefSize(400,5);
                sp04.setLayoutX(50);
                sp04.setLayoutY(230);
                _MNL_CONFIG_ROOT_.getChildren().add(sp04);


                //Spacer
                Separator sp05 = new Separator();
                sp05.setPrefSize(500,5);
                sp05.setLayoutX(0);
                sp05.setLayoutY(256);
                _MNL_CONFIG_ROOT_.getChildren().add(sp05);


                //Set the manual configuration window
                mnl_stg.setTitle("Configure appearance manual");
                mnl_stg.setResizable(false);
                mnl_stg.setScene(mnl_scene);

                //show window
                mnl_stg.show();

            });



            //set the appearance window
            arg010.setTitle("Appearance");
            arg010.setResizable(false);
            arg010.setScene(arg011);

            //show the window
            arg010.show();

        }




        /**
         * Show information window
         */
        private void show_info_win(){

            //New stage
            Stage info_stg = new Stage();

            //Anchor pane
            AnchorPane _INFO_ROOT_ = new AnchorPane();

            //New scene with the root component
            Scene arg01 = new Scene(_INFO_ROOT_,400,500);

            //Text box for the information
            TextArea info = new TextArea();
            info.setFont(new Font("System",14));
            Color back = get_back_clr_from_style(info.getStyle());
            info.setStyle("-fx-background-color:" + clr_to_hex(back) + ";");
            info.setStyle("-fx-caret-color:" + clr_to_hex(back) + ";");
            info.setEditable(false);
            info.setPrefSize(_INFO_ROOT_.getWidth() + 2,_INFO_ROOT_.getHeight() - 50);
            info.setLayoutX(-1);
            info.setLayoutY(51);
            info.setText(
              "\n > Application version\n" +
              "    1.0.0\n\n > Description\n    Text editor for every day use\n\n > Programmer\n    Tsvetelin Marinov" +
              "\n\n > License\n    Free to use\n\n > Place\n    Sofia, Bulgaria, EU\n\n > Date\n    05/01/2025"
            );
            _INFO_ROOT_.getChildren().add(info);



            //set the window
            info_stg.setTitle("Information");
            info_stg.setResizable(false);
            info_stg.setScene(arg01);

            //show the window
            info_stg.show();

        }




    }


    /**
     * Getter for the copied text
     */
    private String get_cpy_txt() { return cpyText; }




    /**
     * Get color from css property
     */
    private Color get_clr_from_style(String arg0){
        //Extract the color params from the style property
        String clr_str = extract_clr_from_css_prop(arg0);

        //Convert the text to a color
        return Color.web(clr_str);

    }




    /**
     * Get the background color of any component
     */
    private Color get_back_clr_from_style(String style_property){

        //Extract the color params from the style property
        String clr_str = extract_background_from_css_prop(style_property);

        //Convert the text to a color
        return Color.web(clr_str);

    }



    /**
     * Get the border color of any component
     */
    private Color get_border_clr_from_style(String style_property){

        //Extract the color params from the style property
        String clr_str = extract_border_from_css_prop(style_property);

        //Convert the text to a color
        return Color.web(clr_str);

    }




    /**
     * Trim foreground color parameters from java fx css property
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
     * Trim background color parameters from java fx css property
     */
    private String extract_background_from_css_prop(String arg01){

        //Default color string if the other from the css property is missing
        String clr_str = "#000000";

        String[] props = arg01.split(";");

        //Loop over properties and cut the unuseful parth if the css property
        for(String prop : props){
            if(prop.trim().startsWith("-fx-background-color:")){
                clr_str = prop.split(":")[1].trim();
                break;
            }
        }

        return clr_str;

    }



    /**
     * Trim border color parameters from java fx css property
     */
    private String extract_border_from_css_prop(String arg01){

        //Default color string if the other from the css property is missing
        String clr_str = "#000000";

        String[] props = arg01.split(";");

        //Loop over properties and cut the unuseful parth if the css property
        for(String prop : props){
            if(prop.trim().startsWith("-fx-border-color:")){
                clr_str = prop.split(":")[1].trim();
                break;
            }
        }

        return clr_str;

    }




    /**
     * Convert a color to hex string
     */
    private String clr_to_hex(Color arg03){

        return String.format(
                "#%02X%02X%02X",
                (int)(arg03.getRed() * 255),
                (int)(arg03.getGreen() * 255),
                (int)(arg03.getBlue() * 255)
        );

    }


}

