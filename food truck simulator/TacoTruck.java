import java.util.Scanner;
import java.util.Random;
public class TacoTruck {
	
//Attributes 
private String name = "Taco Drive";
private Inventory inventory;
private Order oneOrder;
private OrderList orders; 
private double[][] recipes;
private String[] menuItems;	
private int num1=0;
private int num2=0;
private int num3=0;
private int num4=0;
private int shells = 200;

Scanner scan = new Scanner(System.in);
Random rand = new Random();

//Constructor
public TacoTruck() {
this.inventory =  new Inventory();
this.orders = new OrderList();
this.recipes = new double [][]{{0.0, 2.0, 0.0, 1.0, 1.0},{2.0, 0.0, 0.0, 1.0, 1.0},{0.0, 0.0, 2.0, 1.0, 1.0},{1.0, 1.0, 1.0, 1.0, 1.0}};

//this.menuItems = 

}
	
//Getter
private double[] getRecipe(int menuItemID) {
	int menuitem = menuItemID;
	double [] newRecipe = new double[5];
	if (menuitem ==1){
		for (int x = 0; x < recipes[0].length; x++)
			newRecipe[x] = recipes[0][x];
	} else if (menuitem == 2){
		for (int x = 0; x <  recipes[1].length; x++)
			newRecipe[x] = recipes[1][x];
	}else if (menuitem == 3){
		for (int x = 0; x <  recipes[2].length; x++)
			newRecipe[x] = recipes[2][x];
	}else if (menuitem == 4){
		for (int x = 0; x <  recipes[3].length; x++)
			newRecipe[x] = recipes[3][x];
	}
	return newRecipe;

}


public String getMenuItemName(int menuItemID) {
	int menuitem = menuItemID;
	String orderName = " ";
	if (menuitem == 1){
		orderName = "Beef Taco";
	}else if (menuitem == 2){
		orderName = "Chicken Taco";
	}else if (menuitem == 3){
		orderName = "Fish Taco";
	}else if	(menuitem == 4){
		orderName = "Everything Taco";
	}
	return orderName;
}
	
//Methods	
	/*
public void	setup() {
	
}
*/
public void run() {
	
		System.out.println("Welcome to Taco Drive!");
		System.out.println( 1 + " " + " Manual order ");
		System.out.println( 2 + " " + " Simulated ordering ");
		System.out.println( 3 + " " + " Sales summary ");
		System.out.println( 4 + " " + " Quit ");

		System.out.println("What would you like to do?");
		int x = scan.nextInt();
		while (x > 4 || x < 0){
			System.out.println("What would you like to do?");
			x = scan.nextInt();
		}
		if (x==1){
			manual();
		}
		else if(x==2) {
			System.out.println("Run Simulated ordering");
			simulate();
		}
		else if(x==3) {
			System.out.println("Run Sales Summary");
			showSalesSummary();
		}
		else  {
			System.out.println("Run Quit");
		}
		run();
		
}




private void manual() {
	System.out.println("what Menu item do you wants");
			
	System.out.println("[1] [Beef Taco] ([Beef], [cheese], [tomato])");
	System.out.println("[2] [Chicken Taco] ([Chicken], [cheese], [tomato])");
	System.out.println("[3] [Fish Taco] ([Fish], [cheese], [tomato])");
	System.out.println("[4] [Everything Taco] ([Beef], [Fish], [Chicken], [cheese], [tomato])");
	System.out.println("What would you like");
	int menu = scan.nextInt();
	while (menu < 0 || menu > 4){
		menu = scan.nextInt();
		System.out.println("what Menu item do you wants");
	}
	order(menu);
	
	
}

private void simulate() {
	Random rand = new Random();	
	int integer = rand.nextInt(4)+1;
	
	if (integer==1){
	System.out.println("Menu item 1");
	
	order(1);
	}
	else if (integer==2){
	System.out.println("Menu item 2");

	order(2);
	}
	else if (integer==3){
	System.out.println("Menu item 3");
	
	order(3);
	}
	else if (integer==4){
	System.out.println("Menu item 4");
	
	order(4);
	}
	
	
	
	
	
	//System.out.println("Order#" + Order.getOrderID() + "for" +  getMenuItemName(1) + "successfully placed");
	//System.out.println("Order cannot be fulfilled. Not enough ingredients");	

}

private void order(int menuItemID) {
	
	 double [] item = getRecipe(menuItemID);
	 boolean x = inventory.checkIfEnough(item);
	if (x){
		System.out.println("Order cannot be fulfilled. Not enough ingredients");	
	}
	oneOrder = new Order(menuItemID,item);
	inventory.update(item);
	orders.add(oneOrder);
	System.out.println(getMenuItemName(menuItemID));
	double totalcost =  oneOrder.getPrice();
	System.out.println("The Price is $" + totalcost);
	shells--;
	if (menuItemID == 1){
		num1++;
	}else if (menuItemID == 2){
		num2++;
	}else if (menuItemID == 3){
		num3++;
	}else if (menuItemID == 4){
		num4++;
	}

}

public void showSalesSummary() {
	
	
	oneOrder.getCost();
	orders.getTotalCost();
	System.out.println("Sales summary:");
	System.out.println("Total number of tacos sold:"  );
	System.out.println("Total number of" + " " + getMenuItemName(1) + " " + "sold:" + " " + num1);
	System.out.println("Total number of" + " " + getMenuItemName(2) + " " + "sold:" + " " + num2);
	System.out.println("Total number of" + " " + getMenuItemName(3) + " " + "sold:" + " " + num3);
	System.out.println("Total number of" + " " + getMenuItemName(4) + " " + "sold:" + " " + num4);
	inventory.showSummary();
	System.out.println("Total cost:" + orders.getTotalCost());
	System.out.println("Total sales:" + orders.getTotalProfit());
	System.out.println("Total profit:" + (orders.getTotalProfit()-orders.getTotalCost()));
	System.out.println("Total Shells left :" + shells);
	
}




}