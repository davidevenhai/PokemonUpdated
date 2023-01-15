import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Charmander charmander = new Charmander();
        Salandit salandit = new Salandit();
        Moltres moltres = new Moltres();
        Pichu pikachu = new Pichu();
        Blitzle blitzle = new Blitzle();
        Electabuzz electabuzz = new Electabuzz();

        Charmander charmander2 = new Charmander();
        Salandit salandit2 = new Salandit();
        Moltres moltres2 = new Moltres();
        Pichu pikachu2 = new Pichu();
        Blitzle blitzle2 = new Blitzle();
        Electabuzz electabuzz2 = new Electabuzz();

        Pokemon[] arrayPokemon = {charmander, salandit, moltres, pikachu, blitzle, electabuzz};
        Pokemon[] arrayPokemon2 = {charmander2, salandit2, moltres2, pikachu2, blitzle2, electabuzz2};
        int pokemon1 = random.nextInt(0, 6);
        int pokemon2 = random.nextInt(0, 6);

        Pokemon pokemonUser1 = arrayPokemon[pokemon1];
        Pokemon pokemonUser2 = arrayPokemon2[pokemon2];
        Battle battle = new Battle(pokemonUser1,pokemonUser2);
    }
}
