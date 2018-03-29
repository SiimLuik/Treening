import java.io.PrintWriter;
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
            String[] andmed = sc.nextLine().split(";");
            if(andmed.length == 3)
                harjutused.add(new KestvusHarjutus(andmed[0], Double.parseDouble(andmed[1])));
            else
                harjutused.add(new JõuHarjutus(andmed[0], Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2])));
        }
        sc.close();

        return new Treeningkava(nimi, harjutused);
    }

    public static void loeFaili(String filename, Treeningkava kava) throws Exception{ //kaalude/kestvuse muutujad omistatud olema
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.println(kava.getNimi() + "\n");
        for(Harjutus harjutus: kava.getHarjutused())
            writer.println(harjutus);
        writer.close();
    }
}
