package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import api.AudioPlayer;
import api.PlaylistController;
import api.UserProfileController;
import data.models.User;
import data.models.UserProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MainAppController implements Initializable {
	@FXML
	private ListView playlistScreen;
	@FXML
	private ImageView addPlaylist;
	@FXML
	private ImageView playMusic;
	@FXML
	private ImageView previousMusic;
	@FXML
	private ImageView nextMusic;
	@FXML
	private ImageView stopMusic;
	@FXML
	private ImageView Mute;
	@FXML
	private Text songName;
	@FXML
	private Text artistName;
	@FXML
	private Label userNameText;
	@FXML
	private Slider sldVolume;
	@FXML
	private TableView Result;
	@FXML
	private TableColumn col1;
	@FXML
	private TableColumn col2;
	@FXML
	private TableColumn col3;
	@FXML
	private TableColumn col4;
	@FXML
	private TableColumn col5;
	@FXML 
	private TableView playlistTable;
	@FXML 
	private TableColumn delete;
	@FXML
	private TableColumn playlistName;
	

	// search buttons
	@FXML
	private ImageView btnAlbum;
	@FXML
	private ImageView btnSong;
	@FXML
	private ImageView btnArtist;
	
	// Search bar 
	@FXML
	private TextField txtSearch;
	
	private static User currentUser = MainController.getUser();
	private UserProfileController uc = new UserProfileController();
	private UserProfile up= uc.GetUserProfile(currentUser.getUserID());;
	private PlaylistController pc = new PlaylistController(currentUser.getUserID());
	
	// Audio player
	AudioPlayer player = new AudioPlayer();

	// we need a search function to update the result page !
	// make if song button is clicked then 
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// Change the label to the username
		userNameText.setText(currentUser.getUsername());
		setTablePlaylist();
		
	}

	@FXML
	public void btnSong(MouseEvent event) 
	{
		setTableSearch();
		search(txtSearch.getText(), "song");
		
	}
	// make if album button is clicked then 
	@FXML
	public void btnAlbum(MouseEvent event) throws IOException {
		setTableSearch();
		search(txtSearch.getText(), "album");
	}
	
	// make if artist button is clicked then 
	@FXML
	public void btnArtist(MouseEvent event) throws IOException {
		setTableSearch();
		search(txtSearch.getText(), "artist");
	}
	
	
	private void search(String text, String type) {
		if(type == "song") {
			//update result page to search for that song
			
			// #1 use the search function from "Trisha"
			
			
			// #2 update the result page from "Xinyi"
			
			
		} else if(type == "album") {
			//update result page to search for that album
			
			// #1 use the search function from "Trisha"
			
			
			// #2 update the result page from "Xinyi"
			
		} else if(type == "artist") {
			//update result page to search for that artist
			
			// #1 use the search function from "Trisha"
			
			
			// #2 update the result page from "Xinyi"
			
		}
	}

	public void setTablePlaylist()
	{
		col1.setText("Name");
		col2.setText("Artist");
		col3.setText("Album");
		col4.setText("DateAdded");
		col5.setText("Delete");
	}
	
	public void setTableSearch()
	{
		col1.setText("Name");
		col2.setText("Artist");
		col3.setText("Album");
		col4.setText("DateAdded");
		col5.setText("Add");
	}

	// Event Listener on ImageView[#addPlaylist].onMouseClicked
	@FXML
	public void addPlaylistClicked(MouseEvent event) 
	{
		showInputBox();
	}
	
	public void showInputBox()
	{
		TextInputDialog dialog = new TextInputDialog("");
		 
		dialog.setTitle("Enter Playlist Name");
		dialog.setHeaderText("Enter the playlist name:");
		dialog.setContentText("Name:");
		Optional<String> result = dialog.showAndWait();
		//create new playlist
		if(result.isPresent())
		{
			String playlistName = result.get();
			pc.CreatePlaylist(playlistName);
			//maybe do a refresh here to show new playlist on the sidebar
		}
	}
	
	// Event Listener on ImageView[#playMusic].onMouseClicked
	@FXML
	public void playMusicClicked(MouseEvent event) 
	{
		player.Play();
	}
	// Event Listener on ImageView[#previousMusic].onMouseClicked
	@FXML
	public void previousIsClicked(MouseEvent event) 
	{
		player.Previous();
	}
	// Event Listener on ImageView[#nextMusic].onMouseClicked
	@FXML
	public void nextIsClicked(MouseEvent event) 
	{
		player.Next();
	
	}
	// Event Listener on ImageView[#stopMusic].onMouseClicked
	@FXML
	public void musicStopClicked(MouseEvent event) 
	{
		player.Pause();
	}
	// Event Listener on ImageView[#Mute].onMouseClicked
	@FXML
	public void muteIsClicked(MouseEvent event) 
	{
		player.setVolume(0);
	}
	// Event Listener on ImageView[#exit].onMouseClicked

	
	public void updateInfo() {
		
		// Have not tested this!
		songName = new Text(player.currentSong.getTitle());

		
		// The function in song.java is commented out
		
		//artistName = new Text(player.currentSong.getArtist());
	}
	
	
	// The volume slider is not working yet 
	@FXML
	public void onSliderChanged(MouseEvent event) {

	    sldVolume.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
            	
            	float sliderValue = (float) sldVolume.getValue();
            	
            	player.setVolume(sliderValue);
                System.out.println("here: "+ sliderValue );
            }
        });
	    

	}
		
	
	
}
