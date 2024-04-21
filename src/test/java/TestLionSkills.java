import com.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class TestLionSkills {

    public TestLionSkills(String sex, boolean mane){
        this.sex=sex;
        this.mane=mane;
    }

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }

    @Spy
    private Feline feline = new Feline();

    private final String sex;
    private final boolean mane;
    private Lion lion;
    private List<String> expextedFood = List.of("Животные", "Птицы", "Рыба");

    @Parameterized.Parameters
    public static Object[][] dataForTests() {
        return new Object[][] {
                { "Самец",true},
                { "Самка",false},
        };
    }

    @Test
    public void testLionGetKittens(){
        when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(1,actual);
    }

    @Test
    public void TestLionDoesHaveMane(){
        boolean actual = lion.doesHaveMane();
        assertEquals(actual,mane);
    }

    @Test
    public void TestLionGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(expextedFood);
        List<String> food = lion.getFood();
        assertEquals(expextedFood,food);
    }
}
