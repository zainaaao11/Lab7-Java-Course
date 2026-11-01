package Problem2;
import java.util.ArrayList;
import java.util.List;
import java.lang.Override;
public class Employee implements IEmployee{
    private String FullName;
    private int PointLevel;
    List<Category> AssignedCategories;
    public Employee(String FullName, int PointLevel){
        this.FullName=FullName;
        this.PointLevel=PointLevel;
        AssignedCategories=new ArrayList<>();
    }
    @Override
    public void setFullName(String fullName){
        FullName=fullName;
    }
    @Override
    public String getFullName(){
        return FullName;
    }
    @Override
    public void setPointLevel(int pointLevel){
        PointLevel=pointLevel;
    }
    @Override
    public int getPointLevel(){
        return PointLevel;
    }
    @Override
    public void setAssignedCategories(List<Category> assignedCategories){
        AssignedCategories=assignedCategories;
    }
    @Override
    public List<Category> getAssignedCategories(){
        return AssignedCategories;
    }
}
