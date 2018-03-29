import java.util.ArrayList;
import java.util.List;

public class JõuHarjutus extends Harjutus{

    private List<Integer> kaalud;
    private int sets;
    private int reps;

    public void lisaKaal(int kaal){
        //igaks juhuks vaatab üle, kas kaalud on täis, kava koostamisel peaks uuesti üle vaatama
        if(!täis())
            kaalud.add(kaal);
    }

    public JõuHarjutus(String nimi, int sets, int reps){
        super(nimi);
        this.sets = sets;
        this.reps = reps;
        //kaalud sisaldavad iga repi kaalu, Listi ja repi võrdlemisega saab teada kui kaugele täidetud
        kaalud = new ArrayList<>();
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
        String kaals = "";
        for(int kaal:kaalud)
            kaals += kaal + "|";
        return getNimi() + ";" + sets + ";" + reps + ";" + kaals;
    }
}
