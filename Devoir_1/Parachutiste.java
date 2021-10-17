import java.util.Scanner;

class Parachutiste {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        final double g = 9.81;

        double v0 = 0, t0 = 0;
        double vitesse = v0, hauteur = h0, accel = g;
        double t = t0, surface = 2.0;

        double q, s = surface / masse;

        boolean soundspeed = false, lowaccel = false;
        boolean lowhauteur = false;

        while (hauteur > 0.0)
        {
            System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);
            
            t += 1.0;
            q = Math.exp(-s * (t - t0));

            vitesse = (g / s) * (1 - q) + v0 * q;
            hauteur = h0 - (g / s) * (t - t0) - ((v0 - g / s) / s) * (1 - q);
            accel = g - s * vitesse;

            if (!soundspeed && vitesse > 343.0) {
                System.out.println("## Felix depasse la vitesse du son");
                soundspeed = true;
            }
            if (!lowhauteur && hauteur < 2500.0) {
                surface = 25.0;
                s = surface / masse;
                t0 = t;
                v0 = vitesse;
                h0 = hauteur;
                System.out.println("## Felix ouvre son parachute");
                lowhauteur = true;
            }
            if (!lowaccel && accel < 0.5) {
                System.out.println("## Felix a atteint sa vitesse maximale");
                lowaccel = true;
            }
        }
        
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}