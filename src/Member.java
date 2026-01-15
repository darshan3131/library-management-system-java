import java.util.ArrayList;

public abstract class Member {
    protected String name;
    protected String memberId;
    protected ArrayList<Book> borrowedBooks;
    protected int maxBooks;

    public Member(String name, String memberId, int maxBooks) {
        this.name = name.trim();
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.maxBooks = maxBooks;
    }

    // Getters
    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
    public int getMaxBooks() { return maxBooks; }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < maxBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ") | Borrowed: " + borrowedBooks.size() + "/" + maxBooks;
    }
}