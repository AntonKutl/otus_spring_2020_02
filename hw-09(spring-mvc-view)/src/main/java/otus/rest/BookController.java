package otus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import otus.dao.BookRepository;
import otus.model.Book;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", book);
        return "edit";
    }
    
    @PostMapping("/edit")
    public String editBook(Book book, Model model) {
        Book saved = bookRepository.save(book);
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("id") long id, Model model) {
        bookRepository.deleteById(id);
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @PostMapping("/save")
    public String savePerson(Book book, Model model) {
        Book saved = bookRepository.save(book);
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }
}
