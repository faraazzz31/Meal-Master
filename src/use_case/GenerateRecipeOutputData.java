package use_case;

import api.edamam.GenerateRecipeAPIData;

public class GenerateRecipeOutputData {
    private final String label;
    private final int calories;
    private final String[] ingredients;
    private final String recipeUrl;

    public GenerateRecipeOutputData(String label, int calories, String[] ingredients, String recipeUrl) {
        this.label = label;
        this.calories = calories;
        this.ingredients = ingredients;
        this.recipeUrl = recipeUrl;
    }

    public GenerateRecipeOutputData(GenerateRecipeAPIData generateRecipeAPIData) {
        this.label = generateRecipeAPIData.getLabel();
        this.calories = generateRecipeAPIData.getCalories();
        this.ingredients = generateRecipeAPIData.getIngredients();
        this.recipeUrl = generateRecipeAPIData.getRecipeUrl();
    }

    public String getLabel() {
        return label;
    }

    public int getCalories() {
        return calories;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String getRecipeUrl() {
        return recipeUrl;
    }
}
