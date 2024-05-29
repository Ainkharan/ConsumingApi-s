package BookDao;

import BookModel.BooksRecord;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) {
        //BooksRecord params = new BooksRecord();

        try {
           var response =  FakeBooksDAO.getBooks("100","en_US");
            System.out.println(response);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}