import java.util.ArrayList;

public class User extends Playlist implements Playable {

//Attributes
protected String userName;
protected static int ID = 0;
protected Playlist userPlaylist;	
protected ArrayList<String> user= new ArrayList<String>();
protected ArrayList<Integer> Id = new ArrayList<Integer>();
//Non-parameterized constructor
User(){
	this.userName = "Unknown";
	User.ID = 0;
	this.userPlaylist =  new Playlist();
}	
	
//Parametrized constructor
User(String userName, Playlist userPlaylist){
	if (userName != null && ID > 0 && userPlaylist != null){
		this.userName = userName;
		ID++;
		Id.add(ID);
		user.add(userName);
		this.userPlaylist = userPlaylist;
	} else {
		this.userName = "Unknown";
		User.ID = 0;
		this.userPlaylist =  new Playlist();
	}
}	

public ArrayList<Recording> add(int idnumber) {
	for (int i = 0; i < Id.size(); i++) {
        if (idnumber == Id.get(i)) {
        	return recordingList;
        }
	}
	return null;
}

public void Adduser(String username) {
	user.add(username);
}
	
//Setters                        
public void setUserName(String userName){ 
	if (userName != null){            
		this.userName = userName;         
	}                             
}                                 	
	
void setUserPlaylist(Playlist userPlaylist){ 
	if (userPlaylist != null){            
		this.userPlaylist = userPlaylist;         
	}                             
}     
	

//Getter
public int getID() {
	return ID;
}

//play() method
public void play(){
	if (this.durationInSeconds > 0){
		System.out.println("Now playing: " + this.toString());
	} else {
		System.out.println("ERROR: Cannot play this recording.");
	}
}

// SavePlaylist 
public void SavePlaylist(){

}

//To String 
public String toString(){
	return this.userName + " - " + User.ID ;	
}
	








}
