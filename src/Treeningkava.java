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

    public Treeningkava(String nimi, List<Harjutus> harjutused) {
        this.nimi = nimi;
        this.harjutused = harjutused;
    }

    public void taastaAlgseis(){
        //kasutada peale faili kirjutamist
        for(Harjutus harjutus:harjutused)
            harjutus.tühjendaAndmed();
    }
}
