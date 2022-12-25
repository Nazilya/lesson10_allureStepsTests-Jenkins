package qa.demo.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationWithStepsINTest extends BaseTest {
    @Test
    void successfulRegistrationWithStepsInTest() {

        final String
                firstName = "Egor",
                lastName = "Ivanov",
                userEmail = "EgorIvanov@google.com",
                gender = "Male",
                phoneNumber = "1234567890",
                subject = "English",
                hobby = "Reading",
                fileName = "avatar.jpg",
                currentAddress = "City, street, 1",
                stateCity = "Rajasthan",
                city = "Jaipur";

        final String
                practiceFormWrapper = "Student Registration Form",
                resultsText = "Thanks for submitting the form";


        step("open registrations form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text(practiceFormWrapper));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("fill firstName field: " + firstName, () -> {
            $("#firstName").setValue(firstName);
        });
        step("fill lastName field: " + lastName, () -> {
            $("#lastName").setValue(lastName);
        });
        step("fill userEmail field: " + userEmail, () -> {
            $("#userEmail").setValue(userEmail);
        });
        step("select gender: " + gender, () -> {
            $("#genterWrapper").$(byText(gender)).click();
        });
        step("fill phoneNumber field: " + phoneNumber, () -> {
            $("#userNumber").setValue(phoneNumber);
        });
        step("select BirthDate ", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2000");
            $x("//div[.='14']").click();
        });
        step("fill subjects field: " + subject, () -> {
            $("#subjectsInput").setValue(subject).pressEnter();
        });
        step("select hobby: " + hobby, () -> {
            $("#hobbiesWrapper").$(byText(hobby)).click();
        });
        step("upload picture: " + fileName, () -> {
            $("#uploadPicture").uploadFromClasspath(fileName);
        });
        step("fill currentAddress:  " + currentAddress, () -> {
            $("#currentAddress").setValue(currentAddress);
        });
        step("select stateCity: " + stateCity + " and city: " + city, () -> {
            $("#state").click();
            $("#stateCity-wrapper").$(byText(stateCity)).click();
            $("#city").click();
            $("#city").$(byText(city)).click();
        });
        step("click submit button", () -> {
            $("#submit").click();
        });

        step("check that the results modal appears: " + resultsText, () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text(resultsText));
        });
        step("check table results", () -> {
            $(".table-responsive").shouldHave(
                    text(firstName),
                    text(lastName),
                    text(userEmail),
                    text(phoneNumber),
                    text(currentAddress));
        });

    }
}

