public class Game {
    private Hero[] heroes;
    private int playerTurn;
    private InputParser inputParser;

    public Game() {
        heroes = new Hero[4];
        heroes[0] = new Hunter();
        heroes[1] = new Healer();
        heroes[2] = new Mage();
        heroes[3] = new Warrior();

        for (Hero hero:heroes) {
            System.out.println(hero);
        }
    }

    public int playGame() {
        return 1;
    };

    public void generateCombat() {};

    public Hero[] getHeroes() {
        return heroes;
    }
}

