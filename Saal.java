

public class Saal {
    private int n;
    private int m;
    private int a;
    private int b;
    int a2;
    int x;
    private String nimi;


    public Saal(int m, int n, int a, int b, String nimi) {
        this.n = n;
        this.m = m;
        this.a = a;
        this.b = b;
        this.nimi = nimi;
    }

    public String[] jarjend_n_kuni_m(int n) {
        //Antud: n - elementide arv
        //Tagastab: n-elemendilise järjendi, elemendid lõigult [0 kuni n) on element on "X"
        String[] x = new String[n];
        int arv = 0;
        for (int i = 0; i < n; i++) {
            arv = i + 1;
            String koht = String.valueOf(arv);
            //StringBuilder arv = new StringBuilder(4);
            x[i] = String.valueOf(arv);
        }
            return x;
    }

    public String[][] tabel1(int m, int n){
        //Antud: m rida ja n veergu - tabeli
        //Tagastab: m*n-elemendilise string  massiivi, elemendid  "X"  loigult [0,n)
        String[][] a2=new String[m][n];
        for(int i=0;i< m;i++)
            a2[i]=jarjend_n_kuni_m(n);
        return a2;
    }

    public void valjasta_tabel1(String[][] a2){
        //Antud: tabel a
        //Väljastab a elemendid tabelina
        for(int i=0;i<a2.length;i++){
            System.out.print("rida " + (i+1) +"  \t");
            for(int j=0;j<a2[i].length;j++)
                System.out.print(a2[i][j] + "\t");
            System.out.println();
        }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getA2() {
        return a2;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "\n\tSINU BRONEERING\n" +
                "\tTeatripiletid etendusele 'Sweeney Todd' " + "\n" +
                "\tTeatrisaal: " + nimi + "\n"+
                "\tRidade arv saalis: " + m + "\n"+
                "\tKohtade arv reads: " + n + "\n";
    }
}
