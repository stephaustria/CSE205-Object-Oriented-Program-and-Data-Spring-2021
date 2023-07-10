// Assignment 6: ASU - CSE 205
// Name: Stephen Austria 
// StudentID: 1220159551
//Lecture Date and Time: Tuesday and Thursday 1:30 - 2:45
//  Description: GeneratePane creats a pane where a user can enter
//  department information and create a list of available departments.

/* --------------- */
/* Import Packages */
/* --------------- */

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// JavaFX classes
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class GeneratePane extends HBox {
   
	// Initialized variables
	
    ArrayList<Department> departList;
    private SelectPane selectPane; // The relationship between GeneratePane and SelectPane is Aggregation
    private TextField text1, text2, text3;
    private Button addDepart;
    private TextArea textArea;
    private Label depText, numFacText, uniText, error1, error2, error3, add;
    private BorderPane msg;

    /**
     * CreatePane constructor
     *
     * @param list   the list of departments
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Department> list, SelectPane sePane) {
        this.departList = list;
        this.selectPane = sePane;
        text1 = new TextField();
        text2 = new TextField();
        text3 = new TextField();
        addDepart = new Button("Add a Department");
        textArea = new TextArea();
        depText = new Label("Department Title");
        numFacText = new Label("Number of Faculty");
        uniText = new Label("Name of University");

        //initialize each instance variable (textfields, labels, textarea, button, etc.)
		//and set up the layout
        
        textArea.setText("No Department");
        textArea.setPrefSize(450, 350);
        textArea.setEditable(false);

		//create a GridPane to hold labels & text fields.
		//you can choose to use .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(2);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
		// Set both left and right columns to 50% width (half of window)
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
		//You might need to create a sub pane to hold the button

        GridPane subPane = new GridPane();
        subPane.setAlignment(Pos.CENTER);
        subPane.setPadding(new Insets(0, 10, 10, 150));
        
		// Grid pane initialized for Grid Pane

        gridPane.add(depText, 1, 1);
        gridPane.add(text1, 2, 1);
        gridPane.add(numFacText, 1, 2);
        gridPane.add(text2, 2, 2);
        gridPane.add(uniText, 1, 3);
        gridPane.add(text3, 2, 3);
        subPane.add(addDepart, 2, 0);
        
        msg = new BorderPane();
		
		//Note: a ScrollPane will be added to it automatically when there are no more space
		//Add the left half and right half to the GeneratePane
        
        VBox leftSide = new VBox(msg, gridPane, subPane);
        VBox rightSide = new VBox(textArea);
        
		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
        this.getChildren().addAll(leftSide, rightSide);
        this.setSpacing(150);
        GeneratePane.setMargin(rightSide, new Insets(10, 10, 10, 10));
        // Bind button click action to event handler
        
        addDepart.setOnAction(new ButtonHandler());


    } // end of constructor

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a department" is pushed
     * or not, When the event occurs, it get a department's Title, number of faculties,
     * and its university information from the relevant text fields, then create a
     * new department and adds it to the departList. Meanwhile it will display the department's
     * information inside the text area. using the toString method of the Department
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of faculty
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        /**
         * handle Override the abstract method handle()
         */
        public void handle(ActionEvent event) {
            // Declare local variables
            Department newDepart;
            int numberOfFaculty = 0;
            boolean isEmptyFields = false;

            // If any field is empty, set isEmptyFields flag to true
            // Display error message if there are empty fields
          
            if (text1.getText() == null || text2.getText() == null || text3.getText() == null || text1.getText().trim().isEmpty() || text2.getText().trim().isEmpty() || text3.getText().trim().isEmpty()) {
            	isEmptyFields = true;
            	error1 = new Label("Please fill all fields");
            	error1.setTextFill(Color.RED);
            	msg.setTop(error1);
            }
            	
            
            // If all fields are filled, try to add the department
            try {
            	
            	newDepart = new Department();
            	newDepart.setDeptName(text1.getText());
            	newDepart.setNumberOfMembers(Integer.parseInt(text2.getText()));
            	newDepart.setUniversity(text3.getText());
     
            	departList.add(newDepart);
            	 // Displays "Department added" when a new department is added
            	add = new Label("Department added");
            	add.setTextFill(Color.RED);
            	msg.setTop(add);
            	
            	for (int i = 0; i < departList.size(); i++) {
            		for (int x = i + 1; x < departList.size(); x++) {
            			if (departList.get(i).getDeptName().equals(departList.get(x).getDeptName()) && departList.get(i).getUniversity().equals(departList.get(x).getUniversity())) {
            				departList.remove(newDepart);
            				
            				int a = 1/0;
            				
            	
            			}
            		}
            	}
                    

            	textArea.appendText(newDepart.toString());
            	selectPane.updateDepartList(newDepart);
            	
            	
           
            
                } //end of try
            	
            	
                catch (NumberFormatException e) {
                    // Displays "PLease enter an integer for the number of faculty" when an integer is not input
                	error2 = new Label("Please enter an integer for the number of faculty");
                	error2.setTextFill(Color.RED);
                	msg.setTop(error2);
                } 
                catch (Exception e) {
                    
                	// Displays "Department not added - already exist" when a duplicate department is trying to be added 
                	error3 = new Label("Department not added - already exist");
                	error3.setTextFill(Color.RED);
                	msg.setTop(error3);
                }

            
          
        	
        } // end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class



