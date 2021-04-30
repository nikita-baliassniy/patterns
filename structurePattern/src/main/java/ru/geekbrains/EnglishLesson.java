package ru.geekbrains;

public class EnglishLesson extends AbstractLesson {
    private String mainTheme;
    private String linguisticSection;

    public String getMainTheme() {
        return mainTheme;
    }

    public String getLinguisticSection() {
        return linguisticSection;
    }

    public void setMainTheme(String mainTheme) {
        this.mainTheme = mainTheme;
    }

    public void setLinguisticSection(String linguisticSection) {
        this.linguisticSection = linguisticSection;
    }
}
