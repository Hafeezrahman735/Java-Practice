import java.util.Random;
public class Order {

//Attributes 
	private static int orderIDCount=0;
	private int orderID;
	private int menuID;
	private double cost; 
	private double [] costarray;
	private double price;
	private double[] ingredients;
	Random rand = new Random();

//Constructor

	public Order(int menuID, double[] ingredients) {
		this.menuID = menuID;
		costarray = new double []{.56,.98,.45,.81,.69};
		this.ingredients = ingredients;
		getIngredients();
		itemcost();
		price = cost * 1.2;
		this.ingredients = ingredients;
		orderIDCount++;
	
	}
			
	public double [] getIngredients(){
		double ready [] = new double[ingredients.length];
		for(int d =0;d< ingredients.length;d++)
			ready[d] = ingredients[d];
		double rangeMin = .9;
		double rangeMax = 1.1;
		double range;
			
		for(int x = 0; x < ready.length; x++){
			range = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
			ready[x] = ready[x] * range;
		}
	
		return (ready);
		
	}
	public double itemcost(){
		cost =0;
		if (ingredients.length == costarray.length){
			for (int x =  0;x < costarray.length;x++){
				cost = cost + (ingredients[x] * costarray[x]);
			}
			cost = cost + .25;
		}
		return cost;
	}
		
//Getter
	public int getOrderID() {
		return orderID;
	}

	public int getMenuID() {
		return menuID;
	}

	public double getCost() {
		return cost;
	}
	
	public double getPrice() {
		return price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
