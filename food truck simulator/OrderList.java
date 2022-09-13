
public class OrderList {

//Attributes 
private Order[] orders = new Order [200];
private int [] menuItemsSold = new int [4];
private int totalOrdersPlaced; 
private double totalCost;
private double totalProfit;	
private double totalSales;

//Constructor
public OrderList() {

this.totalOrdersPlaced = 0;
this.totalCost = 0;
this.totalProfit = 0;
this.totalSales = 0;

}

//Method
public void add(Order newOrder) {
	totalOrdersPlaced = 0;
	for(int x = 0; x < orders.length;x++)
		orders[x] = newOrder;
	totalOrdersPlaced++;
	totalCost += newOrder.getCost();
	totalProfit += newOrder.getPrice();
}

//Getters	
public int getTotalOrdersPlaced() {
	return totalOrdersPlaced;
}

public double getTotalCost() {
	return totalCost;
}

public double getTotalProfit() {
	return totalProfit;
}
	
public double getTotalSales() {
	return totalSales;
}	
	

	
	
	
	
}
