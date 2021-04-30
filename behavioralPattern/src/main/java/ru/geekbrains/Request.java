package ru.geekbrains;


import java.time.LocalDateTime;
import java.util.Date;

public class Request {
    private long id;
    private long clientId;
    private String cardNumber;
    private String cardDates;
    private String cvcCode;
    private LocalDateTime createdAt;
    private double fullPrice;
    private double discount;
    private int creatingMethod;
    private Date desiredDate;

    public long getId() {
        return id;
    }

    public long getClientId() {
        return clientId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardDates() {
        return cardDates;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public int getCreatingMethod() {
        return creatingMethod;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardDates(String cardDates) {
        this.cardDates = cardDates;
    }

    public void setCvcCode(String cvcCode) {
        this.cvcCode = cvcCode;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCreatingMethod(int creatingMethod) {
        this.creatingMethod = creatingMethod;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }
}

