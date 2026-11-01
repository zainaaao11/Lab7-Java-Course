package problem4;
import java.lang.Override;
import java.lang.Comparable;
public class Node extends ListItem{
    public Node(Object value){ super(value); }
    @Override
    protected ListItem next() {return this.rightLink; }
    @Override
    protected ListItem setNext(ListItem right){
        ListItem temp=this.rightLink;
        this.rightLink=right;
        return temp;
    }
    @Override
    protected ListItem previous(){ return this.leftLink; }
    @Override
    protected ListItem setPrevious(ListItem left){
        ListItem temp=this.leftLink;
        this.leftLink=left;
        return temp;
    }
    @Override
    protected int compareTo(ListItem another){
        return ((Comparable<Object>) this.value).compareTo(another.value);
    }
}
