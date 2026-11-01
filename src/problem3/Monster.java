package problem3;

import java.util.Collections;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;
    public Monster(String name, int hitPoints, int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
    }
    public String getName(){ return this.name;}
    public int getHitPoints(){ return this.hitPoints; }
    public int getStrength(){return this.strength; }
    @Override
    public List<String> write(){
        List<String> lst=List.of(this.name, String.valueOf(this.hitPoints), String.valueOf(this.strength));
        return lst;
    }
    @Override
    public void read(List<String> lst){
        if (lst!=null && lst.size()>0){
            Collections.addAll(lst, this.name, String.valueOf(this.hitPoints), String.valueOf(this.strength));
        }
    }
    @Override
    public String toString(){
        return String.format("Monster{name='%s', hitPoints=%d, strength=%d", this.name, this.hitPoints, this.strength);
    }
}
