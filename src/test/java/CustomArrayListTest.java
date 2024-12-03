
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class CustomArrayListTest {



    @Test
    public void addTest() {
       CustomArrayList<String> customArrayList = new CustomArrayList<>();
       customArrayList.add("Masha");
       customArrayList.add("Petya");
       customArrayList.add("Vasya");
       String result = customArrayList.get(0);
       assertEquals("Masha", result);
    }

    @Test
    public void addIndexElementTest() {
        int index = 0;
        String element = "Kolya";
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add(index, element);
        String result = customArrayList.get(0);
        assertEquals("Kolya", result);
    }

    @Test
    public void addAllTest() {
        List<String> familyName = new ArrayList<>();
        familyName.add("Sobyanin");
        familyName.add("Luzhkov");

        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Sergei");
        customArrayList.add("Yurii");
        customArrayList.addAll(familyName);
        String result = customArrayList.get(3);
        assertEquals("Luzhkov", result);
    }

    @Test
    public void clearTest(){
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Sergei");
        customArrayList.add("Yurii");
        customArrayList.add("Nikolay");
        customArrayList.clear();
        String result = customArrayList.get(2);
       // assertThrow();
    }

    @Test
    public void isEmptyTest(){
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    public void removeTest(){
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Chehov");
        customArrayList.add("Orlov");
        customArrayList.add("Polyakov");
        customArrayList.remove(1);
        String result = customArrayList.get(1);
        assertEquals("Polyakov", result);
    }

    @Test
    public void removeByObjectTest() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Chehov");
        customArrayList.add("Orlov");
        customArrayList.add("Polyakov");
        customArrayList.remove("Orlov");
        String result = customArrayList.get(1);
        assertEquals("Polyakov", result);
    }

    @Test
    public void sortTest(){
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(8);
        customArrayList.add(2);
        customArrayList.add(4);
        customArrayList.add(9);
        customArrayList.sort(Comparator.naturalOrder());
        String customResult = customArrayList.toString();

        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(4);
        sortedList.add(8);
        sortedList.add(9);
        String result = sortedList.toString();

        assertEquals(result, customResult);
    }

}
