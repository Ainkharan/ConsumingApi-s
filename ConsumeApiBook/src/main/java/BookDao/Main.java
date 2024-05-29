package BookDao;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) {

        try {
           var response =  FakeBooksDAO.getBooks("1");
            System.out.println(response);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}