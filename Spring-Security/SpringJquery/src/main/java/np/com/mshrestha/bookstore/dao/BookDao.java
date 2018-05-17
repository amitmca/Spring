package np.com.mshrestha.bookstore.dao;

import java.util.List;
import np.com.mshrestha.bookstore.model.Book;

public interface BookDao {
	public void saveBook(Book book); 
	public List<Book> listBooks();
	public Book getBook(Long id);
	public void deleteBook(Long id);
}
