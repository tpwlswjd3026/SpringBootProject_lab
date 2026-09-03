package com.rookies6.myspringbootlab.repository;


import com.rookies6.myspringbootlab.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book("스프링 부트 입문", "홍길동", "9788956746425", 30000,
                LocalDate.of(2025, 5, 7) );
        book2 = new Book("JPA 프로그래밍", "박둘리", "9788956746432", 35000,
                LocalDate.of(2025, 4, 30) );
    }

    @Test
    void testCreateBook(){
        Book savedBook = bookRepository.save(book1);
        assertNotNull(savedBook.getId());
        assertEquals("스프링 부트 입문", savedBook.getTitle());

    }

    @Test
    void testFindByIsbn(){
        bookRepository.save(book1);
        Optional<Book> foundBook = bookRepository.findByIsbn("9788956746425");
        assertTrue(foundBook.isPresent());
        assertEquals("스프링 부트 입문", foundBook.get().getTitle());
    }

    @Test
    void testFindByAuthor(){
        bookRepository.save(book1);
        bookRepository.save(book2);
        List<Book> foundAuthor = bookRepository.findByAuthor("홍길동");

        assertEquals(1, foundAuthor.size());
        assertEquals("스프링 부트 입문", foundAuthor.get(0).getTitle());


    }

    @Test
    void testUpdateBook(){
        Book updatedBook = bookRepository.save(book1);

        updatedBook.setPrice(50000);
        bookRepository.save(updatedBook);

        Optional<Book> result = bookRepository.findById(updatedBook.getId());
        assertEquals(50000, result.get().getPrice());

    }

    @Test
    void testDeleteBook(){
        Book deletedBook = bookRepository.save(book1);

        bookRepository.deleteById(deletedBook.getId());

        Optional<Book> result = bookRepository.findById(deletedBook.getId());
        assertTrue(result.isEmpty());

    }
}
