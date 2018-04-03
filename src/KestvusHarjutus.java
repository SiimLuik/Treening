public class KestvusHarjutus extends Harjutus{
    private double kiirus;
    private Double vahemik;

    public void setVahemik(double vahemik) {
        this.vahemik = vahemik;
    }

    public KestvusHarjutus(String nimi, double kiirus, Double vahemik){
        super(nimi);
        this.kiirus = kiirus;
        this.vahemik = vahemik;
    }

    public double getKiirus() {
        return kiirus;
    }

    public Double getVahemik() {
        return vahemik;
    }

    @Override
    public void tühjendaAndmed(){
        vahemik = null;
    }

    @Override
    public String toString() {
        String strVahemik = "";
        if(vahemik != null)
            strVahemik = Double.toString(vahemik);
        return getNimi() + ";" + kiirus + ";" + strVahemik + ";";
    }
}
