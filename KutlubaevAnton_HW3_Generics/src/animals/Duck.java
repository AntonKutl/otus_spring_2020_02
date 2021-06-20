package animals;

public class Duck extends Herbivore implements Fly, Swim, Voice {
    private String name = "Утка";

    public String getName() {
        return name;
    }

    @Override
    public void fly() {
        System.out.println(name + " летит");
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает");
    }

    @Override
    public String voice() {
        return name + " говорит кря";
    }
}
