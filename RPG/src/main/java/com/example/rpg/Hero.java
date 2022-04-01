package com.example.rpg;

import java.util.Arrays;

public abstract class Hero {
    private int lifePoints;
    private int armor;
    private int weaponDamage;
    private Potion[] potions;
    private Food[] lembas;

    public void attack() {};
    public void defend() {};
    public void useConsumable() {};

    @Override
    public String toString() {
        return "Hero{" +
                "lifePoints=" + lifePoints +
                ", armor=" + armor +
                ", weaponDamage=" + weaponDamage +
                ", potions=" + Arrays.toString(potions) +
                ", lembas=" + Arrays.toString(lembas) +
                '}';
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public Potion[] getPotions() {
        return potions;
    }

    public void setPotions(Potion[] potions) {
        this.potions = potions;
    }

    public Food[] getLembas() {
        return lembas;
    }

    public void setLembas(Food[] lembas) {
        this.lembas = lembas;
    }
}

class Hunter extends Hero {
    int arrows;
}

class Warrior extends Hero {

}

abstract class SpellCaster extends Hero {

}

class Healer extends SpellCaster {

}

class Mage extends SpellCaster {

}