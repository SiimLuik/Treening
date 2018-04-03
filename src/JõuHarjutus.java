import java.util.ArrayList;
import java.util.List;

public class JõuHarjutus extends Harjutus{

    private List<Integer> kaalud = new ArrayList<>();
    private int sets;
    private int reps;

    public void lisaKaal(int kaal){
        //igaks juhuks vaatab üle, kas kaalud on täis, kava koostamisel peaks uuesti üle vaatama
        if(!täis())
            kaalud.add(kaal);
    }

    public JõuHarjutus(String nimi, int sets, int reps, String täidetudKaalud){
        super(nimi);
        this.sets = sets;
        this.reps = reps;
        //kaalud sisaldavad iga repi kaalu, Listi ja repi võrdlemisega saab teada kui kaugele täidetud
        if(täidetudKaalud != null && täidetudKaalud != "")
            for(String kaal:täidetudKaalud.split("/"))
                kaalud.add(Integer.parseInt(kaal));
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public List<Integer> getKaalud() {
        return kaalud;
    }

    public void setKaalud(List<Integer> kaalud) {
        this.kaalud = kaalud;
    }

    public String kaaludString() {
        String kaals = "";
        for(int kaal:kaalud)
            kaals += kaal + "/";
        return kaals;
    }

    @Override
    public void tühjendaAndmed(){
        //peale treeningkava täitmist
        kaalud = new ArrayList<>();
    }

    public boolean täis(){
        return reps <= kaalud.size();
    }

    @Override
    public String toString() {
        //sellisel kujul saab otse faili kirjutada
        return getNimi() + ";" + sets + ";" + reps + ";" + kaaludString() + ";";
    }
}
