package Problem2;
import java.util.ArrayList;
import java.util.List;
import java.lang.Override;

class HelpDesk implements IHelpDesk{
    private List<IEmployee> Employees;
    private List<ITicket> Tickets;
    public HelpDesk(){
        Employees=new ArrayList<>();
        Tickets=new ArrayList<>();
    }
    @Override
    public void addTicket(ITicket ticket){ Tickets.add(ticket); }
    @Override
    public void addEmployee(IEmployee employee){
        Employees.add(employee);
    }
    @Override
    public void completeTicket(String employeeFullName, int ticketId){
        for (IEmployee e: Employees){
            if (e.getFullName().equalsIgnoreCase(employeeFullName)){
                for (ITicket t: Tickets){
                    if (t.getId()==ticketId){
                        if (e.getPointLevel()>=t.getPoint()){
                            t.setIsCompleted(true);
                        }
                        //else t.setIsCompleted(false);
                        return;
                    }
                }
            }
        }
    }
    @Override
    public int getWaitingTicketCount(){
        int count=0;
        for (ITicket t: Tickets){
            if (!(t.getIsCompleted())) count++;
        }
        return count;
    }
    @Override
    public int getCompletedTicketsTotalPoint(){
        int sum=0;
        for (ITicket t: Tickets){
            if (t.getIsCompleted()) sum+=t.getPoint();
        }
        return sum;
    }
    @Override
    public List <CategoryNode> getTicketsTotalPointByCategory(){
        List<Category> categories=List.of(Category.InformationTechnologies, Category.HumanResources, Category.Accounting, Category.Sales, Category.Marketing, Category.Legal);
        List<CategoryNode> nodes=new ArrayList<>();
        for (Category c: categories){
            nodes.add(new CategoryNode(c, getTotalPointsPerCategory(c)));
        }
        return nodes;
    }
    //helper method to get the total points per category
    private int getTotalPointsPerCategory(Category category){
        int totalPoints=0;
        for (ITicket t: Tickets){
            if (t.getCategory()==category){
                totalPoints+=t.getPoint();
            }
        }
        return totalPoints;
    }
    @Override
    public List<EmployeeNode> getTicketsTotalPointByEmployee(){
        List<EmployeeNode> node=new ArrayList<>();
        for (IEmployee e: Employees){
            node.add(new EmployeeNode(e, e.getPointLevel()));
        }
        return node;
    }

}