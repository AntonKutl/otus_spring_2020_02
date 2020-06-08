package otus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import otus.dao.AuthorRepository;
import otus.dao.BookRepository;
import otus.model.Author;
import otus.model.Book;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/list")
    public String listPage(Model model) {
        return viewListBook(model);
    }



    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", book);
        return "edit";
    }
    
    @PostMapping("/edit")
    public String editBook(Book book, Model model) {
        bookRepository.save(book);
        return viewListBook(model);
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("id") long id, Model model) {
        bookRepository.deleteById(id);
        return viewListBook(model);
    }

    @PostMapping("/save")
    public String savePerson(Book book, Model model) {
        bookRepository.save(book);
        return viewListBook(model);
    }

    private String viewListBook(Model model){
        List<Book> books = bookRepository.findAll();
        List<Author> authors=authorRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("authors",authors);
        return "list";
    }

}
