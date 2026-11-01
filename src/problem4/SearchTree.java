package problem4;
import java.lang.Override;
public class SearchTree implements NodeList{
    ListItem root;
    public SearchTree(ListItem root){
        this.root=root;
    }
    @Override
    public ListItem getRoot(){
        return this.root;
    }
    @Override
    public boolean addItem(ListItem item){
        ListItem curr=this.root;
        if (item==null){
            return false;
        }
        if (curr==null){
            this.root=item;
            return true;
        }
        while (curr!=null){
            int comparaison=item.compareTo(curr);
            if (comparaison>0){
                if (curr.next()==null){
                    curr.setNext(item);
                    return true;
                }
                else {
                    curr=curr.next();
                }
            }
            else if (comparaison<0){
                if (curr.previous()==null){
                    curr.setPrevious(item);
                    return true;
                }
                else{
                    curr=curr.previous();
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean removeItem(ListItem item){
        ListItem curr=this.root;
        ListItem parent=null;
        if (item==null){
            return false;
        }
        if (curr==null){
            return false;
        }
        while (curr!=null){
            if (curr.compareTo(item)==0){
                performRemoval(parent, curr);
                return true;
            }
            else if (item.compareTo(curr)>0){
                parent=curr;
                curr=curr.next();
            }
            else{
                parent=curr;
                curr=curr.previous();
            }
        }
        return false;
    }
    private void performRemoval(ListItem parent, ListItem node) {
        ListItem replacement = null;
        if (node.previous() == null && node.next() == null) {
            replacement = null;
        }
        else if (node.previous() != null && node.next() != null) {
            ListItem smallest = node.next();
            ListItem smallestParent = node;
            while (smallest.previous() != null) {
                smallestParent = smallest;
                smallest = smallest.previous();
            }
            if (smallestParent != node) {
                smallestParent.setPrevious(smallest.next());
                smallest.setNext(node.next());
            }
            smallest.setPrevious(node.previous());
            replacement = smallest;
        }
        else if (node.previous() != null) {
            replacement = node.previous();
        }
        else if (node.next() != null) {
            replacement = node.next();
        }
        if (parent == null) {
            this.root = replacement;
        }
        else if (parent.compareTo(node) > 0) {
            parent.setPrevious(replacement);
        }
        else {
            parent.setNext(replacement);
        }
    }
    @Override
    public void traverse(ListItem root){
        if (root==null){
            return;
        }
        traverse(root.previous());
        System.out.println(root.value);
        traverse(root.next());
    }
}
