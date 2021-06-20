package animals;

public class Cow extends Herbivore implements Run, Voice {
    private String name = "Корова";

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name + " бежит");
    }

    @Override
    public String voice() {
        return name + " говорит Му";
    }
}
