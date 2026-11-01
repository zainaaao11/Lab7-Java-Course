package Problem2;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int userChoice;
        do{
            System.out.println("====Menu====");
            System.out.println("1: Proceed the operation\n0: Exit");
            userChoice=scan.nextInt();
            scan.nextLine(); //to consume the newLine put into the buffer by nextInt()
            switch (userChoice){
                case 0:
                    break;
                case 1:
                    HelpDesk helpDesk=new HelpDesk();
                    System.out.println("Enter the number of employees:");
                    int n=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter each employee's information in the following format: (FullName, PointLevel, AssignedCategories)");
                    List<Category> assignedCategories=new ArrayList<>();
                    for (int i=0; i<n; i++){
                        String[] line=scan.nextLine().split(", ");
                        Employee employee=new Employee(line[0], Integer.parseInt(line[1]));
                        for (int j=2; j<line.length; j++){
                            assignedCategories.add(Category.valueOf(line[j]));
                        }
                        employee.setAssignedCategories(assignedCategories);
                        helpDesk.addEmployee(employee);
                    }
                    System.out.println("Enter the number of tickets: ");
                    int m=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter each ticket's infos in the following format: (Id, Name, Category, Point)");
                    for (int k=0; k<m; k++){
                        String[] line=scan.nextLine().split(", ");
                        ITicket ticket=new Ticket(Integer.parseInt(line[0]), line[1], Category.valueOf(line[2]), Integer.parseInt(line[3]));
                        helpDesk.addTicket(ticket);
                    }
                    System.out.println("Enter the number of CompleteTicket calls:");
                    int k=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter the process for ticket completion in the format (Employee FullName, Ticket Id):");
                    for (int i=0; i<k; i++){
                        String[] line=scan.nextLine().split(", ");
                        helpDesk.completeTicket(line[0], Integer.parseInt(line[1]));
                    }
                    System.out.println("WaitingTicketCount: "+ helpDesk.getWaitingTicketCount());
                    System.out.println("CompletedTicketsTotalPoint: "+helpDesk.getCompletedTicketsTotalPoint());
                    System.out.println("TicketsTotalPointByCategory:");
                    List<CategoryNode> categoryNodes=helpDesk.getTicketsTotalPointByCategory();
                    for (int j=0; j<categoryNodes.size(); j++){
                        CategoryNode catNode=categoryNodes.get(j);
                        System.out.println(catNode.category+" : "+catNode.totalPoint);
                    }
                    System.out.println("TicketsTotalPointByEmployee: ");
                    List<EmployeeNode> employeeNodes=helpDesk.getTicketsTotalPointByEmployee();
                    for (int i=0; i<employeeNodes.size(); i++){
                        EmployeeNode empNode=employeeNodes.get(i);
                        System.out.println(empNode.employee.getFullName()+" : "+empNode.totalPoint);
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        while (userChoice!=0);
    }
}
//John Doe, 1, HumanResources, InformationTechnologies
//Jane Cherry, 6, Legal, InformationTechnologies
//1, Ticket1, InformationTechnologies, 1
//2, Ticket2, HumanResources, 5
//3, Ticket3, Legal, 2
//John Doe, 3
//John Doe, 1
//Jane Cherry, 2
//Jane Cherry, 3
