class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        int mostfrequent = tab1[0], mostfrequentcount = 0, tmpcount;

        for (int n : tab1)
        {
            tmpcount = 0;
            for (int m : tab1)
            {
                if (m == n)
                {
                    ++tmpcount;
                }
            }
            if (tmpcount > mostfrequentcount)
            {
                mostfrequent = n;
                mostfrequentcount = tmpcount;
            }
        }

        System.out.println(
            "Le nombre le plus frequent dans le tableau est le :\n"
            + mostfrequent
            + " ("
            + mostfrequentcount + " x)"
        );
        
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
