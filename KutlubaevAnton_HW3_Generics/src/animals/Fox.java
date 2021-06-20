package animals;

public class Fox extends Carnivorous implements Voice, Run {

    private String name = "Лиса";

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Лиса бежит");
    }

    @Override
    public String voice() {
        return name + " говорит Гав";
    }
}
