package ru.geekbrains;

public class PaymentMiddleware extends Middleware {

    public boolean check(Request request) {
        if (request.getCardNumber().length() != 16) {
            System.out.println("WRONG CARD NUMBER LENGTH!");
            return false;
        } else {
            for (int i = 0; i < request.getCardNumber().length(); i++) {
                if (!Character.isDigit(request.getCardNumber().charAt(i))) {
                    System.out.println("WRONG CARD NUMBER!");
                    return false;
                }
            }
            if (request.getCvcCode().length() != 3) {
                System.out.println("WRONG CARD CVC LENGTH!");
                return false;
            } else {
                for (int i = 0; i < request.getCvcCode().length(); i++) {
                    if (!Character.isDigit(request.getCvcCode().charAt(i))) {
                        System.out.println("WRONG CVC CODE!");
                        return false;
                    }
                }
            }
        }
        return checkNext(request);
    }
}
