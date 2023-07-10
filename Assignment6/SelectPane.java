// Assignment #: 6
// Arizona State University - CSE205
// Name: Stephen Austria 
// Student ID: 1220159551
// Lecture Date and Time: Tuesday and Thursday 1:30 - 2:45
//  Description: SelectPane displays a list of available department
//  from which a user can select and compute total number of faculties in multiple departments.

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
// import all other necessary JavaFX classes here
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
* SelectPane displays a list of available departments from which a user
* can select and compute total number of faculties for selected departments.
*/
public class SelectPane extends BorderPane {

    //declare instance varibales
    private ArrayList<Department> departList;
    private static VBox checkboxContainer;
    private Label topLabel, bottomLabel;
    private int totalFaculty = 0;
 


    public SelectPane(ArrayList<Department> list) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */

        this.departList = list;
        topLabel = new Label("Select Department(s)");
        bottomLabel = new Label("The total number of faculty for the selected: 0");


        // Wrap checkboxContainer in ScrollPane so formatting is
        // correct when many departments are added
        
        checkboxContainer = new VBox();
        ScrollPane scrollPane = new ScrollPane(checkboxContainer);
        this.setTop(topLabel);
        this.setCenter(scrollPane);
        this.setBottom(bottomLabel);


        


    } // end of SelectPane constructor

    // This method uses the newly added parameter Department object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateDepartList(Department newdep) {
        // Create checkbox for new department with appropriate text
    	
    	CheckBox checkBox = new CheckBox(newdep.toString());
        // Bind checkbox toggle action to event handler
        // Passes the number of faculties in each department to the handler. When the checkbox is
        // toggled,this number will be added/subtracted from the total number of selected faculties

    	checkBox.setOnAction(new SelectionHandler(newdep.getNumberOfMembers()));

        // Add new checkbox to checkbox container

    	checkboxContainer.getChildren().add(checkBox);
    } // end of updateDepartList method

    /**
     * SelectionHandler This class handles a checkbox toggle event. When the
     * checkbox is toggled, this number will be added/subtracted from the total
     * number of selected faculties.
     */
    private class SelectionHandler implements EventHandler<ActionEvent> {
        // Instance variable for number of faculties associated with a given department/checkbox
        private int faculties;


        public SelectionHandler(int members) {
            this.faculties = members; // Set instance variable
        } // end of SelectionHandler constructor

        //over-ride the abstarct method handle
        public void handle(ActionEvent event) {
            // Get the object that triggered the event, and cast it to a checkbox, since
            // only a department checkbox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method
        	boolean selected = ((CheckBox)event.getSource()).isSelected();
        	
            // Update the selected Faculties label with the new number of selected faculties
        	
        	if(selected) {
        		totalFaculty = totalFaculty + faculties;
        		bottomLabel.setText("The total number of faculty selected: " + totalFaculty);
        	} else {
        		totalFaculty = totalFaculty - faculties;
        		bottomLabel.setText("The total number of faculty selected: " + totalFaculty);
        	}

        } // end handle method
    } // end of SelectHandler class
} // end of SelectPane class
