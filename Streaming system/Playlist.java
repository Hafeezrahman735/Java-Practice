import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Playlist extends Recording implements Playable,Serializable{
	
	ArrayList<Recording> recordingList = new ArrayList<Recording>();
	private String name;
	private int numberOfRecordings = recordingList.size();
	int durationInSeconds = 0;
	int sort=0;
	//private final int MAX_PLAYLIST_SIZE; // need to be constant
	//ArrayList<Recording> recordingList = new ArrayList<Recording>();
	//private Recording [] recordingList;
	
	// Non-parametrized constructor
	Playlist(){
		this.name = "Unknown";
		//this.MAX_PLAYLIST_SIZE = 5;
		//this.recordingList = new Recording [this.MAX_PLAYLIST_SIZE];
	}
	
	// Parametrized constructor
	Playlist(String name){
		if (name != null){
			this.name = name;
			//this.MAX_PLAYLIST_SIZE = MAX_PLAYLIST_SIZE;
			//this.recordingList = new Recording [this.MAX_PLAYLIST_SIZE];
		} else {
			this.name = "Unknown";
		//	this.MAX_PLAYLIST_SIZE = 5;
		//	this.recordingList = new Recording [this.MAX_PLAYLIST_SIZE];
		}			
	}
	
	public Playlist(String arist,String recordnam,int time) {
		 super(arist,recordnam,time);
	 }
	
	// Setters
	public void setName(String name){
		if (name != null){
			this.name = name;
		}
	}
	
	// Getters
	public int getNumberOfRecordings(){
		numberOfRecordings =recordingList.size();
		return numberOfRecordings;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getDuration(){
		return this.durationInSeconds;
	}
	
	public boolean dontequal(Recording pervious,Recording another) {
		
		if((pervious.getartist().equals(another.getartist()))  &&(pervious.getName().equals(another.getName()))) {
			return true;
		}
		return false;
	}
	//add() method
	public boolean add(Recording newRecording){
		if (newRecording != null){
			for (int x = 0; x < recordingList.size(); x++) {
				if(this.dontequal(recordingList.get(x),newRecording)) {
					recordingList.add(newRecording);
					numberOfRecordings = recordingList.size();
					//this.recordingList[numberOfRecordings] = newRecording;
				//	this.numberOfRecordings++;
					this.durationInSeconds = this.durationInSeconds + newRecording.getDuration();
					return true;
				}
			}
		}
			return false;
	}	
	
	public boolean addfile(ArrayList<Recording> PerviousPlaylist) {
		if (PerviousPlaylist != null){
			for (int x = 0; x < PerviousPlaylist.size(); x++) {
				if(this.dontequal(recordingList.get(x),PerviousPlaylist.get(x))) {
					recordingList.add(PerviousPlaylist.get(x));
					numberOfRecordings = recordingList.size();
					//this.recordingList[numberOfRecordings] = newRecording;
					//	this.numberOfRecordings++;
					this.durationInSeconds = this.durationInSeconds + PerviousPlaylist.get(x).getDuration();
					return true;
				} 
			}
		}
			return false;
			
	}
	
	public boolean add(VideoRecording video) {
		if (video != null){
			for (int x = 0; x < recordingList.size(); x++) {
				if(this.dontequal(recordingList.get(x),video)) {
					recordingList.add(video);
					numberOfRecordings = recordingList.size();
					//this.recordingList[numberOfRecordings] = newRecording;
					//	this.numberOfRecordings++;
					this.durationInSeconds = this.durationInSeconds + video.getDuration();
					return true;
				} 
			}
		}
			return false;
	}
	
	public boolean add(AudioRecording audio) {
		if (audio != null){
			for (int x = 0; x < recordingList.size(); x++) {
				if(this.dontequal(recordingList.get(x),audio)) {
				
					recordingList.add(audio);
					numberOfRecordings = recordingList.size();
					//this.recordingList[numberOfRecordings] = newRecording;
					//	this.numberOfRecordings++;
					this.durationInSeconds = this.durationInSeconds + audio.getDuration();
					return true;
				} 
			}
		}
			return false;
	}
	
	// play method
	public void play(){
		if (this.numberOfRecordings > 0) {
			for (int index = 0; index < this.numberOfRecordings; index++){
				recordingList.get(index).play();
				sort++;
			}
			System.out.println();
		} else {
			System.out.println("ERROR: Empty playlist.");
		}
	}
	
	public void play(int index) {
		recordingList.get(index).play();
	}
	
	public void play(String name) {
		for (Recording element : recordingList){
	         if (element.getName().equals(name)){
	               element.play();
	         }
	      }
	}
	
	public void playAll() {
		 for (Recording num : recordingList) { 		      
	           num.play(); 		
	      }
	}
	
	// shuffle method
	public void shuffle(){
		if (this.numberOfRecordings > 0 && numberOfRecordings > 0) {
			int recordingsPlayedCounter = 0;
			
			Random rand = new Random();
			
			while (recordingsPlayedCounter < numberOfRecordings){
				recordingList.get(rand.nextInt(this.numberOfRecordings)).play();
				recordingsPlayedCounter++;
			}
			System.out.println();
		} else {
			System.out.println("ERROR: Empty playlist.");
		}
	}
	
	public void remove(int index ) {
		recordingList.remove(index);
	}
	
	public void remove(String recordingname) {
		recordingList.remove(name);
	}
	
	public void load(String fileName){
		if (fileName != null){
			try {
				File playlistFile = new File(fileName);
				
				Scanner fileScanner = new Scanner(playlistFile);
				
				System.out.println("Processing playlist file " + playlistFile + ":");
				
				while (fileScanner.hasNextLine()){
					String line = fileScanner.nextLine();
					
					if (line != null){
						String [] lineAsArray = line.split(",");
					
						if (lineAsArray != null && lineAsArray.length == 5) {
							if (lineAsArray[0].equals("A") || lineAsArray[0].equals("V")) {
								String name = lineAsArray[1];
								String artist = lineAsArray[2];
								try {
									int durationInSeconds = Integer.parseInt(lineAsArray[3]);
									double rate = Double.parseDouble(lineAsArray[4]);
									
									if (lineAsArray[0].equals("A")){	
										AudioRecording newRecording = new AudioRecording(artist, name, durationInSeconds, rate);
										for (int x = 0; x < recordingList.size(); x++) {
											if(this.dontequal(recordingList.get(x),newRecording)) {
											this.add(newRecording);
											}
										}
									}
									if (lineAsArray[0].equals("V")){
										VideoRecording newRecording = new VideoRecording(artist, name, durationInSeconds, rate);
										for (int x = 0; x < recordingList.size(); x++) {
											if(this.dontequal(recordingList.get(x),newRecording)) {
												this.add(newRecording);
											}
										}
									}
																
								} catch (NumberFormatException nfe){
									System.out.println("ERROR: Number format exception. Recording rejected (" + line + ").");
								}
							} else {
								System.out.println("ERROR: Unknown recording type data (" + line + ").");
							}
							
						} else {
							System.out.println("ERROR: Inconsistent or no data read (" + line + ").");
						}
					} else {
						System.out.println("ERROR: Empty line read from a file");
					}
				}
				fileScanner.close();
			} catch (FileNotFoundException fnfe) {
				System.out.println("ERROR: File " +fileName + " not found!");
			}
		} else {
			System.out.println("ERROR: No file name provided.");
		}
	}
	
	public void savefile() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		   String filename = name+ "_PLAYLIST_" + dtf.format(now) + ".csv";
		try {
		FileOutputStream fos = new FileOutputStream(name+ "USERNAME" + dtf.format(now), true);
		ObjectOutputStream dos = new ObjectOutputStream(fos);
		
		 for (Recording num : recordingList) { 		      
			 dos.writeObject(num);
	      }
		
		 dos.close();
		
		}catch (FileNotFoundException e){
			System.out.println("No file!");
		}catch (IOException ex  ) {
			System.out.println("No file!");
		}
			
		//}
		
	}
	
	public void display() {
		System.out.println(recordingList.toString());
	}
	
	
	
	// toString method
	public String toString(){
		String returnString = "Playlist: " + this.name + " [" + ((int) Math.floor(this.durationInSeconds/60)) + "m" + (this.durationInSeconds % 60) + "s]:\n";
		if (this.numberOfRecordings > 0) {
			for (int index = 0; index < this.numberOfRecordings; index++){
				returnString = returnString + recordingList.get(index).toString() + "\n";
			}
		} 
		return returnString;
	}
}
