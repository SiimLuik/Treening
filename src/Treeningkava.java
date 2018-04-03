import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Treeningkava {
    private String nimi;
    private List<Harjutus> harjutused;

    public String getNimi() {
        return nimi;
    }

    public List<Harjutus> getHarjutused() {
        return harjutused;
    }

    public void setHarjutused(List<Harjutus> harjutused) {
        this.harjutused = harjutused;
    }

    public Treeningkava(String nimi, List<Harjutus> harjutused) {
        this.nimi = nimi;
        this.harjutused = harjutused;
    }

    public static Treeningkava deepcopy(Treeningkava treeningkava){
        //deepcopy, kuna harjutused on listid, ning jõuharjutustel on kaalud listis
        List<Harjutus> harjutused = new ArrayList<>();
        for(Harjutus h: treeningkava.getHarjutused()) {
            if(h instanceof JõuHarjutus)
                harjutused.add(new JõuHarjutus(h.getNimi(), ((JõuHarjutus) h).getSets(), ((JõuHarjutus) h).getReps(), ((JõuHarjutus) h).kaaludString()));
            else if(h instanceof KestvusHarjutus)
                harjutused.add(new KestvusHarjutus(h.getNimi(), ((KestvusHarjutus) h).getKiirus(), ((KestvusHarjutus) h).getVahemik()));
        }
        return new Treeningkava(treeningkava.getNimi(), harjutused);
    }

    public void taastaAlgseis(){
        //andmete puhastamiseks
        for(Harjutus harjutus:harjutused)
            harjutus.tühjendaAndmed();
    }
}
