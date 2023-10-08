import org.junit.jupiter.api.Test;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookService;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class BookServiceTest {
    @Test
    public void findByIdTest(){
        // Arrange
        BookRepository bookRepositoryMock=mock(BookRepository.class);
        Book book1=new Book("1","Lord of the Ring","Tolkien");
        when(bookRepositoryMock.findById("1")).thenReturn(book1);
        BookService bookService=new BookService(bookRepositoryMock);
        // Act
        Book bookRes= bookService.findBookById("1");
        // assert
        assertEquals(book1,bookRes);
        verify(bookRepositoryMock, times(1)).findById("1");

    }

    @Test
    public void findAllBooksTest(){
        // Arrange
        BookRepository bookRepositoryMock=mock(BookRepository.class);
        Book book1=new Book("1","Lord of the Ring","Tolkien");
        Book book2=new Book("2","Alice in Wonderland ","Carrol");
        List<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookRepositoryMock.findAll()).thenReturn(books);
        BookService bookService=new BookService(bookRepositoryMock);
        // Act
        List<Book> booksRes= bookService.findAllBooks();
        // assert
        assertEquals(books,booksRes);
        verify(bookRepositoryMock, times(1)).findAll();

    }
}


