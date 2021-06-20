package animals;

public class Pike extends Carnivorous implements Swim {
    private String name = "Щука";

    public String getName() {
        return name;
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает");

    }
}
