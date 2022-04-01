package com.example.rpg;

import java.util.Arrays;

public abstract class Hero {
    private int lifePoints;
    private int armor;
    private int weaponDamage;
    private int moulaga;
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
                ", moulaga=" + moulaga +
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

    public int getMoulaga(){ return moulaga;}

    public void setMoulaga(int moulaga){ this.moulaga = moulaga;}
}

class Hunter extends Hero {
    int arrows;

    public Hunter(){
        setLifePoints(100);
        setArmor(100);
        setWeaponDamage(20);
        setMoulaga(10);
    }
}

class Warrior extends Hero {
    public Warrior(){
        setLifePoints(100);
        setArmor(200);
        setWeaponDamage(10);
        setMoulaga(5);
    }

}

abstract class SpellCaster extends Hero {
}

class Healer extends SpellCaster {
    public Healer(){
        setLifePoints(200);
        setArmor(50);
        setWeaponDamage(10);
        setMoulaga(10);
    }
}

class Mage extends SpellCaster {
    public Mage(){
        setLifePoints(75);
        setArmor(50);
        setWeaponDamage(30);
        setMoulaga(20);
    }
}