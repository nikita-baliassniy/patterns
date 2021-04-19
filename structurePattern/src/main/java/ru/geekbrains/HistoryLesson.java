package ru.geekbrains;

public class HistoryLesson extends AbstractLesson {
    private String currentAge;
    private String country;

    public String getCurrentAge() {
        return currentAge;
    }

    public String getCountry() {
        return country;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
