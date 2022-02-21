
public class Homework {
    public static void main (String [] args ) {
        if(args.length<3) {
        System.out.println("Eroare la argumente!");
        System.exit(-1);
        }

        int n=Integer.parseInt(args[0]); //array size
        int p=Integer.parseInt(args[1]); // word size
        int m=args.length-2; //number of letters
        char[] letters= new char[m];
        for(int i=2; i< args.length; i++)
            letters[i-2]=args[i].toCharArray()[0];
        //System.out.println(letters);

        String[] words  = new String[n];
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int ct=0;
            while(ct < p){
                int pos= (int) (Math.random() * m +1)  - 1;
                //System.out.println(pos);
                sb.append(letters[pos]);
                ct++;
            }
            words[i]=sb.toString();
        }
        for(int i=0;i<n;i++) {
            System.out.print(words[i] + " ");
        }
        boolean[][] matrix= new boolean [n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(i!=j) {
                    char[] cuv1 = words[i].toCharArray();
                    char[] cuv2 = words[j].toCharArray();
                    boolean ok = false;
                    for (int l = 0; l < p; l++)
                        for (int k = 0; k < p; k++)
                            if (cuv1[l] == cuv2[k]) {
                                ok = true;
                                break;
                            }
                    if (ok ) {
                        matrix[i][j] = true;
                    }
                }

            }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j]+" ");
        System.out.print("\n");
        }
    }
}
