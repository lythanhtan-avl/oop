import java.util.ArrayList;

abstract class Animal {
    protected String name;
    protected int age;
    protected String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public abstract String makeSound();
    public abstract String move();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Name: " + name + ", Age: " + age + ", Species: " + species;
    }
}

interface Swimmable {
    String swim();
}

class Mammal extends Animal {
    private boolean isDomestic;

    public Mammal(String name, int age, String species, boolean isDomestic) {
        super(name, age, species);
        this.isDomestic = isDomestic;
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }

    @Override
    public String move() {
        return "Walk";
    }
}

class Bird extends Animal {
    private double wingSpan;

    public Bird(String name, int age, String species, double wingSpan) {
        super(name, age, species);
        this.wingSpan = wingSpan;
    }

    @Override
    public String makeSound() {
        return "Chirp!";
    }

    @Override
    public String move() {
        return "Fly";
    }
}

class Reptile extends Animal {
    private boolean isVenomous;

    public Reptile(String name, int age, String species, boolean isVenomous) {
        super(name, age, species);
        this.isVenomous = isVenomous;
    }

    @Override
    public String makeSound() {
        return "Hiss!";
    }

    @Override
    public String move() {
        return "Crawl";
    }
}
class Whale extends Mammal implements Swimmable {
    public Whale(String name, int age, String species) {
        super(name, age, species, false);
    }

    @Override
    public String makeSound() {
        return "Whup!";
    }

    @Override
    public String move() {
        return "Swim";
    }

    @Override
    public String swim() {
        return "Swim in the ocean";
    }
}

class Zoo {
    private ArrayList<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.makeSound());
            System.out.println(animal.move());
            if (animal instanceof Swimmable) {
                System.out.println(((Swimmable) animal).swim());
            }
            System.out.println();
        }
    }
}
