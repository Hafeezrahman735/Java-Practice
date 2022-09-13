public class VideoRecording extends Recording{

//Attribute	
private final double framerate;	
	
//Constructors 	
public VideoRecording() {
	super();
	framerate=0.0;
}	
	
public VideoRecording(String artist, String recordingName, int durationInSeconds, double framerate) {
	if (artist != null && recordingName != null && durationInSeconds > 0 && framerate > 0.0){
		this.artist = artist;
		this.recordingName = recordingName;
		this.durationInSeconds = durationInSeconds;
		this.framerate = framerate;
	} else {
		this.artist = "Unknown";
		this.recordingName = "Unknown";
		this.durationInSeconds = 0;
		this.framerate = 0.0;
	}
}
	
//Getter	
public double getFramerate() {
  return this.framerate;
}		
	
//To String 	
@Override
public String toString(){
	return super.toString() + " [VIDEO | framerate: " + this.framerate + " fps]";
}

}
	
