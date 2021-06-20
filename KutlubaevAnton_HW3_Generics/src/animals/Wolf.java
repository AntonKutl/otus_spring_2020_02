package animals;

public class Wolf extends Carnivorous implements Run, Voice {
    private String name = "Волк";

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name + " бежит");
    }

    @Override
    public String voice() {
        return name + " говорит Гав";
    }
}
