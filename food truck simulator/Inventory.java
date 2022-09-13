import java.util.Random;
public class Inventory{

	private double [] ingredients = new double[5];
	private String [] ingredientsName = new String[5];
	private double [] ingredientsCost = new double[5];
	private int shells = 200;
	private Order newOrder;
	Random rand = new Random();
	
	public Inventory(){
		
	
		ingredients[0] = 300;
		ingredients[1] = 300;
		ingredients[2] = 300;
		ingredients[3] = 300;
		ingredients[4] = 300;
		ingredientsName[0] = "chicken";
		ingredientsName[1] = "Beef";
		ingredientsName[2] = "Fish";
		ingredientsName[3] = "Tomato";
		ingredientsName[4] = "Cheese";
		
		
	}
	
	public boolean checkIfEnough(double [] ingredientsNeeded){
		
		for(int x =0; x < ingredientsNeeded.length;x++){
			if (ingredientsNeeded[x] != 0){
				if (ingredients[x] == 0){
					return true;
				}
			}
		}
			return false;
	}
	
	public void update(double [] array){
		
		//this.newOrder = newOrder;
		
		// I am assuming that there is enough ingredients to create the order
 
		// Check if the Order reference is not null (sanity check)
		shells--;
		
		//if (newOrder != null){
			
			// I am assuming you have a method getRecipe in your Order class and it returns a 1D array of doubles of the same size as the inventory array
			double [] newOrderRecipe = array;
			
			double rangeMin = .9;
			double rangeMax = 1.1;
			double range;
			
		for(int x = 0; x < array.length; x++){
			range = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
			array[x] = array[x] * range;
		}
			
			// Another sanity check (a bit too much, but I don't know what is in yourInventory and Order classes
			//if (newOrderRecipe != null && this.ingredients != null){
				// and another one (check if both arrays are of the same length
				if (newOrderRecipe.length == this.ingredients.length){
					for (int i = 0; i < newOrderRecipe.length; i++){
					// Remove from inventory what is needed for the new order
						this.ingredients[i] = this.ingredients[i] - newOrderRecipe[i];
						
					}
				//}
			//}
		}
	}
	
	public void showSummary(){
		
		for (int x = 0; x< ingredients.length;x++)
			System.out.println(ingredientsName[x] + " " + ingredients[x]);
		
	}
	


















}