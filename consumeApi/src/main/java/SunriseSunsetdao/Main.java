package SunriseSunsetdao;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) {

        try {
            var response = SunriseSunsetDao.getSunriseSunset("53.81751" ,"-3.03567");
            System.out.println(response);
        } catch (JsonProcessingException e) {
            e.getMessage();
        }

    }
}