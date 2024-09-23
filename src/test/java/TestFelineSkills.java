import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestFelineSkills {

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        feline = new Feline();
    }
    @Mock
    private Animal animal;

    private Feline feline;
    private List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void TestFelineEatMeat() throws Exception {
        when(animal.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood,actualFood);
    }

    @Test
    public void testFelineGetFamily(){
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineGetKittens(){
        assertEquals(1,feline.getKittens());
    }

    @Test
    public void testFelineGetKittensWithParam(){
        assertEquals(1,feline.getKittens(1));
    }
}
