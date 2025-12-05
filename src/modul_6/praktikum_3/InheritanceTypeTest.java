package modul_6.praktikum_3;

public class InheritanceTypeTest {
    public static void main(String[] args) {
        // Multilevel inheritance test
        Dog dog = new Dog("Buddy", "Brown", "Golden Retriever");
        dog.eat(); // Dari Animal, di-override di Dog
        dog.sleep(); // Dari Animal
        dog.giveBirth(); // Dari Mammal
        dog.bark(); // Dari Dog

        System.out.println();

        // Hierarchical inheritance test
        Cat cat = new Cat("Whiskers", "White", true);
        cat.eat(); // Dari Animal, di-override di Cat
        cat.sleep(); // Dari Animal
        cat.giveBirth(); // Dari Mammal
        cat.meow(); // Dari Cat

        System.out.println();

        // Polymorphism dengan hierarchical inheritance
        Animal[] animals = {new Dog("Max", "Black", "Labrador"),
                new Cat("Luna", "Gray", false)};

        for (Animal animal : animals) {
            animal.eat(); // Akan memanggil method yang sesuai dengan object sebenarnya
        }
    }
}
