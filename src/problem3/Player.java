package problem3;
import java.util.*;
import java.lang.Override;

public class Player implements ISaveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;
    public Player(String name, int hitPoints, int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        weapon="Sword";
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){ this.name=name; }
    public String getWeapon(){
        return this.weapon;
    }
    public void setWeapon(String weapon){ this.weapon=weapon; }
    public int getHitPoints(){
        return this.hitPoints;
    }
    public void setHitPoints(int hitPoints){ this.hitPoints= hitPoints; }
    public int getStrength(){
        return this.strength;
    }
    public void setStrength(int strength){ this.strength= strength; }
    @Override
    public List<String> write(){
        List<String> lst=List.of(this.name, String.valueOf(this.hitPoints), String.valueOf(this.strength), String.valueOf(this.weapon));
        return lst;
    }
    @Override
    public void read(List<String> lst){
        if (lst!=null && lst.size()>0){
            Collections.addAll(lst, this.name, String.valueOf(this.hitPoints), String.valueOf(this.strength), String.valueOf(this.weapon));
        }
    }
    @Override
    public String toString(){
        return String.format("Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'", this.name, this.hitPoints, this.strength, this.weapon);
    }
}
