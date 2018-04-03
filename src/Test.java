public class Test {
    public static void main(String[] args) throws Exception{
        Treeningkava a = Lugeja.loeFailist("treeningA.txt");
        Treeningkava b = Lugeja.loeFailist("treeningB.txt");
        Treeningkava ab = Lugeja.areng(a, b);
        for(Harjutus harjutus:ab.getHarjutused())
            System.out.println(harjutus);
        System.out.println();
        for(Harjutus harjutus:a.getHarjutused())
            System.out.println(harjutus);
        System.out.println();
        for(Harjutus harjutus:b.getHarjutused())
            System.out.println(harjutus);
    }
}
