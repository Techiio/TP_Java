import java.util.Arrays;

public class Hero {
    private int lifePoints;
    private int armor;
    private int weaponDamage;
    private Potion[] potions;
    private Food[] lembas;

    public void defend(){};
    public void attack(){
    };
    public void useConsumable(){};

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
}

abstract class SpellCaster extends Hero{

}

