import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class LibraryManagementTest {

	
	
	@Test
	public void testBookID(){
		try {
			Book a = new Book(100, "Math");
			Book b = new Book(999, "Sci");
			Book c = new Book(1000, "Bio");
			fail("could not add book");
			
			//check getId Method
			assertEquals(100, a.getId());
			assertEquals(999, b.getId());
			assertEquals(1000, c.getId());
			
			//check getTitle Method
			assertEquals("Math", a.getTitle());
			assertEquals("Sci", b.getTitle());
			assertEquals("Sci", c.getTitle());
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}

	}
}
