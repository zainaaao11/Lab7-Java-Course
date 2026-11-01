package problem1;

public class Test {
    public static void main(String[] args) {
        Building b1 = new Building("Sydney Town Hall", UsageType.BUSINESS, Color.RED, PointMarkers.STAR);
        UtilityLine u1 = new UtilityLine("College Street", UtilityType.FIBER_OPTIC, Color.GREEN, LineMarkers.DOTTED);
        System.out.println("=== toJSON() ===");
        System.out.println(b1.toJSON());
        System.out.println(u1.toJSON());
        System.out.println("\n=== mapIt() ===");
        Mappable.mapIt(b1);
        Mappable.mapIt(u1);
        System.out.println("\n=== Polymorphism ===");
        Mappable[] objects = {b1, u1};
        for (Mappable obj : objects) {
            Mappable.mapIt(obj);
        }
    }
}
