package modul_7.praktikum_2;

public class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public void draw(){
        System.out.println("Menggambar shape dengan warna: " + color);
    }

    public double calculateArea(){
        System.out.println("Menghitung luas shape umum");
        return 0;
    }

    public void displayInfo(){
        System.out.println("Shape - Warna: " + color);
    }
}
