import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Broneering {

    public static String[][] juhuslikBroneerin(String[][] a2){
        // Antud: kahekordne massiiv ehk saali plaan
        // Broneerime juhuslikul meetodil mingi osa saalis olevatest kohtadest
        // Tagastame kahekordse massiivi, mis kujutab osaliselt broneeritud saaliplaani
        int kogus = 0;
        while ( kogus <= a2.length* a2[1].length){
            for(int i=0;i<a2.length;i++){
                for(int j=0;j<a2[i].length;j++){
                    int rida1 = (int) (Math.random()*a2.length);
                    int koht1 =  (int) (Math.random()*a2[i].length);
                    if (i == rida1 && j == koht1){
                        a2[i][j] = "X";}
                }
            }
            kogus++;
        }
        return a2;

    }

    public static String[][] broneerin(String[][] a2, int rida , int koht){
        // Meetodiga broneeritakse kliendi piletid
        // Antud on kahekordne massiiv
        // Tagastame muudetud saali plaani
        for(int i=0;i<a2.length;i++){
            for(int j=0;j<a2[i].length;j++)
                if (i == rida && j == koht)
                    a2[i][j] = "X";
        }
        return a2;

    }

    public static void main(String[] args) {

        // Loome saali
        Saal saal = new Saal(20, 22, 1, 10, "Vanemuine");
        System.out.println(saal);
        String[][] saali_plaan = saal.tabel1(saal.getM(), saal.getN());

        System.out.println("\nSaali plaan                                                'nr'- koht on vaba   'X'- koht on kinni");
        System.out.println("====================================================================================================:");

        // Lisame tühjale saaliplaanile juhuslikult valitud kohad ehk broneerimie osad kohad
        juhuslikBroneerin(saali_plaan);
        saal.valjasta_tabel1(saali_plaan);

        // Üldinfo
        Tavapilet pilet = new Tavapilet(0);
        Sooduspilet soodus = new Sooduspilet(0, 0);
        System.out.println("\n\tVALI SOBIVAD KOHAD JA BRONEERI TEATRIPILETID\n" +
                "\tEtendus: 'Sweeney Todd' ");
        System.out.println(pilet.toString());
        System.out.println(soodus.toString());
        List<Integer> bronRida = new ArrayList<Integer>();
        List<Integer> bronKohad = new ArrayList<Integer>();

        System.out.println("\n\tKorraga saab piletid osta ühele reale. \n\tTeilt küsitakse rea numbrit ja siis koha numbrit. " +
                "\n\tKui kohti on rohkem kui üks, siis tuleb sisestada need ühekaupa (koht -> enter, koht -> enter jne)");


        // BRONEERIMINE
        Scanner scan = new Scanner(System.in);
        System.out.println("\nMitu piletit soovid kokku osta?");
        int KohtadeArv = scan.nextInt();
        // KONTROLLIME siestust
        System.out.println("Mitu piletit broneeringust on tavapiletid?");
        int tavaArv = scan.nextInt();
        while (tavaArv > KohtadeArv){
            System.out.println("Sisestatud piletite arv on liiga suur!");
            System.out.println("Mitu piletit broneeringust on TAVAPILETID?");
            tavaArv = scan.nextInt();
        }
        // Teeme tavapileti isendi
        Tavapilet a = new Tavapilet(tavaArv);

        System.out.println("Mitu piletit broneeringust on sooduspiletid?");
        int soodusArv = scan.nextInt();
        // KONTROLLIME siestust
        while ((soodusArv+tavaArv) != KohtadeArv ){
            System.out.println("Sisestatud piletite arv ei klapi. Sisesta uuesti!");
            System.out.println("Mitu piletit broneeringust on SOODUSPILETID?");
            soodusArv = scan.nextInt();
        } //Teeme sooduspileti isendi
        Sooduspilet b = new Sooduspilet(tavaArv, soodusArv);

        System.out.println("Sisesta rea number:");
        int rida = scan.nextInt();
        while (rida > saali_plaan.length || rida < 1){
            System.out.println("Sisestatud rida saalis ei leidu. Sisesta rea number uuesti:");
            rida = scan.nextInt();}
        for (int i = 0; i < KohtadeArv ; i++) {
            System.out.println("Sisesta koha number:");
            int nr = scan.nextInt();
            while (nr > saali_plaan[i].length || rida < 1){
                System.out.println("Sisestatud kohta saalis ei leidu. Sisesta koha number uuesti:");
                nr = scan.nextInt();}
            while (saali_plaan[rida-1][nr-1] == "X"){
                System.out.println("See koht on juba kinni. Sisesta uus!");
                System.out.println("Sisesta koha number:");
                nr = scan.nextInt();
            }
            bronRida.add(rida-1);
            bronKohad.add(nr-1);
            broneerin(saali_plaan,(rida-1),(nr-1));
        }
        System.out.println();
        System.out.println("\nSINU KOHAD ON BRONEERITUD                                  'nr'- koht on vaba   'X'- koht on kinni");
        System.out.println("====================================================================================================:");
        // Väljastame uuendatud saali plaani
        saal.valjasta_tabel1(saali_plaan);

        // Väljastan broneeritud piletite info
        System.out.println("\nSinu piletid on broneeritud!");
        for (int i = 0; i < bronKohad.size() ; i++) {
            System.out.println("Rida: " + bronRida.get(i) + "  Koht: " + bronKohad.get(i));
        }
        System.out.println("\nTasumisele kuulub " + (a.summa()+b.summa()) + " EUR \n\nAitäh ja toredaid elamusi!");
    }
}
