/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

import java.util.ArrayList;
import java.util.stream.Collectors;

class OptionVoyage {

    private String name;
    private double fixedPrice;

    public OptionVoyage(String name, double fixedPrice)
    {
        this.name = name;
        this.fixedPrice = fixedPrice;
    }

    public String getNom()
    {
        return this.name;
    }

    public double prix()
    {
        return this.fixedPrice;
    }

    public String toString()
    {
        return this.name + " ->  " + this.prix() + " CHF";
    }
}

class Sejour extends OptionVoyage {

    private int nbrNight;
    private double pricePerNight;

    public Sejour(String name, double fixedPrice, int nbrNight, double pricePerNight)
    {
        super(name, fixedPrice);
        this.nbrNight = nbrNight;
        this.pricePerNight = pricePerNight;
    }

    public double prix()
    {
        return (this.nbrNight * this.pricePerNight) + super.prix();
    }
}

class Transport extends OptionVoyage {

    static public final double TARIF_LONG = 1500.0;
    static public final double TARIF_BASE = 200.0;

    private boolean isLong;

    public Transport(String name, double fixedPrice)
    {
        super(name, fixedPrice);
        this.isLong = false;
    }

    public Transport(String name, double fixedPrice, boolean isLong)
    {
        super(name, fixedPrice);
        this.isLong = isLong;
    }

    public double prix()
    {
        return (this.isLong ? TARIF_LONG : TARIF_BASE) + super.prix();
    }
}

class KitVoyage {

    private String startingPoint;
    private String endingPoint;
    private ArrayList<OptionVoyage> options = new ArrayList<OptionVoyage>();

    public KitVoyage(String startingPoint, String endingPoint)
    {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public void ajouterOption(OptionVoyage option)
    {
        if (option != null) {
            this.options.add(option);
        }
    }

    public void annuler()
    {
        this.options.clear();
    }

    public int getNbOptions()
    {
        return this.options.size();
    }

    public double prix()
    {
        double price = 0.0;

        for (OptionVoyage option: this.options) {
            price += option.prix();
        }

        return price;
    }

    public String toString()
    {
        return "Voyage de "
            + this.startingPoint
            + " à "
            + this.endingPoint
            + ", avec pour options :\n"
            + this.options.stream()
                            .map(o -> "   - " + o + "\n")
                            .collect(Collectors.joining(""))
            + "Prix total : " + this.prix() + " CHF\n";
    }
}

 /*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}

