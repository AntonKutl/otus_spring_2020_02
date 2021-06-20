package animals;

public class Sheep extends Herbivore implements Run, Voice {
    private String name = "Овца";

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name + " бежит");
    }

    @Override
    public String voice() {
        return name + " говорит Беее";
    }

}
