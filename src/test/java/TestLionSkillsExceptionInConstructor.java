import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestLionSkillsExceptionInConstructor {
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Feline feline;

    private Lion lion;

    @Test
    public void testLionConstructException() throws Exception {
        try {
            lion = new Lion("Нечто", feline);
            fail("Expected an Exception to be thrown");
        } catch(Exception e) {
            // Если исключение выброшено, тест пройден
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }
}
