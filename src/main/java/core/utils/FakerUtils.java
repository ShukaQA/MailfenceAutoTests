package core.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    private static final Faker faker = new Faker();

    public static String generateRandomEmailTitle() {
        return faker.lorem().sentence();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

}
