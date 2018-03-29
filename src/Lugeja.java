import java.util.ArrayList;
import java.util.List;

public class Lugeja {
    public static Treeningkava loeFailist (String filename) throws Exception{
        List<Harjutus> harjutused = new ArrayList<>();
        java.io.File fail = new java.io.File(filename);
        java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8");

        String nimi = sc.nextLine(); //esimesel real nimi
        sc.nextLine(); //teisel aeg/tühi
        sc.nextLine(); //kolmas tühi

        while(sc.hasNextLine()){
            JõuHarjutus harjutus = new JõuHarjutus(sc.nextLine());
            harjutused.add(harjutus); //neljas kuni lõpuni on harjutused
        }
        sc.close();

        return new Treeningkava(nimi, harjutused);
    }

    public static void loeFaili(Treeningkava kava){ //kaalude/kestvuse muutujad omistatud olema

    }
}
