package problem4;
import java.lang.Override;
public class MyLinkedList implements NodeList{
    private ListItem root;
    public MyLinkedList(ListItem root){ this.root=root; }
    @Override
    public ListItem getRoot(){ return this.root; }
    @Override
    public boolean addItem(ListItem node){
        ListItem current=this.root;
        if (this.root==null){
            this.root=node;
            return true;
        }
        while (current!=null){
            if (node.compareTo(current)==0){
                return false;
            }
            if (node.compareTo(current)<0){
                ListItem prev=current.previous();
                if (prev!=null){
                    prev.setNext(node);
                    node.setNext(current);
                    current.setPrevious(node);
                    node.setPrevious(prev);
                    return true;
                }
                current.setPrevious(node);
                node.setNext(current);
                this.root=node;
                return true;
            }
            if (node.compareTo(current)>0){
                ListItem next=current.next();
                if (next==null){
                    current.setNext(node);
                    node.setPrevious(current);
                    return true;
                }
                current=current.next();
            }
        }
        return false;
    }
    @Override
    public boolean removeItem(ListItem item){
        ListItem curr=this.root;
        //If the tree is already empty, there is nothing to remove
        if (curr==null){
            return false;
        }
        while (curr!=null){
            if (item.compareTo(curr)==0){
                if (curr.next()==null && curr.previous()==null){
                    this.root=null;
                    return true;
                }
                if(curr.next()==null){
                    curr.previous().setNext(null);
                    return true;
                }
                if (curr.previous()==null){
                    curr.next().setPrevious(null);
                    this.root=curr.next();
                    return true;
                }
                else{
                    curr.previous().setNext(curr.next());
                    curr.next().setPrevious(curr.previous());
                    return true;
                }
            }
            else if (item.compareTo(curr)>0){
                curr=curr.next();
            }
            else if (item.compareTo(curr)<0){
                return false;
            }
        }
        return false;
    }
    @Override
    public void traverse(ListItem root){
        ListItem current=root;
        if (current==null) System.out.println("The list is empty");
        while (current!=null){
            System.out.println(current.value);
            current=current.next();
        }
    }
}
