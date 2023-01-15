import java.util.Scanner;

public class Battle {

    public Battle(Pokemon pokemonUser1, Pokemon pokemonUser2) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pokemon game");
        System.out.println("First player, your Pokemon:");
        System.out.println(pokemonUser1 + "\n");
        System.out.println("Second player, your Pokemon:");
        System.out.println(pokemonUser2 + "\n");
        boolean checkTurn1 = false;
        boolean checkEndGame = false;
        do {
            do {
                System.out.println("First player, your turn, choose the option you prefer" + "\n"
                        + "1.Making an attack." + "\n" + "2.Waiting." + "\n"
                        + "3.Evolution." + "\n"
                        + "4.Special action.");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        int attackPoint = pokemonUser1.attack();
                        if (attackPoint == -1) {
                            checkTurn1 = false;
                        } else {
                            pokemonUser2.downHp(attackPoint);
                            checkTurn1 = true;
                        }
                    }
                    case 2 -> {
                        pokemonUser1.waiting();
                        checkTurn1 = true;
                    }
                    case 3 -> {
                        checkTurn1 = pokemonUser1.levelUp();
                    }
                    case 4 -> {
                        checkTurn1 = pokemonUser1.specialAction(pokemonUser2);
                    }
                }
            } while (!checkTurn1);
            pokemonUser1.newTurn();
            checkEndGame = checkWinner(pokemonUser1, pokemonUser2);
            System.out.println("First player, your Pokemon:");
            System.out.println(pokemonUser1 + "\n");
            System.out.println("Second player, your Pokemon:");
            System.out.println(pokemonUser2 + "\n");
            if (!checkEndGame) {
                boolean checkTurn2 = false;
                do {
                    System.out.println("Second player, your turn, choose the option you prefer" + "\n"
                            + "1.Making an attack." + "\n"
                            + "2.Waiting." + "\n"
                            + "3.Evolution." + "\n"
                            + "4.Special action.");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            int attackPoint = pokemonUser2.attack();
                            if (attackPoint == -1) {
                                checkTurn2 = false;
                            } else {
                                pokemonUser1.downHp(attackPoint);
                                checkTurn2 = true;
                            }
                        }
                        case 2 -> {
                            pokemonUser2.waiting();
                            checkTurn2 = true;
                        }
                        case 3 -> {
                            checkTurn2 = pokemonUser2.levelUp();
                        }
                        case 4 -> {
                            checkTurn2 = pokemonUser2.specialAction(pokemonUser2);
                        }
                    }
                } while (!checkTurn2);
                pokemonUser2.newTurn();
                checkEndGame = checkWinner(pokemonUser1, pokemonUser2);
                if (!checkEndGame) {
                    System.out.println("First player, your Pokemon:");
                    System.out.println(pokemonUser1 + "\n");
                    System.out.println("Second player, your Pokemon:");
                    System.out.println(pokemonUser2 + "\n");
                }
            }

        } while (!checkEndGame);
    }


    public boolean checkWinner(Pokemon pokemomUser1, Pokemon pokemomUser2) {
        boolean check = false;
        if (pokemomUser1.getHp() <= 0 && pokemomUser2.getHp() > 0) {
            System.out.println("The winner of the battle is the Second player");
            check = true;
        } else if (pokemomUser2.getHp() <= 0 && pokemomUser1.getHp() > 0) {
            System.out.println("The winner of the battle is the First player");
            check = true;
        } else if (pokemomUser2.getHp() <= 0 && pokemomUser1.getHp() <= 0) {
            System.out.println("The battle ended in a draw");
            check = true;
        }
        return check;

    }

}
