import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterTest {
    Feline feline = new Feline();
    private final String sex;
    private final boolean expected;

    @Parameterized.Parameters
    public static Object[][] getGender() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    public LionParameterTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Test
    public void lionParameterTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }
}

