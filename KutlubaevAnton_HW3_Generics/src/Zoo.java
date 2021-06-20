import animals.*;
import foods.Banana;
import foods.Pork;

public class Zoo {
    public static void main(String[] args) {
        Cow cow = new Cow();
        Duck duck = new Duck();
        Fox fox = new Fox();
        Pike pike = new Pike();
        Sheep sheep = new Sheep();
        Wolf wolf = new Wolf();
        Banana banana = new Banana();
        Pork pork = new Pork();

        Worker worker = new Worker();
        worker.getVoice(wolf);
        worker.feed(pork, cow);
        worker.feed(banana, cow);
        worker.feed(pork, fox);
        worker.feed(banana, fox);

        Swim[] animals = {pike, duck};
        for (Swim animal : animals) {
            animal.swim();
        }
    }
}
