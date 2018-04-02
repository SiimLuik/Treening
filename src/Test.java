public class Test {
    public static void main(String[] args) throws Exception{
        Treeningkava a = Lugeja.loeFailist("treeningA.txt");
        Lugeja.loeFaili("test.txt", a);
        Treeningkava b = Lugeja.loeFailist("test.txt");
        for(Harjutus harjutus:b.getHarjutused())
            System.out.println(harjutus);
    }
}
