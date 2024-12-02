import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CustomArrayList<String> customArrayList = new CustomArrayList<String>();
        customArrayList.add("Masha");
        customArrayList.add("Petya");
        customArrayList.add("Dasha");
        customArrayList.add("Nadya");
        customArrayList.add("Polina");
        customArrayList.add("Serezha");
        customArrayList.add("Vanya");
        customArrayList.add("Dima");
        customArrayList.add("Zhenya");
        customArrayList.add("Igor");
        customArrayList.add("Vsevolod");
        System.out.println(customArrayList);
    }
}
