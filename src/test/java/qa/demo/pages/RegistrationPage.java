package qa.demo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import qa.demo.components.CalendarComponent;
import qa.demo.components.RegistrationResultsModal;
import qa.demo.components.StateAndCityComponent;
import qa.demo.elements.Button;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            phoneNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            dateOfBirthLocator = $("#dateOfBirthInput");
    private Button submit = new Button("Submit", $("#submit"));

    @Step("open practice-form page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("fill firstName field")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("fill lastName field")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("fill userEmail field")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("select gender")
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    @Step("fill phoneNumber field")
    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    @Step("fill subjects field")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("select hobbies")
    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("upload picture")
    public RegistrationPage uploadPictureFile(String fileName) {
//        uploadPicture.uploadFile(new File(path));
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    @Step("fill currentAddress field")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("select state and city")
    public RegistrationPage setStateAndCity(String value1, String value2) {
        stateAndCityComponent.setStateAndCity(value1, value2);

        return this;
    }

    @Step("click submit button")
    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    @Step("select BirthDate")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthLocator.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("check that the results modal appears")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    @Step("check table results")
    public RegistrationPage checkTableResult(String key, String value) {
        registrationResultsModal.checkTable(key, value);
        return this;
    }

}
