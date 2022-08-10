import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundCorrectMethod() {
        Cat cat = new Cat(feline);
        String expectedReturn = "Мяу";
        String actualReturn = cat.getSound();
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void getFoodShouldReturnCorrectListObject() throws Exception {
        Cat cat = new Cat(feline);

        List<String> objectsList = List.of("string object 1", "string object 2", "string object 3");
        Mockito.when(feline.eatMeat()).thenReturn(objectsList);
        List<String> actual = cat.getFood();
        Assert.assertEquals(objectsList, actual);
    }
}
