import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private String animalKind;
    private List<String> animalListFood;
    private String message = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

    public AnimalParameterizedTest(String animalKind, List<String> animalListFood){
        this.animalKind = animalKind;
        this.animalListFood = animalListFood;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Иной вид", List.of()}
        };
    }

    @Test
    public void getFoodTest()  {
        try {
            Animal animal = new Animal();
            assertEquals(animalListFood, animal.getFood(animalKind));

        } catch (Exception exception){
            assertEquals(message, exception.getMessage());
        }

    }

}
