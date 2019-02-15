package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.layout.AnchorPane;

public class ControllerClass implements Initializable{

	@FXML
    private AnchorPane anchorPane;
	
	private double xOffset;
    private double yOffset;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.moveAnchorPane();
	}

	public void moveAnchorPane()
	{
		anchorPane.setOnMousePressed(event -> {
	            xOffset = Main.getPrimaryStage().getX() - event.getScreenX();
	            yOffset = Main.getPrimaryStage().getY() - event.getScreenY();
	            anchorPane.setCursor(Cursor.CLOSED_HAND);
	        });

		anchorPane.setOnMouseDragged(event -> {
			 Main.getPrimaryStage().setX(event.getScreenX() + xOffset);
			 Main.getPrimaryStage().setY(event.getScreenY() + yOffset);

	        });
		
		anchorPane.setOnMouseReleased(event -> {
			anchorPane.setCursor(Cursor.DEFAULT);
	        });
	}
	
	 @FXML
	 public void close(ActionEvent event) {

		 Main.getPrimaryStage().close();
	   
	 }

	

	  @FXML
	  public void min(ActionEvent event) {

	    	 Main.getPrimaryStage().setIconified(true);
	  }
	    
}
