package utils;


import org.apache.commons.lang3.RandomStringUtils;

public class RandomName {

    public RandomName() {
    }

    private String geradorName() {
        return RandomStringUtils.randomAlphabetic(10).toUpperCase();
    }

    public String generationName() {
        return geradorName();
    }
}
