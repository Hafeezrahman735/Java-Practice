public abstract class Recording implements Playable {
	
//Attributes 
protected String artist;
protected String recordingName;
protected int durationInSeconds;

// Non-parameterized constructor
protected Recording(){
	this.artist = "Unknown";
	this.recordingName = "Unknown";
	this.durationInSeconds = 0;
}

// Parametrized constructor
protected Recording(String artist, String recordingName, int durationInSeconds){
	if (artist != null && recordingName != null && durationInSeconds > 0){
		this.artist = artist;
		this.recordingName = recordingName;
		this.durationInSeconds = durationInSeconds;
	} else {
		this.artist = "Unknown";
		this.recordingName = "Unknown";
		this.durationInSeconds = 0;
	}
}

public String getartist(){
	return this.artist;
}

public String getName(){
	return this.recordingName;
}

public int getDuration(){
	return this.durationInSeconds;
}

// play() method
public void play(){
		if (this.durationInSeconds > 0){
			System.out.println("Now playing: " + this.toString());
		} else {
			System.out.println("ERROR: Cannot play this recording.");
		}
	}

// toString() method
public String toString(){
	return this.artist + " - " + this.recordingName + " [" + ((int) Math.floor(this.durationInSeconds/60)) + "m" + (this.durationInSeconds % 60) + "s]";	
}
}