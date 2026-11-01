package problem1;
import java.lang.Override;

public class Building implements Mappable{
    private String name;
    private UsageType type;
    private Color color;
    private PointMarkers pointMarkers;
    public Building(String name, UsageType type,Color color, PointMarkers pointMarkers){
        this.name=name;
        this.type=type;
        this.color=color;
        this.pointMarkers=pointMarkers;
    }
    @Override
    public Geometry getShape(){
        return Geometry.POINT;
    }
    @Override
    public String getLabel(){
        return String.format("%s (%s)", this.name, this.type);
    }
    @Override
    public String getMarker(){
        return String.format("%s %s", this.color, this.pointMarkers);
    }
    @Override
    public String toJSON(){
        String str =String.format("""
                "name": "%s",
                "usage": "%s"
                """, this.name, this.type);
        String rest=String.format("""
                "type": "%s", "label": "%s", "marker": "%s", %s
                """, getShape(), getLabel(), getMarker(), str);
        return String.format(JSON_PROPERTY, rest);
    }
}
