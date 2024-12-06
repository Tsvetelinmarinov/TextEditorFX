
();
    	 
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
    			 
    			 //close the scanner to avoid direct contact with the system
    			 scan.close();
    		 }else {
    			 JOptionPane.showInternalMessageDialog(null,"Unsupported file!","Error",
    					 JOptionPane.ERROR_MESSAGE);
    		 }
    	 }else {
    		 JOptionPane.showInternalMessageDialog(null, "No file selected to open!","Warning",
    				     JOptionPane.WARNING_MESSAGE);
    	 }
     }
     
     
     
     
     /**
      * Save your file
      */
     public void exportDataToLocalFile(ActionEvent actn_evnt) throws FileNotFoundException {
    	 //The new file
    	 File document;
    	 
    	 //FileChooser to choose where to select your file
    	 JFileChooser fl_chooser = new JFileChooser();
    	 
    	 //PrintWriter to write the text from your text box to the new file
    	 PrintWriter printer = null;
    	 
    	 //Hold the response from the file chooser
    	 int resp;
    	 
    	 //show file chooser and select where to save
    	 resp = fl_chooser.showSaveDialog(null);
    	 
    	 //Check if the 'save' button is clicked
    	 @SuppressWarnings("static-access")
    	 boolean fileHasBeenSelectedToExport = (resp == fl_chooser.APPROVE_OPTION)
    			  ? true : false;
    	 
    	 //if directory is pointed and the 'save' button is clicked get the
    	 //text from the text box and write it in the new file
    	 if(fileHasBeenSelectedToExport) {
    		 //Create the file
    		 document = new File(fl_chooser.getSelectedFile().getAbsolutePath());
    		 
    		 //Create the printer
    		 printer = new PrintWriter(document);
    		 
    		 if(document.isFile()) {
    			 printer.println((String)textBox.getText());
    		 }else {
    			 JOptionPane.showInternalMessageDialog(null, "Unsupported file!","Error",
    					    JOptionPane.ERROR_MESSAGE);
    		 }
    		 
    		 //close the printer to avoid contact with the system
    		 printer.close();
    	 }else {
    		 JOptionPane.showInternalMessageDialog(null,"No directory select for export!","Warning",
    				       JOptionPane.WARNING_MESSAGE);
    	 }
    	 
     }
}
