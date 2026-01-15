public class FacultyMember extends Member {
    public FacultyMember(String name, String memberId) {
        super(name, memberId, 10); // Faculty can borrow max 10 books
    }
}