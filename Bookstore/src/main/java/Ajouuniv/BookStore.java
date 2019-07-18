package Ajouuniv;

import java.util.ArrayList;

public class BookStore {
    ArrayList<Book> bookList = new ArrayList<>();

    void addBook(String title, String author, String subject, int booknum){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setSubject(subject);
        book.setBooknum(booknum);
        book.setLoaned(false);
        bookList.add(book);
    }
    void delBookBytitle(String title){
        for(int i = 0;i<bookList.size();i++)
        {
            if(bookList.get(i).getTitle().equals(title))
            {
                bookList.remove(i);
            }
        }
    }
    void delBookByNumber(int number){
        for(int i = 0;i<bookList.size();i++)
        {
            if(bookList.get(i).getBooknum() == number)
            {
                bookList.remove(i);
            }
        }
    }
    void loanBook(String title){
        for(int i = 0;i<bookList.size();i++)
        {
            if(bookList.get(i).getTitle().equals(title))
            {
                bookList.get(i).setLoaned(true);
            }
        }
    }
    void returnBook(String title){
        for(int i = 0;i<bookList.size();i++)
        {
            if(bookList.get(i).getTitle().equals(title))
            {
                bookList.get(i).setLoaned(false);
            }
        }
    }

}
