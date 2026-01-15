import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Library Management System!");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member (1=Student, 2=Faculty)");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. View All Books");
            System.out.println("7. View All Members");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = getInt(sc);
            if (choice == 8) {
                System.out.println("Thank you for using the system!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    library.addBook(title, author, isbn);
                    break;
                case 2:
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    System.out.print("Choose Type (1=Student, 2=Faculty): ");
                    int type = getInt(sc);
                    if (type == 1 || type == 2) {
                        library.registerMember(name, type);
                    } else {
                        System.out.println("Invalid type!");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN to issue: ");
                    String issueIsbn = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    String issueMember = sc.nextLine();
                    library.issueBook(issueIsbn, issueMember);
                    break;
                case 4:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    String returnMember = sc.nextLine();
                    library.returnBook(returnIsbn, returnMember);
                    break;
                case 5:
                    System.out.print("Enter title or author to search: ");
                    String query = sc.nextLine();
                    library.searchBook(query);
                    break;
                case 6:
                    library.viewAllBooks();
                    break;
                case 7:
                    library.viewAllMembers();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }

    private static int getInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }
}