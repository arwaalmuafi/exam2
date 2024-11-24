package com.example.exam2.Controller;

import com.example.exam2.ApiReasponse.ApiReasponse;
import com.example.exam2.Model.Book;
import com.example.exam2.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam/vi/book")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBook(){
        ArrayList<Book> books =bookService.getBooks();

        return ResponseEntity.status(200).body(books);
    }


    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiReasponse("book added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable String id,@RequestBody @Valid Book book,Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        boolean isUpdate=bookService.updateBook(id,book);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiReasponse(" book is updated"));
        }

        return ResponseEntity.status(400).body(new ApiReasponse("book not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook (@PathVariable String id){

        boolean isDelete= bookService.deleteBook(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiReasponse("book is deleted"));
        }

        return ResponseEntity.status(400).body(new ApiReasponse("book is not found"));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity search(@PathVariable String name){
        Book books=bookService.search(name);
        if(books==null){

            return ResponseEntity.status(400).body(new ApiReasponse("is null"));
        }

        return ResponseEntity.status(200).body(books);

    }

    @GetMapping("/cat/{category}")
    public ResponseEntity searchByCat(@PathVariable String category, Book book){
        ArrayList<Book> books=bookService.searchByCat(category);
        if(books==null){
            return ResponseEntity.status(400).body(new ApiReasponse("is null"));
        }
        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("/number/{numberOfPages}")
    public ResponseEntity searchByNumber(@PathVariable int numberOfPages){
        ArrayList<Book> books=bookService.searchByNumber(numberOfPages);
        if(books==null){
            return ResponseEntity.status(400).body(new ApiReasponse("is null"));
        }
        return ResponseEntity.status(200).body(books);
    }











}
