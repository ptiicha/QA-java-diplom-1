import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Ingredient  ingredientThird;

    Burger burger = new Burger();

    @Test
    public void setBunInBurger(){
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void checkAddIngredients(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        assertEquals(burger.ingredients, List.of(ingredientFirst, ingredientSecond, ingredientThird));
    }

    @Test
    public void checkRemoveIngredients(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.removeIngredient(1);
        assertEquals(burger.ingredients, List.of(ingredientFirst, ingredientThird));
    }

    @Test
    public void checkMoveIngredients(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.moveIngredient(2, 0);
        assertEquals(burger.ingredients, List.of(ingredientThird, ingredientFirst, ingredientSecond));
    }

    @Test
    public void checkGetPrice(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(200F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(150F);
        Mockito.when(ingredientThird.getPrice()).thenReturn(550F);

        assertEquals(burger.getPrice(), 1100F, 0.0);
    }

    @Test
    public void checkGetReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);

        Mockito.when(bun.getName()).thenReturn("Булка Джей Ло");
        Mockito.when(bun.getPrice()).thenReturn(15000F);
        Mockito.when(ingredientFirst.getName()).thenReturn("1000 Islands");
        Mockito.when(ingredientSecond.getName()).thenReturn("Red onion");
        Mockito.when(ingredientThird.getName()).thenReturn("Horse meat");
        Mockito.when(ingredientFirst.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientSecond.getType()).thenReturn(FILLING);
        Mockito.when(ingredientThird.getType()).thenReturn(FILLING);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(200F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(150F);
        Mockito.when(ingredientThird.getPrice()).thenReturn(550F);

        String expectedReceipt = "(==== Булка Джей Ло ====)\n" +
                "= sauce 1000 Islands =\n" +
                "= filling Red onion =\n" +
                "= filling Horse meat =\n" +
                "(==== Булка Джей Ло ====)\n" +
                "\n" +
                "Price: 30900,000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
