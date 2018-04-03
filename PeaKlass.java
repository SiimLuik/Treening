import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PeaKlass {
    public static void main(String[] args) throws Exception {

        File f = new File("C:\\Users\\Siim\\IdeaProjects\\ProgeProjekt\\src\\");

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] files = f.listFiles(textFilter);
        String[] failideNimed = new String[files.length];


        Scanner scan = new Scanner(System.in);
        System.out.println("Sisestage Treening, kui te soovite hakata treeningkava täitma.");
        System.out.println("Sisestage Treeningkava, kui te soovite hakata koostama treeningkava.");
        System.out.print("Sisestage valik: ");
        String valik = scan.next();

        while (!valik.toLowerCase().equals("treening") && !valik.toLowerCase().equals("treeningkava")) {
            System.out.println("Palun valige treening, või treeningkava.");
            System.out.print("Sisestage valik: ");
            valik = scan.next();
        }

        if (valik.toLowerCase().equals("treening")) {
            System.out.println("Palun valige treeningkava: ");
            int i = 0;
            for (File file : files) {
                System.out.println("    " + file.getName());
                failideNimed[i] = file.getName();
                i++;
            }

            System.out.print("Sisestage valik: ");
            String treeningkava = scan.next();

            while (!Arrays.asList(failideNimed).contains(treeningkava)) {
                System.out.println("Sellist treeningkava ei eksisteeri, palun valige järgnevate treeningkavade vahelt:");
                for (String nimi : failideNimed) {
                    System.out.println("    " + nimi);
                }
                System.out.print("Sisestage valik: ");
                scan.nextLine();
                treeningkava = scan.next();
            }

            Treeningkava HarjutusteList = Lugeja.loeFailist("C:\\Users\\Siim\\IdeaProjects\\ProgeProjekt\\src\\" + treeningkava);
            List<Harjutus> Harjutused = HarjutusteList.getHarjutused();

            System.out.println("Valige harjutus: ");

            for (Harjutus harjutus : Harjutused) {
                System.out.println("    " + harjutus.getNimi());
            }

            System.out.print("   ");

            String harjutus = scan.next();
            int kordaja = 0;

            for (int e = 0; e < Harjutused.size(); e++) {
                if (harjutus.equals(Harjutused.get(e).getNimi())) {
                    kordaja = e;
                }
                System.out.println(Harjutused.get(e).getClass());
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String alguskuupäev = dateFormat.format(date);
            System.out.println(alguskuupäev);

            Lugeja.loeFaili("C:\\Users\\Siim\\IdeaProjects\\ProgeProjekt\\src\\" + HarjutusteList.getNimi() + "-" + alguskuupäev.substring(0, 10).replace("/", ".") + ".txt", HarjutusteList);
        }
       else{
            List<Harjutus> UuedHarjutused = new ArrayList<>();
            System.out.print("Sisestage palun treeningkava nimi: ");
            //NexLine-il tuli probleeme Next-iga, seega panen ühe tühja nextline-i vahele
            scan.nextLine();
            String TreeningkavaNimi = scan.nextLine();
            String lõpp = "";
            while (!lõpp.equals("KÕIK")) {
                System.out.print("Kas harjutus on jõu- või kestvusharjutus?: ");
                String tüüp = scan.next();
                while (!tüüp.equals("jõuharjutus") && !tüüp.equals("kestvusharjutus")) {
                    System.out.println("Palun valige harjutuse tüübiks, kas jõu- või kestvusharjutus.");
                    tüüp = scan.next();
                }
                if (tüüp.equals("jõuharjutus")) {
                    scan.nextLine();
                    System.out.print("Sisestage harjutuse nimi: ");
                    String harjutus = scan.nextLine();
                    System.out.print("Sisestage harjutuse seeriate arv: ");
                    int seeriad = scan.nextInt();
                    System.out.print("Sisestage harjutuse korduste arv: ");
                    int kordused = scan.nextInt();
                    UuedHarjutused.add(new JõuHarjutus(harjutus, seeriad, kordused, "0"));
                } else {
                    System.out.print("Sisestage harjutuse nimi: ");
                    String harjutus = scan.next();
                    System.out.print("Sisestage harjutuse kiirus: ");
                    double kiirus = scan.nextInt();
                    System.out.print("Sisestage harjutuse vahemik: ");
                    double vahemik = scan.nextInt();
                    UuedHarjutused.add(new KestvusHarjutus(harjutus, kiirus, vahemik));
                }
                System.out.println("Kui soovite lõpetada, siis kirjutage KÕIK, kui soovite lisada uusi harjutusi, vajutage ENTER.");
                lõpp = scan.nextLine();
                lõpp = scan.nextLine();
            }
            Treeningkava uus = new Treeningkava(TreeningkavaNimi, UuedHarjutused);

            Lugeja.loeFaili("C:\\Users\\Siim\\IdeaProjects\\ProgeProjekt\\src\\" + TreeningkavaNimi + ".txt", uus);

        }
    }
}

