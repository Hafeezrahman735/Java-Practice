import java.util.ArrayList;
import java.util.Scanner;

public class StreamingSystem extends User{
	
	
	String username;
	Scanner scan = new Scanner(System.in);
	//public String user;
	int uniqueId;
	
	
	StreamingSystem() {
		
	}
	
	public void run() {
		System.out.println( 1 + " " + " Add user  ");
		System.out.println( 2 + " " + " Remove User  ");
		System.out.println( 3 + " " + " List ALl user ");
		System.out.println( 4 + " " + " User Settings ");
		System.out.println( 5 + " " + " Exit ");
		System.out.println("What would you like to do?");
		int x = scan.nextInt();
		while (x > 4 || x < 0){
			System.out.println("What would you like to do?");
			x = scan.nextInt();
		}
		
		if(x == 1) {
			System.out.println("enter a Username to Add");
			username = scan.next();
			Adduser(username);
		}
		else if (x==2) {
			System.out.println("Remove User");
			System.out.println( 1 + " " + " Remove User by Id  ");
			System.out.println( 2 + " " + " Remove User by username ");
			int b = scan.nextInt();
			while (b > 2 || b < 1){
				System.out.println("What would you like to do?");
				b = scan.nextInt();
			}
			if (b == 1) {
				System.out.println("Enter Id number");
				int id = scan.nextInt();
				Id.remove(Integer.valueOf(id));
			}
			else {
				System.out.println("enter the User to remove");
				String removename = scan.next();
				for (int counter = 0; counter < Id.size(); counter++) { 		      
			          if(removename == user.get(counter)) {
			        	  Id.remove(counter);
			          }
			      }   		
				
			}
			
			
		}
		else if (x==3) {
			System.out.println(user);
		}
		else if (x==4) {
			System.out.println( 1 + " " + " Add Recording ");
			System.out.println( 2 + " " + " Add Playlist from file");
			System.out.println( 3 + " " + " Add Playlist from another user ");
			System.out.println( 4 + " " + " Remove Recording ");
			System.out.println( 5 + " " + " Play indivdual recording");
			System.out.println( 6 + " " + " play Entire Playlist ");
			System.out.println( 7 + " " + " Shuffle Playlist");
			System.out.println( 8 + " " + " Save Playlist");
			System.out.println( 9 + " " + " Display Playlist stats ");
			System.out.println( 10 + " " + " Exit ");
			
			int h = scan.nextInt();
			while (h > 11 || h < 0){
				System.out.println("What would you like to do?");
				h = scan.nextInt();
			}
			
			if (h == 1) {
				
				System.out.println("Enter Artist name ");
				String artist = scan.next();
				System.out.println("Enter Recording name ");
				String recordname = scan.next();
				System.out.println("Enter the duration time ");
				int time = scan.nextInt();
				
				Playlist reco = new Playlist(artist,recordname,time);
				
				User name = new User(username,reco);
			}
			else if (h==2) {
				System.out.println("Enter a playlist file");
				
				String file = scan.next();
				
				load(file);
			}
			
			else if (h==3) {
				System.out.println("enter user ID of another user");
				
				int userid = scan.nextInt();
				
				addfile(add(userid));
	        }
			else if (h==4) {
				System.out.println( 1 + " " + " remove recording from index ");
				System.out.println( 2 + " " + " remove recording from name");
				int j = scan.nextInt();
				while (j > 3 || j < 0){
					System.out.println("What would you like to do?");
					h = scan.nextInt();
				}
				if (j == 1) {
					System.out.println("which index ");
					int y = scan.nextInt();
					remove(y);
				}
				else {
					System.out.println("enter name ");
					String removename = scan.next();
					remove(removename);
				}
			}
			else if (h==5) {
				System.out.println( 1 + " " + " play recording from index ");
				System.out.println( 2 + " " + " play recording from name");
				int t = scan.nextInt();
				while (t > 3 || t < 0){
					System.out.println("What would you like to do?");
					t = scan.nextInt();
				}
				if (t==1 ) {
					System.out.println("Enter playing index");
					int ind = scan.nextInt();
					play(ind);
				}
				else {
					System.out.println("enter plaing name");
					String playingname = scan.next();
					play(playingname);
				}
			}
			else if (h==6) {
				playAll();
			}
			else if(h==7) {
				shuffle();
			}
			else if (h==8) {
				savefile();
			}
			else if (h==9){
				display();
			
			}
			else {
				System.out.println("Run Quit");
			}	
		}
		else {
			System.out.println("good bye");
		}
		run();
		
		
	}
	
	public void addUser(int UserId) {
		
	}
	
}
