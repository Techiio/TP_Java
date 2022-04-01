package com.example.rpg;

import java.util.Arrays;

public abstract class Enemy {
    private int lifePoints;

    @Override
    public String toString() {
        return "Enemy{" +
                "lifePoints=" + lifePoints +
                '}';
    }
    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

}

class BasicEnemy extends Enemy {
 public BasicEnemy(){
     setLifePoints(50);
 }
}

class Boss extends Enemy {
    public Boss(){
        setLifePoints(200);
    }
}
