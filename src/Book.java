
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    private String borrowedBy; // Member ID or null

    public Book(String title, String author, String isbn) {
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.available = true;
        this.borrowedBy = null;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return available; }
    public String getBorrowedBy() { return borrowedBy; }

    // Methods
    public void issue(String memberId) {
        this.available = false;
        this.borrowedBy = memberId;
    }

    public void returnBook() {
        this.available = true;
        this.borrowedBy = null;
    }

    @Override
    public String toString() {
        String status = available ? "[AVAILABLE]" : "[BORROWED by " + borrowedBy + "]";
        return status + " " + title + " by " + author + " (ISBN: " + isbn + ")";
    }
}