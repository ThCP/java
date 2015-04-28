package diet;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Represents a complete menu.
 * It consist of packaged products and servings of recipes.
 *
 */
public class Menu implements NutritionalElement {
	
	String name = new String();
	Food f = new Food();
	Map<String, Double> recipes = new HashMap<>();
	Collection<NutritionalElement> products = new LinkedList<>();
	
	/**
	 * Menu constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about recipes and products 
	 * 
	 * @param nome unique name of the menu
	 * @param food object containing the information about products and recipes
	 */
	public Menu(String name, Food food){
		this.name = name;
		this.f = food;
	}
	
	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 */
	public void addRecipe(String recipe, double quantity) {
		recipes.put(recipe, quantity);
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 */
	public void addProduct(String product) {
		products.add(f.getProduct(product));
	}

	public String getName() {
		return this.name;
	}

	public double getCalories() {
		double calories = 0.0;
		
		for (NutritionalElement e : f.recipes()){
			if (recipes.containsKey(e.getName())){
				calories += e.getCalories()/100*recipes.get(e.getName());
			}
		}
		
		for (NutritionalElement p : f.products()){
			calories += p.getCalories();
		}
		
		return calories;
	}

	public double getProteins() {
		double proteins = 0.0;
		
		for (NutritionalElement e : f.recipes()){
			if (recipes.containsKey(e.getName())){
				proteins += e.getProteins()/100*recipes.get(e.getName());
			}
		}
		
		for (NutritionalElement p : f.products()){
			proteins += p.getProteins();
		}
		
		return proteins;	
	}

	public double getCarbs() {
		double carbs= 0.0;
		
		for (NutritionalElement e : f.recipes()){
			if (recipes.containsKey(e.getName())){
				carbs += e.getCarbs()/100*recipes.get(e.getName());
			}
		}
		
		for (NutritionalElement p : f.products()){
			carbs += p.getCarbs();
		}
		
		return carbs;
	}

	public double getFat() {
		double fat = 0.0;
		
		for (NutritionalElement e : f.recipes()){
			if (recipes.containsKey(e.getName())){
				fat += e.getFat()/100*recipes.get(e.getName());
			}
		}
		
		for (NutritionalElement p : f.products()){
			fat += p.getFat();
		}
		
		return fat;
	}

	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
