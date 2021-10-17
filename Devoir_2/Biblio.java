import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici

    private String name;
    private boolean isPrimed;

    public Auteur()
    {
        this.name = "";
        this.isPrimed = false;
    }

    public Auteur(String name, boolean isPrimed)
    {
        this.name = name;
        this.isPrimed = isPrimed;
    }

    public String getNom()
    {
        return this.name;
    }

    public boolean getPrix()
    {
        return this.isPrimed;
    }
}

class Oeuvre
{
 	// Completer la classe Oeuvre ici

    private String title;
    private Auteur auteur;
    private String language;

    public Oeuvre(String title, Auteur auteur)
    {
        this.title = title;
        this.auteur = auteur;
        this.language = "francais";
    }

    public Oeuvre(String title, Auteur auteur, String language)
    {
        this.title = title;
        this.auteur = auteur;
        this.language = language;
    }

    public String getTitre()
    {
        return this.title;
    }

    public Auteur getAuteur()
    {
        return this.auteur;
    }

    public String getLangue()
    {
        return this.language;
    }

    public void afficher()
    {
        System.out.println(this.title + ", " + this.auteur.getNom() + ", en " + this.language);
    }
}

// completer les autres classes ici

class Exemplaire
{
 	// Completer la classe Exemplaire ici

    private Oeuvre oeuvre;

    public Exemplaire(Oeuvre oeuvre)
    {
        this.oeuvre = oeuvre;

        System.out.print("Nouvel exemplaire -> ");
        this.oeuvre.afficher();
    }

    public Exemplaire(Exemplaire exemplaire)
    {
        this.oeuvre = exemplaire.oeuvre;

        System.out.print("Copie d'un exemplaire de -> ");
        this.oeuvre.afficher();
    }

    public Oeuvre getOeuvre()
    {
        return this.oeuvre;
    }

    public void afficher()
    {
        System.out.print("Un exemplaire de ");
        this.oeuvre.afficher();
    }
}

class Bibliotheque
{
 	// Completer la classe Bibliotheque ici

    private String name;
    private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    public Bibliotheque(String name)
    {
        this.name = name;

        System.out.println("La bibliotheque " + this.name + " est ouverte !");
    }

    public String getNom()
    {
        return this.name;
    }

    public int getNbExemplaires()
    {
        return this.exemplaires.size();
    }

    public void stocker(Oeuvre oeuvre)
    {
        this.stocker(oeuvre, 1);
    }

    public void stocker(Oeuvre oeuvre, int n)
    {
        for (int i = 0; i < n; ++i)
        {
            this.exemplaires.add(new Exemplaire(oeuvre));
        }
    }

    public ArrayList<Exemplaire> listerExemplaires()
    {
        return this.exemplaires;
    }

    public ArrayList<Exemplaire> listerExemplaires(String language)
    {
        if (language.isEmpty())
        {
            return this.exemplaires;
        }

        ArrayList<Exemplaire> tmp = new ArrayList<>(this.exemplaires);

        tmp.removeIf(e -> e.getOeuvre().getLangue() != language);
        return tmp;
    }

    public int compterExemplaires(Oeuvre oeuvre)
    {
        ArrayList<Exemplaire> tmp = new ArrayList<>(this.exemplaires);

        tmp.removeIf(e -> e.getOeuvre() != oeuvre);
        return tmp.size();
    }

    public void afficherAuteur()
    {
        this.afficherAuteur(true);
    }

    public void afficherAuteur(boolean isPrimed)
    {
        ArrayList<Exemplaire> tmp = new ArrayList<>(this.exemplaires);

        tmp.removeIf(e -> e.getOeuvre().getAuteur().getPrix() != isPrimed);
        
        for (Exemplaire e: tmp)
        {
            System.out.println(e.getOeuvre().getAuteur().getNom());
        }
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}

