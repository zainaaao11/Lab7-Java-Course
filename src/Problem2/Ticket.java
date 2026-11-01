package Problem2;
import java.lang.Override;

class Ticket implements ITicket{
    private int Id;
    private String Name;
    private Category category;
    private int Point;
    private String AssignedEmployee;
    private boolean IsCompleted;
    public Ticket(int id, String name, Category category, int point){
        Id=id;
        Name=name;
        this.category=category;
        Point=point;
    }
    @Override
    public void setId(int id){
        Id=id;
    }
    @Override
    public int getId(){
        return Id;
    }
    @Override
    public void setName(String name){
        Name=name;
    }
    @Override
    public String getName(){
        return Name;
    }
    @Override
    public void setCategory(Category category){
        this.category=category;
    }
    @Override
    public Category getCategory(){
        return this.category;
    }
    @Override
    public void setPoint(int point){
        Point=point;
    }
    @Override
    public int getPoint(){
        return Point;
    }
    @Override
    public void setIsCompleted(boolean isCompleted){
        IsCompleted=isCompleted;
    }
    @Override
    public boolean getIsCompleted(){
        return IsCompleted;
    }
    @Override
    public void setAssignedEmployee(String assignedEmployee){
        AssignedEmployee=assignedEmployee;
    }
    @Override
    public String getAssignedEmployee(){
        return AssignedEmployee;
    }
}