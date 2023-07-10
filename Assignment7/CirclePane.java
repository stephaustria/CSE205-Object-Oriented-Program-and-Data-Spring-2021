// Assignment #7: Arizona State University CSE205
//          Name: Stephen Austria
//     StudentID: 1220159551
//       Lecture: T Th 1:30-2:45
//   Description: CirclePane class creates a pane where we can use
//                mouse key to drag on canvass and there will be some color following
//                the mouse. We can also use combo boxes to change its colors and stroke widths
//                //--- is where you need to add your own code

//import any necessary classes here
//----
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirclePane extends BorderPane
{
    //instance variables - check assignment's description
    //----

    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> bgColorCombo;
    private ComboBox<String> widthCombo;
    private Circle[][] circleArray;

    private final int NUM_COL =6, NUM_ROW = 6, RADIUS = 40;
    
    private GridPane canvas;	//this is where circles are drawn
 
    private Circle circle;
    
    private Color primaryColor, secondaryColor, bgColor;
    
    private Label primaryLabel, bgLabel, widthLabel;
    
    private int selectWidth;
    private int x,y;

    //constructor
    public CirclePane()
    {
        //Step #1: Initialize instance variables and set up the layout
		//----
    	
    	// Combo Box
    	primaryColorCombo = new ComboBox<String>();
    	primaryColorCombo.getItems().add("Black");
    	primaryColorCombo.getItems().add("Red");
    	primaryColorCombo.getItems().add("Green");
    	primaryColorCombo.getItems().add("Blue");
    	primaryColorCombo.setValue("Black");
    	
    	bgColorCombo = new ComboBox<String>();
    	bgColorCombo.getItems().add("White");
    	bgColorCombo.getItems().add("Beige");
    	bgColorCombo.getItems().add("AliceBlue");
    	bgColorCombo.getItems().add("Gold");
    	bgColorCombo.setValue("White");
    	
    	widthCombo = new ComboBox<String>();
    	widthCombo.getItems().add("1");
    	widthCombo.getItems().add("3");
    	widthCombo.getItems().add("5");
    	widthCombo.getItems().add("7");
    	widthCombo.setValue("1");
 
    	// Instance Variables
    	primaryColor = Color.BLACK;
    	secondaryColor = Color.GRAY;
    	bgColor = Color.WHITE;
    	
    	selectWidth = 1;
    	
    	primaryLabel = new Label("PrimaryColor");
    	bgLabel = new Label("BackgroundColor");
    	widthLabel = new Label("StrokeWidth");
    	

        //Instantiate the two dimensional circleArray that contains
        //6 columns and 6 rows of circles (36 in total)
        //----
    	
    	circleArray = new Circle[6][6];
    	for(int row = 0; row < 6; row++) {
    		for(int column = 0; column < 6; column++) {
    			circle = new Circle(row, column, RADIUS);
    			circleArray[row][column] = circle;
    			circleArray[row][column].setFill(bgColor);
    			circleArray[row][column].setStroke(Color.BLACK);
    			circleArray[row][column].setStrokeWidth(selectWidth);
    		}
    	}

        //instantiate canvas and set its width and height
        canvas = new GridPane();
        canvas.setPrefWidth(2*RADIUS * NUM_COL);
        canvas.setPrefHeight(2*RADIUS * NUM_ROW);

        //Use nested loop to instantiate the 6 columns by 6 rows of
        //Circle objects, add them inside the circleArrary
        //----
        //----
        for(int row = 0; row < 6; row++) {
        	for(int column = 0; column < 6; column++) {
        		canvas.add(circleArray[row][column], row, column);
        	}
        }

        //leftPane is a VBox, it should contain labels and the 3 comboBox
        VBox leftPane = new VBox();
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setStyle("-fx-border-color: black");
        leftPane.getChildren().addAll(primaryLabel, primaryColorCombo, bgLabel, bgColorCombo, widthLabel, widthCombo);
        //----
       
        //add leftPane and canvas to CirclePane
        //----

        this.setLeft(leftPane);
        this.setCenter(canvas);
        //Step 3: register the source nodes with its handler objects
        //----

        canvas.setOnMouseDragged(new MouseHandler());
        primaryColorCombo.setOnAction(new PrimaryColorHandler());
        bgColorCombo.setOnAction(new BackgroundColorHandler());
        widthCombo.setOnAction(new WidthHandler());
    }

    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
			//Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
			//to check whether the mouse key is dragged or released, etc
			//write your own codes here
            //----
        	
        	// Action will happen when mouse is clicked and dragged
        	if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        		x = (int)event.getX();
        		y = (int)event.getY();
        		x = x / 80;
        		y = y /80;
        		for(int row = 0; row < 6; row++) {
        			for(int column = 0; column < 6; column++) {
        				if (x == row && y == column) {
        					for(int i = 0; i < 6; i++) {
        						for(int a = 0; a < 6; a++) {
        							circleArray[i][a].setFill(bgColor);
        						}
        					}
        					// When mouse is on left side
        					if(column == 0) {
        						circleArray[row][column].setFill(primaryColor);
        						circleArray[row][column + 1].setFill(secondaryColor);
        						if(row != 0 && row !=5) {
        							circleArray[row + 1][column].setFill(secondaryColor);
        							circleArray[row - 1][column].setFill(secondaryColor);
        						}
        					}
        					// When mouse is on right side
        					if(column == 5) {
        						circleArray[row][column].setFill(primaryColor);
        						circleArray[row][column - 1].setFill(secondaryColor);
        						if(row != 0 && row != 5) {
        							circleArray[row + 1][column].setFill(secondaryColor);
        							circleArray[row - 1][column].setFill(secondaryColor);
        						}
        					}
        					// When mouse is on top side
        					if(row == 0) {
        						circleArray[row][column].setFill(primaryColor);
        						circleArray[row][column + 1].setFill(secondaryColor);
        						if(row != 0 && row != 5) {
        							circleArray[row][column + 1].setFill(secondaryColor);
        							circleArray[row][column - 1].setFill(secondaryColor);
        						}
        						
        					}
        					// When mouse is on bottom side
        					if(row == 5) {
        						circleArray[row][column].setFill(primaryColor);
        						circleArray[row - 1][column].setFill(secondaryColor);
        						if(column != 0 && column !=5) {
        							circleArray[row][column + 1].setFill(secondaryColor);
        							circleArray[row][column - 1].setFill(secondaryColor);
        						}
        					}
        					// When mouse is inside the outer layer
        					if(row > 0 && row < 5 && column > 0 && column < 5) {
        						circleArray[row][column].setFill(primaryColor);
        						circleArray[row + 1][column].setFill(secondaryColor);
        						circleArray[row - 1][column].setFill(secondaryColor);
        						circleArray[row][column + 1].setFill(secondaryColor);
        						circleArray[row][column - 1].setFill(secondaryColor);
        					}
        				}
        			}
        					
        		}
        	}
        }
    }//end MouseHandler

	//Step #2(B) - Primary and secondary color handler
    private class PrimaryColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
			//Write your own code here
			//----
        	
        	// Primary and secondary color when selected
        	if(primaryColorCombo.getValue().equals("Black")) {
        		primaryColor = Color.BLACK;
        		secondaryColor = Color.GRAY;
        	}
        	if(primaryColorCombo.getValue().equals("Red")) {
        		primaryColor = Color.RED;
        		secondaryColor = Color.PINK;
        	}
        	if(primaryColorCombo.getValue().equals("Green")) {
        		primaryColor = Color.GREEN;
        		secondaryColor = Color.LIGHTGREEN;
        	}
        	if(primaryColorCombo.getValue().equals("Blue")) {
        		primaryColor = Color.BLUE;
        		secondaryColor = Color.POWDERBLUE;
        	}

		}
    }//end PrimaryColorHandler

    //Step #2(C): background color handler
    //Write a private class called BackgroundColorHandler that handles the background
    //color changes
    //----
    //----
    private class BackgroundColorHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent event) {
    		
    		// Different bgColor is selected and new array of circles 
    		if(bgColorCombo.getValue().equals("White")) {
    			bgColor = Color.WHITE;
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setFill(bgColor);
    				}
    			}
    		}
    		if(bgColorCombo.getValue().equals("Beige")) {
    			bgColor = Color.BEIGE;
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setFill(bgColor);
    				}
    			}
    		}
    		if(bgColorCombo.getValue().equals("AliceBlue")) {
    			bgColor = Color.ALICEBLUE;
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setFill(bgColor);
    				}
    			}
    		}
    		if(bgColorCombo.getValue().equals("Gold")) {
    			bgColor = Color.GOLD;
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setFill(bgColor);
    				}
    			}
    		}
    	}
    
    }


    //Step #2(D): handle the stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        //write your own code
        //----
        //----
    	public void handle(ActionEvent event) {
    		
    		// New array of circles when new width is selected
    		if(widthCombo.getValue().equals("1")) {
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setStrokeWidth(1);
    				}
    			}
    		}
    		if(widthCombo.getValue().equals("3")) {
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setStrokeWidth(3);
    				}
    			}
    		}
    		if(widthCombo.getValue().equals("5")) {
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setStrokeWidth(5);
    				}
    			}
    		}
    		if(widthCombo.getValue().equals("7")) {
    			for(int row = 0; row < 6; row++) {
    				for(int column = 0; column < 6; column++) {
    					circleArray[row][column].setStrokeWidth(7);
    				}
    			}
    		}
    	}


    }//end of WidthHandler

} //end of CirclePane