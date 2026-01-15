import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private int nextMemberId = 1;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn) {
        // Simple duplicate check by ISBN
        if (findBookByIsbn(isbn) != null) {
            System.out.println("Book with ISBN " + isbn + " already exists!");
            return;
        }
        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    public void registerMember(String name, int type) {
        String id = "M" + String.format("%03d", nextMemberId++);
        Member member;
        if (type == 1) {
            member = new StudentMember(name, id);
        } else {
            member = new FacultyMember(name, id);
        }
        members.add(member);
        System.out.println((type == 1 ? "Student" : "Faculty") + " Member registered! ID: " + id +
                " (Max books: " + member.getMaxBooks() + ")");
    }

    public void issueBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed!");
            return;
        }
        if (!member.canBorrowMore()) {
            System.out.println("Member has reached borrow limit!");
            return;
        }

        book.issue(memberId);
        member.borrowBook(book);
        System.out.println("Book issued successfully to " + member.getName() + "!");
    }

    public void returnBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid book or member!");
            return;
        }
        if (book.isAvailable() || !book.getBorrowedBy().equals(memberId)) {
            System.out.println("This book wasn't borrowed by this member!");
            return;
        }

        book.returnBook();
        member.returnBook(book);
        System.out.println("Book returned successfully!");
    }

    public void searchBook(String query) {
        System.out.println("\n=== Search Results ===");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found.");
        System.out.println("======================\n");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library yet.");
            return;
        }
        System.out.println("\n=== All Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("=================\n");
    }

    public void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        System.out.println("\n=== All Members ===");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("===================\n");
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    private Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getMemberId().equals(id)) return member;
        }
        return null;
    }
}