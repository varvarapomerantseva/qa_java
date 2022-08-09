import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedValue = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualValue = lion.getKittens();
        assertEquals("Value incorrect", expectedValue, actualValue);
    }

    @Test(expected = Exception.class)
    public void lionGenderException() throws Exception {
        Lion lion = new Lion(" ", feline);
    }

    @Test
    public void getFoodReturnFoodForLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> objectsList = List.of("string object 1", "string object 2", "string object 3");
        Mockito.when(feline.getFood("Хищник")).thenReturn(objectsList);
        assertEquals(objectsList, lion.getFood());
    }
}

