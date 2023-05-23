package selenide.demoqa;

import com.github.javafaker.Faker;

public class TestData {
     private static Faker faker = new Faker();
    public static String
            name = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            subject = faker.options().option("English", "Maths", "Hindi", "Biology"),
            gender = faker.options().option("Male", "Female", "Other"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().fullAddress(),
            state = faker.options().option("Haryana", "NCR", "Uttar Pradesh", "Rajasthan"),
            month = faker.options().option("January", "February", "March"),
            year = Integer.toString( faker.number().numberBetween(1990, 2009)),
            day = Integer.toString(faker.number().numberBetween(1, 28)),
            phoneNumber = faker.phoneNumber().subscriberNumber(10);

            public static String city(){
                String city = null;
                switch (state){
                    case "Haryana" : city = faker.options().option("Karnal", "Panipat");
                    break;
                    case "NCR" : city = faker.options().option("Delhi", "Gurgaon", "Noida");
                    break;
                    case "Uttar Pradesh" : city = faker.options().option("Agra", "Merrut", "Lucknow");
                    break;
                    case "Rajasthan" : city = faker.options().option("Jaipur", "Jaiselmer");
                    break;
                }
                return city;
            }


}


