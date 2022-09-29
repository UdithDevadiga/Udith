package com.robosoft.collectionclassexample.Service;
import java.util.HashSet;
import com.robosoft.collectionclassexample.modal.Book;
public interface BookService {
        HashSet<Book> findAllBook();
        Book findBookByID(long id);
        void addBook(Book b);
        void deleteAllData();
}
