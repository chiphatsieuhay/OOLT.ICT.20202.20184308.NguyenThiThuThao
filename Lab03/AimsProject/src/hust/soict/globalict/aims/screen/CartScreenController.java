package hust.soict.globalict.aims.screen;



import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.Interface.Playable;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.MediaScreen.Play;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
//	
	
	@FXML
	private Label totalCost   ;
	@FXML
	private TableView<Media> tblMedia ;
	
	@FXML 
	private TableColumn<Media,String> colMediaTitle = new  TableColumn<Media,String>();
	
	@FXML 
	private TableColumn<Media,String> colMediacategory = new  TableColumn<Media,String>();
	
	@FXML 
	private TableColumn<Media,String> colMediaCost = new  TableColumn<Media,String>();
	
	public CartScreenController(Cart cart) {
		super();
		this.cart=cart;
		
	}
	
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media.getId());
		System.out.print("total cost"+(cart.totalCost()-media.getCost()));
		cart.showCart();
		totalCost.setText(cart.totalCost()+"$");
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		//new Play();
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof Playable) {
			((Playable) media).play();
		}
		
	}
	
	@FXML
	void viewCartPressed(ActionEvent event) {
		new CartScreen(cart);
	}
	
	@FXML
	void addBookPressed(ActionEvent event) {
		new AddBookToStoreScreen(cart);
	}
	
	@FXML
	void addCDPressed(ActionEvent event) {
		new AddCompactDiscToStoreScreen(cart);
	}
	
	@FXML
	void addDVDPressed(ActionEvent event) {
		new AddDigitalVideoDiscToStoreScreen(cart);
	}
	
	@FXML
	void viewStorePressed(ActionEvent event) {
//		new StoreScreen(cart);
	}
	
	
	
	
	@FXML
	private void initialize() {
		cart.showCart();
		totalCost.setText(String.valueOf(cart.totalCost())+"$");
		
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,String>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>(){
					
					@Override
					public void changed(ObservableValue<? extends Media> observable,Media oldValue,Media newValue) {
						if (newValue!=null) {
							updateButtonBar(newValue);
						}
					}

					
				});
		
	}
}
