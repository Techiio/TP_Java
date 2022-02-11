import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init() { //fonction initiale
        Scanner scanner = new Scanner(System.in); //récupérer les entrées consoles
        int unEntier = scanner.nextInt(); //nombre 1
        float unReel = scanner.nextFloat(); //nombre 2
        System.out.println("J’ai recupere un entier: " + unEntier); //affichage de l'entier'
        System.out.println("J’ai aussi recupere un reel: " + unReel); //affichage du réel
        System.out.println("Bonjour, quel est votre prénom ?\n");

        String prenom = scanner.nextLine();
        System.out.println("Bonjour, " + prenom);
    }

    public static void somme(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int somme = premierEntier + deuxiemeEntier;
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier +
                "est egale a " + somme);
    }
    public static void division(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int division = premierEntier / deuxiemeEntier;
        System.out.println("La division de " + premierEntier + " avec " + deuxiemeEntier +
                "est egale a " + division);
    }
    public static void volume(){

    }

}