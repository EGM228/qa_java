import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TestLionSkillsFood {
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", feline);
    }

    @Spy
    private Feline feline = new Feline();

    private Lion lion;
    private List<String> expextedFood = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void testLionGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(expextedFood);
        List<String> food = lion.getFood();
        assertEquals(expextedFood,food);
    }
}
