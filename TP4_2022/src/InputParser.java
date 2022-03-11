import java.util.Scanner;

public class InputParser {
    //Nombre de joueurs
    public static void nbreHero() { //fonction initiale
        Scanner scanner = new Scanner(System.in); //récupérer les entrées consoles
        System.out.println("Bonjour, combien d'héros êtes-vous ?");
        int nbreHero = scanner.nextInt(); //nombre de héros
    }
}
