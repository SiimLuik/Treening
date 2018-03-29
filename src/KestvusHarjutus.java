public class KestvusHarjutus extends Harjutus{
    private double kiirus;
    private double vahemik;

    public void setVahemik(double vahemik) {
        this.vahemik = vahemik;
    }

    public KestvusHarjutus(String nimi, double kiirus, double vahemik){
        super(nimi);
        this.kiirus = kiirus;
        this.vahemik = vahemik;
    }

    @Override
    public void tühjendaAndmed(){
        vahemik = 0f;
    }

    @Override
    public String toString() {
        return getNimi() + ";" + kiirus + ";" + vahemik;
    }
}
