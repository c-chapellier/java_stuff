import java.util.ArrayList;
import java.util.Scanner;

class Contact {

    private String nom;
    private ArrayList<String> numeros = new ArrayList<>();

    public Contact() {
        Scanner clavier = new Scanner(System.in);

        System.out.println("Nom du contact?");
        this.nom = clavier.nextLine();

        System.out.println("Combien de numéro de téléphone pour ce contact?");
        int nombrenumero = clavier.nextInt();
        clavier.nextLine();

        for (int i = 0; i < nombrenumero; i++) {
            String numero = clavier.nextLine();
            this.numeros.add(numero);
        }
    }

    public Contact(String nom) {
        this.nom = nom;
    }

    public Contact(String nom, String numero) {
        this.nom = nom;
        this.numeros.add(numero);
    }

    public void addNumero(String numero) {
        this.numeros.add(numero);
    }

    public String getNom() {
        return this.nom;
    }

    public String toString() {
        String s = "nom : " + this.nom + "\n";

        if (this.numeros.isEmpty())
            return s + "aucun numéro pour ce contact\n";
            
        for (int i = 0; i < this.numeros.size(); i++) {
            s += "  " + this.numeros.get(i) + "\n";
        }
        
        return s + "\n";
    }

}

class Repertoire {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public Repertoire() {
    }

    public void ajouterContact(Contact c) {
        this.contacts.add(c);
    }

    public void ajouternumero(String nom, String numero) {
        for (int i = 0; i < this.contacts.size(); i++) {
            if (this.contacts.get(i).getNom().equals(nom)) {
                this.contacts.get(i).addNumero(numero);
                System.out.println("Le numéro a été ajouté à " + this.contacts.get(i).getNom());
                System.out.println();
                return ;
            }
        }
        System.out.println("Le contact " + nom + " n'existe pas");
        System.out.println();
    }

    public String toString() {
        String s = "Liste des contacts du répertoire :\n";

        for (int i = 1; i < this.contacts.size() + 1; ++i){
            s = s + "Contact " + i + "\n" + this.contacts.get(i - 1).toString() + "\n";
        }

        return s;
    }

}

class Test2 {
    public static void main(String[] args) {
        // test classe contact
        System.out.println("Test classe Contact : \n");

        Contact c1 = new Contact("Paul");
        Contact c2 = new Contact("Bob", "0473234567");
        Contact c3 = new Contact();

        System.out.print(c1);
        System.out.print(c2);
        System.out.print(c3);

        // test class repertoire
        System.out.println("Test classe Repertoire : \n");
        Repertoire r = new Repertoire();

        r.ajouterContact(c1);
        r.ajouterContact(c2);
        r.ajouterContact(c3);
        r.ajouterContact(new Contact());

        r.ajouternumero("Paul", "0000");
        r.ajouternumero("Zoro", "1111");

        System.out.print(r);
    }
}