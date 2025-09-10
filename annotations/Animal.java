package annotations;

public class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound(); // Outputs: Woof! Woof!
    }
}