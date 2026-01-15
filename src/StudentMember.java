public class StudentMember extends Member {
    public StudentMember(String name, String memberId) {
        super(name, memberId, 5); // Students can borrow max 5 books
    }
}