import animals.Animal;
import animals.Voice;
import foods.Food;

public class Worker {
    public void feed(Food food, Animal animal) {
        System.out.println(animal.getName() + " " + animal.eat(food));
    }

    public void getVoice(Voice animal) {
        Voice voice = animal;
        System.out.println(voice.voice());
    }
}
