package pl.library.app;

import pl.library.model.Book;
import pl.library.io.DataReader;
import pl.library.model.Library;

public class LibraryControl {

    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int PRINT_BOOKS = 2;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLop(){
        int option;

        do{
            printOptions();
            option = dataReader.getInt();
            switch(option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case EXIT:
                    exit();
                default:
                    System.out.println("Błąd");
            }
        }while(option != EXIT);
    }

    private void exit() {
        System.out.println("Koniec programu, BYE!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }


    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }


    private void printOptions() {
        System.out.println("Wybierz opcje:");
        System.out.println(EXIT +" - Wyjscie z programu");
        System.out.println(ADD_BOOK +" - Dodanie nowej książki");
        System.out.println(PRINT_BOOKS +" - Wyswietl dostępne książki");


    }


}
