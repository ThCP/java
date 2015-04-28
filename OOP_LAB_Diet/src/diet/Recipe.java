package diet;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	
	String name = new String();
	Map<NutritionalElement, Double> ingredients = new HashMap<>();
	double calories = 0.0;
	
	Food f = new Food();
	
	/**
	 * Recipe constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about ingredients. 
	 * 
	 * @param unique name of the recipe
	 * @param food object containing the information about ingredients
	 */
	public Recipe(String name, Food food){
		this.name = name;
		food.recipes.put(name, this);
		this.f = food;
	}
	
	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material defined with the {@code food}
	 * argument of the constructor.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 */
	public void addIngredient(String material, double quantity) {
		ingredients.put(f.getRawMaterial(material), quantity);
	}

	public String getName() {
		return this.name;
	}
	
	
	
	public double getCalories() {
		double calories = 0.0, total = 0.0;
		
		for (NutritionalElement e : f.rawMaterials()){
			if (ingredients.containsKey(e)){
				calories += e.getCalories()/100*ingredients.get(e);
				total += ingredients.get(e);
			}
		}
		
		return calories/total*100;
	}	

	public double getProteins() {
		double proteins = 0.0, total = 0.0;
		
		for (NutritionalElement e : f.rawMaterials()){
			if (ingredients.containsKey(e)){
				proteins += e.getProteins()/100*ingredients.get(e);
				total += ingredients.get(e);
			}
		}
		return proteins/total*100;
	}

	public double getCarbs() {
		double carbs = 0.0, total = 0.0;
		
		for (NutritionalElement e : f.rawMaterials()){
			if (ingredients.containsKey(e)){
				carbs += e.getCarbs()/100*ingredients.get(e);
				total += ingredients.get(e);
			}
		}
		return carbs/total*100;
	}

	public double getFat() {
		double fat = 0.0, total = 0.0;
		
		for (NutritionalElement e : f.rawMaterials()){
			if (ingredients.containsKey(e)){
				fat += e.getFat()/100*ingredients.get(e);
				total += ingredients.get(e);
			}
		}
		return fat/total*100;
	}

	public boolean per100g() {
		  // a recipe expressed nutritional values per 100g
	    return true;
	}
	
	public Map<NutritionalElement, Double> getIngredients() {
		  return ingredients;
	}
	
	@Override
	public boolean equals (Object o){
		System.out.println ("Equals entered");
		NutritionalElement  other = (NutritionalElement) o;
		return this.name.equals(other.getName());
	}

}

