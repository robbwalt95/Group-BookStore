package com.example.bookStore.bootstrap;

import java.util.*;
import com.example.bookStore.domain.Author;
import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.Publisher;
import com.example.bookStore.repositories.AuthorRepository;
import com.example.bookStore.repositories.BookRepository;
import com.example.bookStore.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {





        //Book 1 publisher
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisherRepository.save(publisher);


        //Book 1 author
        Author eric = new Author("Eric", "Evans");

        //Book 1 title, genre, stock, cost
        Book ddd = new Book("Domain Driven Design", "Nonfiction", 1, 25.99);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        //save book 1
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        //book 2 author
        Author rod = new Author("Rod", "Johnson");

        //book 2 title, genre, stock, cost
        Book noEJB = new Book("J2EE Development without EJB", "Nonfiction", 0, 19.99);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        //save book 2
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        //Operation Helga
        String[] fName = {"Jaideva", "John", "Stephen", "Stephen", "Edward", "Vladimir", "V P", "Leonard", "Frank", "Maria", "Gutierrez"};
        String[] lName = {"Goswami", "Foreman", "Hawking", "Dubner", "Said", "Vapnik", "Menon", "Mlodinow", "Shih", "Konnikova", "Sebastian"};
        String[] genre = {"Signal Processing", "Data Science", "Mathematics", "Economics", "History", "Data Science", "History", "Science", "Signal Processing", "Psychology", "Data Science"};
        String[] title = {"Fundamentals of Wavelets", "Data Smart", "God Created the Integers", "Superfreakonomics", "Orientalism", "Nature of Statistical Learning Theory", "Integration of the Indian States", "Drunkard's Walk", "Image Processing & Mathematical Morphology", "How to Think Like Sherlock Holmes", "Data Scientists at Work"};
        String[] pub = {"Wiley", "Wiley", "Penguin", "HarperCollins", "Penguin", "Springer", "Orient Blackswan", "Penguin", "CRC", "Penguin", "Apress",};
        Double[] price = {10.99, 11.99, 12.99, 14.99, 15.99, 17.99, 18.99, 19.99, 21.99, 22.99, 23.99};
        Integer[] stock = {1, 1, 1, 0, 1, 2, 1, 0, 1, 1, 1};


        int count = 0;
        //iterate through the arrays
        while (count != 11){
            //book x set publisher
            Publisher bookXp = new Publisher();
            bookXp.setName(pub[count]);
            publisherRepository.save(bookXp);

            //book x set author
            Author bookXa = new Author(fName[count],lName[count]);

            //book x set title, genre, stock, and price
            Book bookXd = new Book(title[count], genre[count], stock[count], price[count]);
            bookXa.getBooks().add(bookXd);
            bookXd.getAuthors().add(bookXa);

            bookXd.setPublisher(bookXp);
            bookXp.getBooks().add(bookXd);

            //save book x
            authorRepository.save(bookXa);
            bookRepository.save(bookXd);
            publisherRepository.save(bookXp);

            //increment to get next book saved
            count +=1;

        }








        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println("Website: http://localhost:8080");
        System.out.println("Database: http://localhost:8080/h2-console");
        System.out.println("Book List: http://localhost:8080/books");




    }
}
