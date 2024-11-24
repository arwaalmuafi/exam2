package com.example.exam2.Service;

import com.example.exam2.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    ArrayList<Book> books=new ArrayList<>();

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }


    public boolean updateBook(String id ,Book book){
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getID().equals(id)){
                books.set(i,book);
                return true;
            }

        }
        return false;
    }

    public boolean deleteBook (String id){
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getID().equals(id)){
                books.remove(i);
                return true;
            }

        }

        return false;
    }

    public Book search(String name){
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getName().equalsIgnoreCase(name)){
                return books.get(i);
            }

        }
        return null;
    }

    public ArrayList<Book> searchByCat(String category){
        ArrayList<Book>cat=new ArrayList<>();
        for (Book book1:books){
            if(book1.getCategory().equals(category)){
                cat.add(book1);
                return cat;
            }
        }
        return null;
    }

    public ArrayList<Book> searchByNumber(int numberOfPages) {
        ArrayList<Book> numberPages = new ArrayList<>();
        for (Book book1 : books) {
            if (book1.getNumberOfPages() >= numberOfPages) {
                numberPages.add(book1);
                return numberPages;

            }
        }

        return null;
    }


}
