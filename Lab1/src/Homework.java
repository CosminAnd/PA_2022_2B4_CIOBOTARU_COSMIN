import java.util.ArrayList;

public class Homework {
    static class Neighbors {
        String princ;
        ArrayList<String> nbh = new ArrayList<>();
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Eroare la argumente! Prea multe argumente.");
            System.exit(-1);
        }
        if(!args[0].matches("[0-9]+")) {
            System.out.println("Eroare la argumente! Tip necorespunzator.");
            System.exit(-2);
        }
        if(!args[1].matches("[0-9]+")) {
            System.out.println("Eroare la argumente! Tip necorespunzator.");
            System.exit(-3);
        }

        int n = Integer.parseInt(args[0]); //array size
        int p = Integer.parseInt(args[1]); // word size
        int m = args.length - 2; //number of letters
        char[] letters = new char[m];
        for (int i = 2; i < args.length; i++)
            letters[i - 2] = args[i].toCharArray()[0];
        //System.out.println(letters);

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int ct = 0;
            while (ct < p) {
                int pos = (int) (Math.random() * m + 1) - 1;
                //System.out.println(pos);
                sb.append(letters[pos]);
                ct++;
            }
            words[i] = sb.toString();
        }
        System.out.println("Cuvintele sunt:");
        for (int i = 0; i < n; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println("\nPerechile de vecini sunt:");
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    char[] cuv1 = words[i].toCharArray();
                    char[] cuv2 = words[j].toCharArray();
                    boolean ok = false;
                    for (int l = 0; l < p; l++)
                        for (int k = 0; k < p; k++)
                            if (cuv1[l] == cuv2[k]) {
                                ok = true;
                                break;
                            }
                    if (ok) {
                        matrix[i][j] = true;
                    }
                }

            }
        /*  System.out.println("\n Matricea este:");
            for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }*/

        ArrayList<Neighbors> NBH = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Neighbors temp = new Neighbors();
            temp.princ = words[i];
            for (int j = 0; j < n; j++)
                if (matrix[i][j]) {
                    temp.nbh.add(words[j]);

                }
            NBH.add(temp);
        }
        if (n < 1000) {
            for (Neighbors neighbors : NBH) {
                Neighbors temp1; //= new Neighbors();
                temp1 = neighbors;
                System.out.println(temp1.princ + " " + temp1.nbh);
            }
        } else {
            System.out.println("\n");
            long t1 = System.currentTimeMillis();
            t1 = t1 * 1000000;
            System.out.println(t1);
        }

    }
}
