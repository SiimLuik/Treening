public abstract class Harjutus {
    private String nimi;

    public Harjutus(String nimi){
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public abstract void tühjendaAndmed();
}
