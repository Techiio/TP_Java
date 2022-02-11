import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        volume();
    }

    public static void init() { //fonction initiale
        Scanner scanner = new Scanner(System.in); //récupérer les entrées consoles
        System.out.println("Bonjour, quel est votre prénom ?");
        String prenom = scanner.nextLine();
        System.out.println("Bonjour, " + prenom);
        int unEntier = scanner.nextInt(); //nombre 1
        float unReel = scanner.nextFloat(); //nombre 2
        System.out.println("J’ai recupere un entier: " + unEntier); //affichage de l'entier'
        System.out.println("J’ai aussi recupere un reel: " + unReel); //affichage du réel
    }

    public static void somme(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int somme = premierEntier + deuxiemeEntier;
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + somme);
    }

    public static void division(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int division = premierEntier / deuxiemeEntier;
        System.out.println("La division de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + division);
    }

    public static void volume(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        float premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        float deuxiemeEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le troisieme entier");
        float troisiemeEntier = scanner.nextInt();
        float volume = premierEntier * deuxiemeEntier * troisiemeEntier;
        System.out.println("Le volume est de " + volume + " insérer unité");
    }

}