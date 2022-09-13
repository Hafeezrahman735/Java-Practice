public class AudioRecording extends Recording {

//Attribute	
private final double bitrate;
	
//Constructors 	
public AudioRecording() {
	super();
	bitrate=0.0;
}	
	
public AudioRecording(String artist, String recordingName, int durationInSeconds, double bitrate){
	if (artist != null && recordingName != null && durationInSeconds > 0 && bitrate > 0.0){
		this.artist = artist;
		this.recordingName = recordingName;
		this.durationInSeconds = durationInSeconds;
		this.bitrate = bitrate;
	} else {
		this.artist = "Unknown";
		this.recordingName = "Unknown";
		this.durationInSeconds = 0;
		this.bitrate = 0.0;
	}
}

//Getter	
public double getBitrate() {
    return this.bitrate;
}	
	
//To String 	
@Override
public String toString(){
	return super.toString() + " [AUDIO | bitrate: " + this.bitrate + " kbps]";
}	
}

