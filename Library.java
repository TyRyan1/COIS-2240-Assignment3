import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    // I did not use the findMemberById method because it seemed over complicated and inefficient.
    //the assignment stated that we MAY use these methods, so I assumed that means they are optional
    public boolean addMember(Member member) {
    	for (Member i : members) {
    		if (i.getId() == member.getId()) {   			
    			return true;
    		}
    	}
        members.add(member);
    	return false;
    }
    
    // Add a new book to the library
    public boolean addBook(Book book) {
    	for (Book i : books) {
    		if (i.getId() == book.getId()){
    			return true;
    		}	
    	}
    	books.add(book);
    	return false; 
        
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
