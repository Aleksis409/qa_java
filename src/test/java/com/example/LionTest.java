package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Cubs cubs;

    @Mock
    Predator predator;

    @Test //тест метода doesHaveMane()
    public void doesHaveManeIsMaleReturnTrue() throws Exception {
        Lion lion = new Lion("Самец");
        boolean actualResult = lion.doesHaveMane();
        assertTrue("Лев-самец, должна быть грива", actualResult);
    }

    @Test //тест метода doesHaveMane()
    public void doesHaveManeIsFemaleReturnFalse() throws Exception {
        Lion lion = new Lion("Самка");
        boolean actualResult = lion.doesHaveMane();
        assertFalse("Это львица, гривы быть не должно", actualResult);
    }

    @Test //тест исключения в конструкторе класса Lion
    public void lionIsUnclearGenderReturnExceptionMessage()  {
        try {
            Lion lion = new Lion("Мужик");
        } catch (Exception thrown) {
            String actualResult = thrown.getMessage();
            String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals("Текст сообщения возникшего исключения не совпадает.", expectedResult, actualResult);
        }
    }

    @Test //тест метода getKittens()
    public void getKittensNoKittensReturnOneKittens() {
        Lion lion = new Lion(cubs);
        Mockito.when(cubs.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        int expectedResult = 1;
        assertEquals("Должен быть 1 котенок", expectedResult, actualResult);
    }

    @Test //тест метода getFood()
    public void getFoodIsNoReturnPredatorFoodList() throws Exception {
        Lion lion = new Lion(predator);
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Должна быть еда хищников  - \"Животные\", \"Птицы\", \"Рыба\"", expectedResult, actualResult);
    }

}
