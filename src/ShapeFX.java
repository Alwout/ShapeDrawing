import java.util.ArrayList;

import com.wouterbaudoin.decorator.BorderDecorator;
import com.wouterbaudoin.decorator.CircleShape;
import com.wouterbaudoin.decorator.RectangleShape;
import com.wouterbaudoin.decorator.ColorShapeDecorator;
import com.wouterbaudoin.decorator.PolyShapeDecorator;
import com.wouterbaudoin.decorator.Shape;
import com.wouterbaudoin.decorator.TriangleShape;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShapeFX extends Application {
	
	final int WINDOW_WIDTH = 800;
	final int WINDOW_HEIGHT = 800;
	
	BorderDecorator borderDecorator;
	ColorShapeDecorator colorDecorator;
	Shape currentShape; //The currently selected shape that is or will be decorated.
	Shape drawnShape; //The shape that is drawn
	ArrayList<TextField> polygonFields = new ArrayList<TextField>();
	Double[] polygonPoints = new Double[6];
	int addedPolygons = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Group root = new Group();

		currentShape = new CircleShape(root);
		
		Text text1 = createText("Shapes", 100, 25);
		Text text4 = createText("Polygon points", 100, 175);
	 	Text text2 = createText("Fill Colors", 100, 275);
	 	Text text3 = createText("Border Colors", 100, 475);
	 	
	 	TextField tf1 = createTextField(0, 200);
	    TextField tf2 = createTextField(50, 200);
	    TextField tf3 = createTextField(100, 200);
	    TextField tf4 = createTextField(150, 200);
	    TextField tf5 = createTextField(200, 200);
	    TextField tf6 = createTextField(250, 200);

		Button btn1 = createColorButton("Red", 0, 300, "#ff0000");
		Button btn2 = createColorButton("Green", 100, 300, "#00ff00");
		Button btn3 = createColorButton("Blue", 200, 300, "#0000ff");
		Button btn4 = createColorButton("Pink", 0, 350, "#FFC0CB");
		Button btn5 = createColorButton("Orange", 100, 350, "#FFA500");
		Button btn6 = createColorButton("Yellow", 200, 350, "#FFFF00");
		
		Button btn8 = createBorderButton("Red", 0, 500, "#ff0000");
		Button btn9 = createBorderButton("Green", 100, 500, "#00ff00");
		Button btn10 = createBorderButton("Blue", 200, 500, "#0000ff");
		Button btn11 = createBorderButton("Pink", 0, 550, "#FFC0CB");
		Button btn12 = createBorderButton("Orange", 100, 550, "#FFA500");
		Button btn13 = createBorderButton("Yellow", 200, 550, "#FFFF00");
		
		Button btn7 = new Button("Create");
		btn7.setStyle("-fx-background-color: #ffffff; ");
		btn7.setPrefSize(200, 100);
		btn7.setLayoutX(450);
		btn7.setLayoutY(550);
		btn7.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent arg0) {  
            	if (drawnShape != null) {
            		drawnShape.clear();
            	}
            	if (arePolygonPointsFilled()) {
            		System.out.println("Polygon points added");
            		currentShape = new PolyShapeDecorator(polygonPoints, currentShape); 
            	}
            	currentShape.draw();
            	drawnShape = currentShape;
            }  
        });
		
		Rectangle shapeBorder = new Rectangle();
	    shapeBorder.setLayoutX(350);
	    shapeBorder.setLayoutY(150);
	    shapeBorder.setWidth(400);
	    shapeBorder.setHeight(400);
	    shapeBorder.setFill(null);
	    shapeBorder.setStrokeWidth(4);
	    shapeBorder.setStroke(Color.WHITE);
		
	    Rectangle shapeSelect = new Rectangle();
	    shapeSelect.setLayoutX(0);
	    shapeSelect.setLayoutY(50);
	    shapeSelect.setWidth(100);
	    shapeSelect.setHeight(100);
	    shapeSelect.setFill(null);
	    shapeSelect.setStrokeWidth(4);
	    shapeSelect.setStroke(Color.GOLD);
		
		Circle circle = new Circle();  
	    circle.setCenterX(50);  
	    circle.setCenterY(100); 
	    circle.setRadius(50);
	    circle.setOnMouseReleased(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent arg0) {
                currentShape = new CircleShape(root);
                applyBorderDecorator(currentShape);
                applyColorDecorator(currentShape);
                shapeSelect.setLayoutX(circle.getCenterX() - 50);
                shapeSelect.setLayoutY(circle.getCenterY() - 50);
            }  
        });
	    
	    Rectangle rect = new Rectangle(); //instantiating Rectangle
	    rect.setX(100); //setting the X coordinate of upper left //corner of rectangle   
	    rect.setY(50); //setting the Y coordinate of upper left //corner of rectangle   
	    rect.setWidth(100); //setting the width of rectangle   
	    rect.setHeight(100); // setting the height of rectangle   
	    rect.setOnMouseReleased(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent arg0) {
                currentShape = new RectangleShape(root);
                applyBorderDecorator(currentShape);
                applyColorDecorator(currentShape);
                shapeSelect.setLayoutX(rect.getX());
                shapeSelect.setLayoutY(rect.getY());
            }  
        });
	    
	    Polygon triangle = new Polygon();  
	    triangle.getPoints().addAll(new Double[]{  
	        250.0, 50.0,  
	        200.0, 150.0,  
	        300.0, 150.0 });
	    triangle.setOnMouseReleased(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent arg0) {
                currentShape = new TriangleShape(root);
                applyBorderDecorator(currentShape);
                applyColorDecorator(currentShape);
                shapeSelect.setLayoutX(200);
                shapeSelect.setLayoutY(50);
            }  
        });
		
    	Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT, Color.LIGHTSKYBLUE);
    	root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, text1, text2, text3, text4, tf1, tf2, tf3, tf4, tf5, tf6, circle, rect, triangle, shapeBorder, shapeSelect);
        
        primaryStage.setTitle("Shape Creator");  
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();  
	}
	
	private Button createColorButton(String text, int x, int y, String buttonColor) {
		Button newButton = new Button(text);
		newButton.setStyle("-fx-background-color: "+ buttonColor +"; ");
		newButton.setLayoutX(x);
		newButton.setLayoutY(y);
		newButton.setPrefSize(100, 50);
		newButton.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent arg0) {  
            	colorDecorator = new ColorShapeDecorator(Color.web(buttonColor), currentShape);
            	currentShape = colorDecorator;
            }  
        });
		return newButton;
	}
	
	private Button createBorderButton(String text, int x, int y, String buttonColor) {
		Button newButton = new Button(text);
		newButton.setStyle("-fx-background-color: "+ buttonColor +"; ");
		newButton.setLayoutX(x);
		newButton.setLayoutY(y);
		newButton.setPrefSize(100, 50);
		newButton.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent arg0) {  
            	borderDecorator = new BorderDecorator(Color.web(buttonColor), currentShape);
            	currentShape = borderDecorator;
            }  
        });
		return newButton;
	}
	
	private Text createText(String text, int x, int y) {
		Text newText = new Text(text);
		newText.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR,24));
	 	newText.setLayoutX(x);
	 	newText.setLayoutY(y);
	 	return newText;
	}
	
	private TextField createTextField(int x, int y) {
		TextField newTextField = new TextField();
	 	newTextField.setLayoutX(x);
	 	newTextField.setLayoutY(y);
	 	newTextField.setPrefSize(50, 50);
	 	polygonFields.add(newTextField);
	 	return newTextField;
	}
	
	private boolean arePolygonPointsFilled() {
		try {
			addedPolygons = 0;
			polygonFields.forEach(textField -> {
        		if (!textField.getText().isEmpty()) {
        			int polyIndex = polygonFields.indexOf(textField);
        			Double baseDouble = Double.parseDouble(textField.getText());
        			if (polyIndex % 2 == 0) {
        				baseDouble += 350;
        			} else {
        				baseDouble += 150;
        			}
        			polygonPoints[polyIndex] = baseDouble;
        			addedPolygons += 1;
        		}
        	});
			
			if (addedPolygons == 6) {
				return true;
			}
		} catch(NumberFormatException e) {
    	  return false;
    	}
		return false;

	}
	
	private void applyBorderDecorator(Shape shape) {
		if (borderDecorator != null) {
        	Color decoratorColor = borderDecorator.color;
        	borderDecorator = new BorderDecorator(decoratorColor, shape);
        }
	}
	
	private void applyColorDecorator(Shape shape) {
		if (colorDecorator != null) {
        	Color decoratorColor = colorDecorator.color;
        	colorDecorator = new ColorShapeDecorator(decoratorColor, shape);
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
