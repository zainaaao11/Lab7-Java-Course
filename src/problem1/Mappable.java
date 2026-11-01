package problem1;

public interface Mappable {
    String JSON_PROPERTY= """
            "properties": {%s}
            """;
    String getLabel();
    String getMarker();
    Geometry getShape();
    default String toJSON(){
        String rest=String.format("""
                "type": "%s", "label": "%s", "marker": "%s"
                """, getShape(), getLabel(), getMarker());
        return String.format(JSON_PROPERTY, rest);
    }
    static void mapIt(Mappable mappable){
        System.out.println(mappable.toJSON());
    }
}
