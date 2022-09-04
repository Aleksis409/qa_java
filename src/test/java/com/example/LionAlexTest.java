package com.example;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class LionAlexTest {

    @Test //тест метода getFriends()
    public void getFriendsIsNoReturnListOfFriends() throws Exception {
        LionAlex lionAlex = new LionAlex();
        List<String> actualResult = lionAlex.getFriends();
        List<String> expectedResult = List.of("Марти", "Глория", "Мелман");
        assertEquals("Должен быть список друзей  - \"Марти\", \"Глория\", \"Мелман\"", expectedResult, actualResult);
    }

    @Test //тест метода getPlaceOfLiving()
    public void getPlaceOfLivingIsNoReturnPlaceOfLivingString() throws Exception {
        LionAlex lionAlex = new LionAlex();
        String actualResult = lionAlex.getPlaceOfLiving();
        String expectedResult = "Нью-Йоркский зоопарк";
        assertEquals("Должно быть место жительства - \"Нью-Йоркский зоопарк\"", expectedResult, actualResult);
    }

    @Test //тест метода getKittens()
    public void getKittensIsNoReturnZeroKittens() throws Exception {
        LionAlex lionAlex = new LionAlex();
        int actualResult = lionAlex.getKittens();
        int expectedResult = 0;
        assertEquals("Должно быть 0 котят", expectedResult, actualResult);
    }
}