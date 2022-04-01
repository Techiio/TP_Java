package com.example.rpg;

public class Game {
    private Hero[] heroes;
    private Enemy[] enemies;
    private int playerTurn;
    private InputParser inputParser;

    public Game() {
        heroes = new Hero[4];
        heroes[0] = new Hunter();
        heroes[1] = new Healer();
        heroes[2] = new Mage();
        heroes[3] = new Warrior();

        enemies = new Enemy[2];
        enemies[0] = new BasicEnemy();
        enemies[1] = new Boss();

        for (Hero hero:heroes) {
            System.out.println(hero);
        }
        for (Enemy enemy:enemies) {
            System.out.println(enemy);
        }
    }

    public int playGame() {
        return 1;
    };

    public void generateCombat() {};

    public Hero[] getHeroes() {
        return heroes;
    }
    public Enemy[] getEnemies() {
        return enemies;
    }
}

