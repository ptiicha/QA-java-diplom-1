import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientsTests {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final String expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientsTests(IngredientType type, String name, float price,
                            String expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.expectedType = expectedType;
        this.name = name;
        this.expectedName = expectedName;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Tartar", 100F, "SAUCE", "Tartar", 100F},
                {IngredientType.SAUCE, "1000 Islands", 200F, "SAUCE", "1000 Islands",  200F},
                {IngredientType.SAUCE, "", 0, "SAUCE", "", 0},
                {IngredientType.FILLING, "Red onion", 150.55F, "FILLING", "Red onion", 150F},
                {IngredientType.FILLING, "Horse meat", 550.99F, "FILLING", "Horse meat", 550F},
                {IngredientType.FILLING, "", 300.01F, "FILLING", "", 300.01F},
        };
    }

    @Test
    public void checkBeCreateIngredients() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getType(), IngredientType.valueOf(expectedType));
        assertEquals(ingredient.getName(), expectedName);
        assertEquals(ingredient.getPrice(), expectedPrice, 0.0);
    }
}
