package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class AnimalTest {

    private final String typeOfAnimals; //тип животного
    private final List<String> typeOfAnimalFood; //вид пищи животного

    public AnimalTest(String typeOfAnimals, List<String> typeOfAnimalFood) {
        this.typeOfAnimals = typeOfAnimals;
        this.typeOfAnimalFood = typeOfAnimalFood;
    }

    @Parameterized.Parameters  //данные для теста метода getFood()
    public static Object[] getTypeOfAnimalFood() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test //тест метода getFood()
    public void getFoodIsTypeOfAnimalsReturnTypeOfAnimalFoodList() throws Exception {
        Animal animal = new Animal();
        List<String> actualResult = animal.getFood(typeOfAnimals);
        assertEquals("Вид пищи не соответствует для данного типа животного", typeOfAnimalFood, actualResult);
    }


    @Test //тест исключения в методе getFood()
    public void getFoodIsUnclearGenderReturnExceptionMessage()  {
        Animal animal = new Animal();
        try {
            animal.getFood("Вегетарианец");
        } catch (Exception thrown) {
            String actualResult = thrown.getMessage();
            String expectedResult = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            assertEquals("Текст сообщения возникшего исключения не совпадает.", expectedResult, actualResult);
        }
    }

    @Test //тест метода getFamily()
    public void getFamilyIsNoReturnListOfFamilies() {
        Animal animal = new Animal();
        String actualResult = animal.getFamily();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals("Должно быть - expectedResult", expectedResult, actualResult);
    }
}