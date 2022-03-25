import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel exercice ? Saisissez :\n" +
                "1. Discriminant\n" +
                "2. Parité d’un nombre\n" +
                "3. Calcul d’extremum\n" +
                "4. Égalité entre chaînes de caractères\n" +
                "5. Factorielle\n" +
                "6. Compte à rebous\n" +
                "7. Valeurs de carrés\n" +
                "8. Table de multiplication\n" +
                "9. Division d’entiers\n" +
                "10. Règle graduée\n" +
                "11. Nombres premiers\n" +
                "12. Manipulations sur un tableau\n" +
                "13. Exam TP noté 1");
        int choix = scanner.nextInt();
        System.out.println("\n");
        switch(choix){
            case 1:
                discriminant();
                break;

            case 2:
                parite();
                break;

            case 3:
                max();
                break;

            case 4:
                egaliteStr();
                break;

            case 5:
                factorielle();
                break;

            case 6:
                countdown();
                break;

            case 7:
                carres();
                break;

            case 8:
                tableMultiplication();
                break;

            case 9:
                division();
                break;

            case 10:
                regle();
                break;

            case 11:
                nombrePremier();
                break;

            case 12:
                initialisationTableau();
                break;

            case 13:
                Book();
        }
    }

    //EXAM
    public static void triangle(int n) {
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void function1(String message) {

        // Creating array of string length
        char[] ch = new char[message.length()];

        // Copy character by character into array
        for (int i = 0; i < message.length(); i++) {
            ch[i] = message.charAt(i);
        }

        // Printing content of array
        for (char c : ch) {
            if(c == 'a'){
                System.out.print("a ");
            }else if(c == 'e'){
                System.out.print("e ");
            }else if(c == 'i'){
                System.out.print("i ");
            }else if(c == 'o'){
                System.out.print("o ");
            }else if(c == 'u'){
                System.out.print("u ");
            }else if(c == 'y'){
                System.out.print("y ");
            }else if(c == 'A'){
                System.out.print("a ");
            }else if(c == 'E'){
                System.out.print("e ");
            }else if(c == 'I'){
                System.out.print("i ");
            }else if(c == 'O'){
                System.out.print("o ");
            }else if(c == 'U'){
                System.out.print("u ");
            }else if(c == 'Y'){
                System.out.print("y ");
            }
        }
    }
    public void Book(){
        Book daVinciCode = new Book("Da Vinci Code", "Dan Brown", 2003);
        String description = daVinciCode.getDescription();
        System.out.println(description);
    }
    class Book {
        private String bookName, author, description;
        private int releaseYear;
        public Book(String bookName, String author, int releaseYear) {
            this.bookName = bookName;
            this.author = author;
            this.releaseYear = releaseYear;
            this.description = bookName + " écrit par " + author + " est sorti en " + releaseYear + ".";
        }
        public String getDescription() {
            return this.description;
        }
    }


    //Question 3.1.1
    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();

        int delta = (int) (Math.pow(b, 2) - 4 * a * c); // Calcul du discriminant

        if (delta < 0) { // Cas discriminant négatif
            System.out.println("Ce polynome n’a pas de racine reelle");
            float racine1reel = (float) (-(b) / (2 * a));
            float racine2reel = (float) (-(b) / (2 * a));
            float racine1complexe = (float) ((Math.sqrt(-delta)) / (2 * a));
            float racine2complexe = (float) ((Math.sqrt(-delta)) / (2 * a));
            System.out.println("Les deux racines complexes sont donc " + racine1reel + "+i" + racine1complexe + " et " + racine2reel + "-i" + racine2complexe);

        }
        if (delta == 0) { // Cas discriminant nul
            float racine0 = (float) (-(b) / (2 * a));
            System.out.println("Ce polynome a une racine reelle : " + racine0);
        }
        if (delta > 0) { // Cas discriminant positif
            float racine1 = (float) (((-b) + Math.sqrt(delta)) / (2 * a));
            float racine2 = (float) (((-b) - Math.sqrt(delta)) / (2 * a));

            System.out.println("Ce polynome a deux racines reelles : " + racine1 + " et " + racine2);
        }
    }

    //Question 3.1.2
    public static void parite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un entier ?");
        int a = scanner.nextInt();

        if ( (a % 2) == 0){ //Condition si le reste de la division par 2 est nulle
            System.out.println("L'entier " + a + " est pair.");
        }else{ //Sinon l'entier est impair
            System.out.println("L'entier " + a + " est impair.");
        }
    }

    //Question 3.1.3
    public static void max() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez un premier entier ?");
        int a = scanner.nextInt();
        System.out.println("Saisissez un second entier ?");
        int b = scanner.nextInt();

        System.out.println("Le maximum entre " + a + " et " + b + " est " + Math.max(a,b)); //Maximum
        System.out.println("Le minimum entre " + a + " et " + b + " est " + Math.min(a,b)); //Minimum

    }

    //Question 3.1.4
    public static void egaliteStr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez une premiere chaine de caractere ?");
        String a = scanner.nextLine();
        System.out.println("Saisissez une seconde chaine de caractere ?");
        String b = scanner.nextLine();

        boolean test = a.equals(b); // Test d'egalite des chaines

        if (test){//Cas identique
            System.out.println("Les chaines de caracteres sont identiques");
        }else{//Cas contraire
            System.out.println("Les chaines de caracteres ne sont pas identiques");

        }

    }

    //Question 3.2
    public static void factorielle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un entier positif ou nul");
        int n = scanner.nextInt();

        int factorielle = 1;
        for (int i = 1; i <= n; i++) { //Calcul du factoriel
            factorielle *= i;
        }
        System.out.println(n + "! = " + factorielle);
    }

    //Question 3.2.1
    public static void countdown() {
        int countdown = 10;
        while (countdown != 0){
            System.out.println(countdown);
            countdown -= 1;

        }
        System.out.println("BOOM !");
    }

    //Question 3.2.2
    public static void carres() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un entier");
        int n = scanner.nextInt();

        int ncarre = n * n;

        System.out.println("Le carre de " + n + " est " + ncarre);

    }

    //Question 3.2.3
    public static void tableMultiplication() {
        int b = 1;
        for (int i = 1; i <= 10; i++){ //La table qui va être multipliée
            for (int c = 1; c <= 10; c++){ //Les différents élements de la table
                System.out.print(c * b);
            }
            System.out.println();
            b += 1;
        }

    }

    //Question 3.2.5
    public static void division() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisissez le numérateur ?");
        int a = scanner.nextInt();

        int b;
        do {
            System.out.println("Saisissez le dénominateur ?");
            b = scanner.nextInt();
        } while (b == 0); //Dénominateur nul donc recommencer

        System.out.println("La division de " + a + " par " + b + " est " + a/b);


    }

    //Question 3.3.1
    public static void regle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Longueur ?");
        int a = scanner.nextInt();
        for(int i = 0; i <= a; i++){ //On balaye toutes les unités
            if((i % 10) == 0){ //L'unité est une dizaine
                System.out.print("|");
            }else{ //L'unité n'est pas une dizaine
                System.out.print("-");
            }
        }
    }

    //Question 3.3.2
    public static void nombrePremier() {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.println("Saisissez un entier strictement positif ?");
            n = scanner.nextInt();
        } while (n <= 0); //Entier non strictement positif donc recommencer

        boolean isPremier = true; //Partir du principe qu'il est premier
        if (n != 1) { //Cas particulier pour 1
            for (int i = 2; i <= n/2; i++) { //Calcul pour tous les entiers situés entre 2 et lui-même
                if (n != i && n % i == 0) { //Cas où l'entier est divisible
                    isPremier = false; //Alors non premier
                    break;
                }
            }
        }
        if (isPremier) { //Ducoup il est premier puisque rien ne dit qu'il ne l'est pas
            System.out.println("L'entier est un nombre premier");
        }else{
            System.out.println("L'entier n'est pas premier");
        }
    }

    //Question 3.4.1
    public static void initialisationTableau() {
        int[] tableau = new int[20];
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < tableau.length; i++) { //création des 20 valeurs du tableau
            System.out.println("Saisir un entier");
            int entier = scanner.nextInt();
            tableau[i] = entier;
            if (entier > min){ //valeur maximale
                min = entier;
            }
            if (entier < max){ //valeur minimale
                max = entier;
            }
        }
        System.out.println("La valeur minimale du tableau est " + max);
        System.out.println("La valeur maximale du tableau est " + min);
        System.out.print("La somme des elements du tableau est ");
        int somme = 0;
        for (int i = 0; i < tableau.length; i++){ //Calcul de la somme
            somme += tableau[i];
        }
        System.out.println(somme);
        System.out.print("Les nombres pairs sont ");
        for (int i = 0; i < tableau.length; i++){ //Les nombres pairs
            if (tableau[i] % 2 == 0){
                System.out.print(tableau[i] + " ");
            }
        }
        System.out.print("\nLes indices des nombres pairs sont "); //Les indices pairs
        for (int i = 0; i < tableau.length; i++){
            if (tableau[i] % 2 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println("\nLe tableau inverse revient à " + inverseTableau(tableau)); //Le tableau inverse


    }

    public static int[] inverseTableau(int[] tableau){ //Fonction d'inversion du tableau
        int tableauInverse[] = new int[20];
        for(int i = 1; i < tableau.length; i++){
            tableauInverse[i-1] = tableau[tableau.length-i]; //On interchange les positions
        }
        return tableauInverse; //Bon ça marche pas mais je comprends pas trop ce que ça me ressort :c
    }

}




