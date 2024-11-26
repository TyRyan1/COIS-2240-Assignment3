import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	
	
	private static Transaction transaction;//instance of class
	private Transaction() {}//private constructor
	
	public static Transaction getTransaction() {
		if(transaction == null) {
			transaction = new Transaction();
		}
		return transaction;
	}
	

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    //save a transaction
    private void saveTransaction(String details){
    	try {
    	PrintWriter out = new PrintWriter(new FileWriter("src/transactions.txt",true));
    	out.println(details);
    	out.close();
    	}
    	catch(FileNotFoundException e) {
    		System.out.println("Transactions file not found");
    	}
    	catch (IOException e) {
    		System.err.println("could not find file");
    	}

    }
    
    //display the transaction history
    public void displayTransactionHistory() {
    	BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new FileReader("src/transactions.txt"));
    		String line;
    		 while ((line = reader.readLine()) != null) {
                 System.out.println(line);
    		 }
    	}
    	catch (IOException e) {
    		System.err.println("could not read file");
    	}
    }
    
}

