package ru.geekbrains;

import java.text.SimpleDateFormat;

public class Main {

    /**
     * Цепочка обязанностей с простейшими обработчиками информации о заказе
     * */
    public static void main(String[] args) {
        Middleware middleware = new DiscountMiddleware();
        middleware.linkWith(new PaymentMiddleware()).linkWith(new PerformingDateMiddleware());

        Request newRequest = new Request();
        newRequest.setCardNumber("1234567891123456"); // контроль длины и цифр
        newRequest.setClientId(1L); // соответствия номера клиента и скидки
        newRequest.setDiscount(0.5);
        newRequest.setCvcCode("116"); // контроль длины и цифр
        try {
            newRequest.setDesiredDate(new SimpleDateFormat("dd.MM.yyyy").parse("19.04.2021"));
            // контроль буднего дня
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        middleware.check(newRequest);
    }
}
