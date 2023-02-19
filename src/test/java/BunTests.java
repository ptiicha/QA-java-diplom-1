import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {
    private final String bunName;
    private final String expectedBunName;
    private final float bunPrice;
    private final float expectedBunPrice;

    public BunTests(String bunName, float bunPrice, String expectedBunName, float expectedBunPrice) {
        this.bunName = bunName;
        this.expectedBunName = expectedBunName;
        this.bunPrice = bunPrice;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters( name = "{index}: Bun({0}) price{1}" )
    public static Object[][] getBunData() {
        return new Object[][] {
                {" ", 0, " ", 0},
                {"Комета", 150.3F, "Комета", 150.3F},
                {"Булка Джей Ло", 15000F, "Булка Джей Ло", 15000F}
        };
    }

    @Test
    public void checkCreateBunWithNameAndPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(expectedBunName,bun.getName());
        assertEquals(bun.getPrice(), expectedBunPrice, 0.0);
    }
}