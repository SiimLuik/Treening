import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Lugeja {
    public static Treeningkava loeFailist (String filename) throws Exception{
        List<Harjutus> harjutused = new ArrayList<>();
        java.io.File fail = new java.io.File(filename);
        java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8");

        String nimi = sc.nextLine(); //esimesel real nimi
        sc.nextLine(); //teisel info/tühi
        sc.nextLine(); //kolmas tühi

        while(sc.hasNextLine()){
            //loeb sisse koos tekstifailis olnud kaalude/vahemaadega, kasutada koos algseisu taastamisega, kui tahta puhas kava luua
            String rida = sc.nextLine();
            String[] andmed = rida.split(";");
            //kolm semikoolonit - kestvusharjutust, kui andmemassiivi pikkus on alla kolme, siis vahemiku muutujat pole antud
            if((rida.length() - rida.replace(";", "").length()) == 3) {
                if (andmed.length == 2)
                    harjutused.add(new KestvusHarjutus(andmed[0], Double.parseDouble(andmed[1]), null));
                else if (andmed.length == 3)
                    harjutused.add(new KestvusHarjutus(andmed[0], Double.parseDouble(andmed[1]), Double.parseDouble(andmed[2])));
            }
            //sama mis kestvusharjutusel, ainult nelja semikooloniga
            else if ((rida.length() - rida.replace(";", "").length()) == 4) {
                if (andmed.length == 3)
                    harjutused.add(new JõuHarjutus(andmed[0], Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2]), null));
                else if (andmed.length == 4)
                    harjutused.add(new JõuHarjutus(andmed[0], Integer.parseInt(andmed[1]), Integer.parseInt(andmed[2]), andmed[3]));
            }
        }
        sc.close();

        return new Treeningkava(nimi, harjutused);
    }

    public static void loeFaili(String filename, Treeningkava kava) throws Exception{
        //loob samasuguse faili, kui sisselugemiseks vaja
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.println(kava.getNimi() + "\n\n");
        for(Harjutus harjutus: kava.getHarjutused())
            writer.println(harjutus);
        writer.close();
    }

    public static Treeningkava areng(Treeningkava algus, Treeningkava lõpp){
        //deepcopy, kuna harjutused on listid, ning jõuharjutustel on kaalud listis
        List<Harjutus> harjutused = new ArrayList<>();
        for(Harjutus h: lõpp.getHarjutused()) {
            if(h instanceof JõuHarjutus)
                harjutused.add(new JõuHarjutus(h.getNimi(), ((JõuHarjutus) h).getSets(), ((JõuHarjutus) h).getReps(), ((JõuHarjutus) h).kaaludString()));
            else if(h instanceof KestvusHarjutus)
                harjutused.add(new KestvusHarjutus(h.getNimi(), ((KestvusHarjutus) h).getKiirus(), ((KestvusHarjutus) h).getVahemik()));
        }
        //arengusse jäävad lõpukava andmed
        Treeningkava arengKava = new Treeningkava(lõpp.getNimi(), harjutused);

        //vaatame arengu (lõpu muutujatega) kõiki harjutusi, võrdleme alguskava harjutustega ning lahutame kõigist arengukava tulemustest alguse omad
        for(Harjutus harjutusLõpp:arengKava.getHarjutused()) {
            for (Harjutus harjutusAlg: algus.getHarjutused()) {
                if (harjutusLõpp.getNimi().equals(harjutusAlg.getNimi())){
                    //sama nimega, seega sama harjutus. vaatame, kas tegu kestvuse või jõuga
                    if(harjutusAlg instanceof KestvusHarjutus && harjutusLõpp instanceof KestvusHarjutus) {
                        //kui üks kestvuse vahemikest on Null, ehk kasutajalt määramata, siis sel juhul jätame lõpu tulemuse
                        if (((KestvusHarjutus) harjutusAlg).getVahemik() != null && ((KestvusHarjutus) harjutusLõpp).getVahemik() != null)
                            ((KestvusHarjutus) harjutusLõpp).setVahemik(((KestvusHarjutus) harjutusLõpp).getVahemik() - ((KestvusHarjutus) harjutusAlg).getVahemik());
                    }
                    else if(harjutusAlg instanceof JõuHarjutus && harjutusLõpp instanceof JõuHarjutus){
                        List<Integer> arengKaalud = new ArrayList<>();
                        for(int i = 0; i < ((JõuHarjutus) harjutusLõpp).getKaalud().size(); i++)
                            arengKaalud.add(((JõuHarjutus) harjutusLõpp).getKaalud().get(i) - ((JõuHarjutus) harjutusAlg).getKaalud().get(i));
                        ((JõuHarjutus) harjutusLõpp).setKaalud(arengKaalud);
                    }
                }
            }
        }
        //kõigi harjutuste kaalud/vahemaad muudetud, tagastame kava
        return arengKava;
    }
}
