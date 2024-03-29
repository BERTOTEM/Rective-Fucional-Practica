package com.programacion.reactiva.Sofkasemana2.handler;

import com.programacion.reactiva.Sofkasemana2.models.Book;
import com.programacion.reactiva.Sofkasemana2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class BookHandler {
    private final BookRepository bookRepository;
    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
    @Autowired
    public  BookHandler  (BookRepository bookRepository){
        this.bookRepository= bookRepository;
    }

    public Mono<ServerResponse> getAllBooks(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookRepository.findAll(), Book.class);
    }

    public Mono<ServerResponse> getOneBook(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Book> itemMono = bookRepository.findById(id);
        return itemMono.flatMap(item ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(item))
                        ).switchIfEmpty(notFound);

    }
    public Mono<ServerResponse> createBook(ServerRequest serverRequest) {
        Mono<Book> bookMono = serverRequest.bodyToMono(Book.class);

        return bookMono.flatMap(book ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(bookRepository.save(book), Book.class));

    }
    public Mono<ServerResponse> deleteBook(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Void> deletedBook = bookRepository.deleteById(id);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deletedBook, Void.class);

    }

    public Mono<ServerResponse> updateBook(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Book> updatedBook = serverRequest.bodyToMono(Book.class).log("mono: ")
                .flatMap(book -> bookRepository.findById(id).log()
                        .flatMap(oldBook -> {
                            oldBook.setTitle(book.getTitle());
                            oldBook.setAuthor(book.getAuthor());
                            return bookRepository.save(oldBook).log();
                        }));

        return updatedBook.flatMap(book -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(book)))
                .switchIfEmpty(notFound);
    }


}
