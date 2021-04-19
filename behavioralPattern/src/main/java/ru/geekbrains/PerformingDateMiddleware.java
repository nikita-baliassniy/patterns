package ru.geekbrains;

public class PerformingDateMiddleware extends Middleware {

    public boolean check(Request request) {
        if (request.getDesiredDate().getDay() == 0 || request.getDesiredDate().getDay() == 6) {
            System.out.println("WRONG DATE FOR PERFORMING ORDER!");
            return false;
        } else {
            return checkNext(request);
        }
    }
}
