import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class LibraryManagementTest {

	@Test
	public void testBookID(){
		try {
			Book a = new Book(100, "Math");
			Book b = new Book(999, "Sci");
			Book c = new Book(1000, "Bio");
			
			
			//check getId Method
			assertEquals(100, a.getId());
			assertEquals(999, b.getId());
			assertEquals(1000, c.getId());
			
			//check getTitle Method
			assertEquals("Math", a.getTitle());
			assertEquals("Sci", b.getTitle());
			assertEquals("Eng", c.getTitle());
		}
		catch(Exception e){
			fail("could not add book");
		}

	}
	@Test
	public void testBorrowReturn(){
		try {
			Book newBook = new Book(200, "X");
			Member newMember = new Member(3000,"Ty");
			

			assertTrue("Book is unavailable",newBook.isAvailable());//Check if book is available
			
			assertTrue(Transaction.getTransaction().borrowBook(newBook,newMember));//check if user can borrow a book	

			assertFalse("Book is available",newBook.isAvailable()); //Check if book is unavailable
			
			assertFalse(Transaction.getTransaction().borrowBook(newBook,newMember));//check if user can borrow a book twice
		
			assertTrue(Transaction.getTransaction().returnBook(newBook,newMember));//check if book can be returned
	
			assertTrue("Transaction not completed",newBook.isAvailable());//check if book is available
			
			assertFalse(Transaction.getTransaction().returnBook(newBook,newMember));//check if book can be returned twice
		
		} catch (Exception e) {
			fail("ERROR");	
			}
		
	}
	@Test
	public void testSingletonTransaction(){
		try {
		Constructor<Transaction> constructor = Transaction.class.getDeclaredConstructor();
		int actual = constructor.getModifiers();
		int expected = Modifier.PRIVATE;
				
		assertEquals(expected, actual);
		}
		catch(Exception e){
			fail("ERROR");
		}
	}
	
}
