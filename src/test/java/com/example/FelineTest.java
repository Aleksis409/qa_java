package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class FelineTest {

    @Mock
    Feline feline;

    private final int numberOfKittens; //фактическое кол-во котят
    private final int expectedNumberOfKittens; //ожидаемое кол-во котят

    public FelineTest(int numberOfKittens, int expectedNumberOfKittens) {
        this.numberOfKittens = numberOfKittens;
        this.expectedNumberOfKittens = expectedNumberOfKittens;
    }

    @Parameterized.Parameters // данные для теста метода getKittens(int)
    public static Object[] getNumberOfKittens() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {10, 10},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test //тест метода getKittens(int)
    public void getKittensInNumberOfKittensReturnNumberOfKittens() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(numberOfKittens);
        assertEquals("Количество котят не соответствует!", expectedNumberOfKittens, actualResult);
    }

    @Test //тест метода getKittens()
    public void  getKittensIsNoKittensReturnOneKittens() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens();
        int expectedResult = 1;
        assertEquals("Должен быть 1 котенок", expectedResult, actualResult);
    }

    @Test //тест метода getFamily()
    public void getFamilyIsNoReturnStringFeline() {
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        String expectedResult = "Кошачьи";
        assertEquals("Должно быть \"Кошачьи\" ", expectedResult, actualResult);
    }

    @Test //тест метода eatMeat()
    public void eatMeatIsNoReturnListStringPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        Feline felineSpy = Mockito.spy(feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = felineSpy.eatMeat();
        assertEquals("Должна быть еда хищников  - \"Животные\", \"Птицы\", \"Рыба\"", expectedResult, actualResult);
    }

}
