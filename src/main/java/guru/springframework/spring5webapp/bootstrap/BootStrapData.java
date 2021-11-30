package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        System.out.println("Started in Bootstrap...");


        Publisher publisher = new Publisher();
        publisher.setName("Books By Justin");
        publisher.setAddressline1("1 Discovery Place");
        publisher.setCity("Sandton");
        publisher.setProvince("Gauteng");
        publisher.setPostCode("2196");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author shanice = new Author("Shanice", "Holmes");
        Book kylieLips = new Book("How to get Lips like Kylie...","123123");
        shanice.getBooks().add(kylieLips);
        kylieLips.getAuthors().add(shanice);

        authorRepository.save(shanice);
        bookRepository.save(kylieLips);

        Author simon = new Author("Simon", "Sinek");
        Book startWithWhy = new Book("Start with why ", "753159");
        simon.getBooks().add(startWithWhy);
        startWithWhy.getAuthors().add(simon);

        authorRepository.save(simon);
        bookRepository.save(startWithWhy);

        System.out.println("Number of Books: " + bookRepository.count());

    }
}
