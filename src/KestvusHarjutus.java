public class KestvusHarjutus extends Harjutus{
    private double kiirus;
    private double vahemik;

    public void setVahemik(double vahemik) {
        this.vahemik = vahemik;
    }

    public KestvusHarjutus(String nimi, double kiirus){
        super(nimi);
        this.kiirus = kiirus;
    }

    @Override
    public void tühjendaAndmed(){
        vahemik = 0f;
    }

    @Override
    public String toString() {
        String vahemaa = "";
        if(vahemik != 0f)
            vahemaa = Double.toString(vahemik);
        return getNimi() + ";" + kiirus + ";" + vahemaa;
    }
}
