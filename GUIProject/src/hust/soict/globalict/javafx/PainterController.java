package hust.soict.globalict.javafx;

 

//import java.awt.Color;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

 

public class PainterController {
	Color color = new Color(0, 0, 0, 0) ;
	
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadio;
    @FXML
    private RadioButton EraserRadio;
 

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
        
    }
    @FXML
    void checkPen(ActionEvent event) {
    	EraserRadio.setSelected(false);
        color = Color.BLACK;
    }
    @FXML
    void checkEraser(ActionEvent event) {
    	penRadio.setSelected(false);
    	color = Color.WHITE;
    }
 

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(),event.getY(),4);
        newCircle.setStroke(color);
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    
}