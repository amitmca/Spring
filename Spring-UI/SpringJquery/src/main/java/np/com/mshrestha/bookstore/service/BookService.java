package np.com.mshrestha.bookstore.service;

import java.util.List;

import np.com.mshrestha.bookstore.model.Book;

public interface BookService {

	public void saveBook(Book book);
	public List<Book> listBooks();
	public Book getBook(Long id);
	public void deleteBook(Long id);

}
