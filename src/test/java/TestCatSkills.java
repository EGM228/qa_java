import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestCatSkills {
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    @Mock
    private Feline feline;

    private Cat cat;
    private final String expectedSound = "Мяу";

    @Test
    public void testCatGetSound(){
        assertEquals(expectedSound, cat.getSound());
    }

    @Test
    public void testCatGetFood() throws Exception {
        List<String> food = cat.getFood();
        verify(feline).eatMeat();
        assertEquals(List.of(), food);
    }
}
