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
            //loeb sisse koos tekstifailis olnud kaalude/vahemaadega, kasutada algseisu taastamist, kui tahta uus fail luua
            String rida = sc.nextLine();
            String[] andmed = rida.split(";");
            if((rida.length() - rida.replace(";", "").length()) == 3) {
                if (andmed.length == 2)
                    harjutused.add(new KestvusHarjutus(andmed[0], Double.parseDouble(andmed[1]), null));
                else if (andmed.length == 3)
                    harjutused.add(new KestvusHarjutus(andmed[0], Double.parseDouble(andmed[1]), Double.parseDouble(andmed[2])));
            }
            else if ((rida.length() - rida.replace(";", "").length()) == 4) {
                if (andmed.length == 4)
                    harjutused.add(new JõuHarjutus(andmed[0], Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2]), andmed[3]));
                else if (andmed.length == 3)
                    harjutused.add(new JõuHarjutus(andmed[0], Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2]), ""));
            }
        }
        sc.close();

        return new Treeningkava(nimi, harjutused);
    }

    public static void loeFaili(String filename, Treeningkava kava) throws Exception{ //kaalude/kestvuse muutujad omistatud olema
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.println(kava.getNimi() + "\n\n");
        for(Harjutus harjutus: kava.getHarjutused())
            writer.println(harjutus);
        writer.close();
    }
}
