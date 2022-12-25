package qa.demo.testData;

import com.github.javafaker.Faker;
import qa.demo.utils.RandomUtils;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            yearBirth = String.valueOf(faker.number().numberBetween(1912, 2012)),
            monthBirth = RandomUtils.getMonth(),
            dayBirth = String.valueOf(faker.number().numberBetween(1, 30)),
            currentAddress = faker.address().streetName() + ", "
                    + faker.address().buildingNumber(),
            hobby = RandomUtils.getHobbies(),
            subject = RandomUtils.getSubject(),
            gender = "Other",
            fileName = "avatar.jpg",
            state = "Rajasthan",
            city = "Jaipur";
}
