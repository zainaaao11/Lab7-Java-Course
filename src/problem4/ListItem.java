package problem4;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;
    public ListItem(Object val){ value=val; }
    protected abstract ListItem next();
    protected abstract ListItem setNext(ListItem right);
    protected abstract ListItem previous();
    protected abstract ListItem setPrevious(ListItem left);
    protected abstract int compareTo(ListItem lstItem);
}
