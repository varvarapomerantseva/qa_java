import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getFamilyReturnsFeline() {
        String expectedReturn = "Кошачьи";
        String actualReturn = feline.getFamily();

        assertEquals("Must return Feline", expectedReturn, actualReturn);

    }

    @Test
    public void getKittensReturnCorrectMethod() {
        int expectedReturn = 1;
        int actualReturn = feline.getKittens();
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void getKittensReturnKittensCount() {
        int expectedReturn = 3;
        int actualReturn = feline.getKittens(3);
        assertEquals("Must return kittensCount", expectedReturn, actualReturn);
    }

    @Test
    public void eatMeatShouldReturnListObject() throws Exception {
        List<String> objectsList = List.of("string object 1", "string object 2", "string object 3");
        Mockito.doReturn(objectsList).when(feline).getFood(Mockito.anyString());
        assertEquals(objectsList, feline.eatMeat());
    }
    // Spy помогает сделать метод eatMeat изолированным от getFood, таким образом независимо от того, что будет передано или «сломано» в getFood, тест будет провален только если будет что-то сломано в самом методе eatMeat, который мы проверяем. Mock возвращает дефолтные значения, а нам нужно чтобы метод отработал так как прописано в классе.

}