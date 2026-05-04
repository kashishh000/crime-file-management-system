import java.util.*;

class Complaint {
    int id;
    String name;
    String type;
    String status;

    Complaint(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = "Pending";
    }
}

public class CrimeFileManagement {
    static ArrayList<Complaint> complaints = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addComplaint() {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Crime Type: ");
        String type = sc.nextLine();

        complaints.add(new Complaint(id, name, type));
        System.out.println("Complaint Registered Successfully!");
    }

    public static void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        for (Complaint c : complaints) {
            System.out.println("\nID: " + c.id);
            System.out.println("Name: " + c.name);
            System.out.println("Type: " + c.type);
            System.out.println("Status: " + c.status);
        }
    }

    public static void updateStatus() {
        System.out.print("Enter Complaint ID to update: ");
        int id = sc.nextInt();

        for (Complaint c : complaints) {
            if (c.id == id) {
                sc.nextLine();
                System.out.print("Enter new status (In Process / Resolved): ");
                c.status = sc.nextLine();
                System.out.println("Status updated!");
                return;
            }
        }

        System.out.println("Complaint not found.");
    }

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\n===== Crime File Management System =====");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addComplaint();
                    break;
                case 2:
                    viewComplaints();
                    break;
                case 3:
                    updateStatus();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
