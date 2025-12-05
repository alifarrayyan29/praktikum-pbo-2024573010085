package modul_7.praktikum_1;

public class OverLoadingTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Hasil: " + calc.add(5, 10));
        System.out.println();

        System.out.println("Hasil: " + calc.add(5, 10, 15));
        System.out.println();

        System.out.println("Hasil: " + calc.add(3.5, 2.7));
        System.out.println();

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Hasil: " + calc.add(numbers));
        System.out.println();

        System.out.println("Hasil: " + calc.add("Hello", "World"));
        System.out.println();

        System.out.println("Automatic Type Promotion: ");
        System.out.println("Hasil: " + calc.add(5, 3.5));
    }
}
