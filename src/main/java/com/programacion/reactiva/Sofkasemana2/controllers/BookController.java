package com.programacion.reactiva.Sofkasemana2.controllers;

import com.programacion.reactiva.Sofkasemana2.models.Book;
import com.programacion.reactiva.Sofkasemana2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/api/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;

    }

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getAllBook(){
        return bookService.getAllBook();
    }
    @GetMapping(value = "/presure/{nro}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public  Flux<Book>getAllBookBackPresure(@PathVariable int nro){
        return  bookService.getAllBookBackPresure(nro);
    }
    @GetMapping("/{id}")
    public Mono<Book> findById(@PathVariable String id){
        return bookService.findById(id);
    }
    @PostMapping("/")
    public  Mono<Book> posBook(@RequestBody Book book ){
        return bookService.postBook(book).log();
    }
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Book>> updateBook(@PathVariable String id,@RequestBody Book book){
        return bookService.updateBook(id,book);
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleBookId(@PathVariable String id){
        return bookService.deleteUser(id)
                .map(r->ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
