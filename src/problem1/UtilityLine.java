package problem1;

import java.lang.Override;
import java.util.LinkedList;

public class UtilityLine implements Mappable{
    private String name;
    private UtilityType type;
    private Color color;
    private LineMarkers lineMarkers;
    public UtilityLine(String name, UtilityType type,Color color, LineMarkers lineMarkers){
        this.name=name;
        this.type=type;
        this.color=color;
        this.lineMarkers=lineMarkers;
    }
    @Override
    public Geometry getShape(){
        return Geometry.LINE;
    }
    @Override
    public String getLabel(){
        return String.format("%s (%s)", this.name, String.valueOf(this.type));
    }
    @Override
    public String getMarker(){
        return String.format("%s %s", String.valueOf(this.color), String.valueOf(this.lineMarkers));
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
