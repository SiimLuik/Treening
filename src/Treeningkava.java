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

    public void taastaAlgseis(){
        //andmete puhastamiseks
        for(Harjutus harjutus:harjutused)
            harjutus.tühjendaAndmed();
    }
}
