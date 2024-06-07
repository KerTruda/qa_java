import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;
    private boolean hasMane;
    private Feline feline;
    private String message = "Используйте допустимые значения пола животного - самей или самка";

    public LionParameterizedTest(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Оно", false}
        };
    }

    @Before
    public void setup(){
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void doesHaveManeTest(){
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.doesHaveMane());

            } catch (Exception exception){
                assertEquals(message, exception.getMessage());
            }

    }

}
