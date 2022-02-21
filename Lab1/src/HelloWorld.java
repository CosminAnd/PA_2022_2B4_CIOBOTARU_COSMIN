public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(languages[0]+","+languages[5]+","+languages[9]);

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n = n * 3;
        int n1 = Integer.parseInt("10101", 2); ///conversie din baza 2 in 10
        ///System.out.println(n1);
        n = n + n1;
        int n2 = Integer.parseInt("FF", 16);
        ///System.out.println(n2);
        n = n + n2;
        n = n * 6;
        System.out.println(n);


        while (n >= 10) {
            int aux = n;
            int sum = 0;
            while (aux > 0) {
                sum = sum + aux % 10;
                 aux = aux / 10;
            }
            n = sum;
        }
        System.out.println(n);

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}