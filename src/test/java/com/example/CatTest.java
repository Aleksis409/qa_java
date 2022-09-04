package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Mock
    Feline feline;

    @Test //тест метода getSound()
    public void getSoundIsNoReturnCatSoundString() {
        Cat cat = new Cat(feline);
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        assertEquals("Должено быть \"Мяу\"", expectedResult, actualResult);
    }

    @Test //тест метода getFood()
    public void getFoodIsNoReturnPredatorFoodList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedResult);
        List<String> actualResult = cat.getFood();
        assertEquals("Должна быть еда хищников  - \"Животные\", \"Птицы\", \"Рыба\"", expectedResult, actualResult);
    }

}
