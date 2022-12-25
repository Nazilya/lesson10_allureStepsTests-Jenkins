package qa.demo.tests;

import org.junit.jupiter.api.Test;
import qa.demo.testData.TestData;

public class RegistrationWithStepsINPageTest extends BaseTest {
    private TestData studentsData = new TestData();

    @Test
    void successfulRegistrationWithStepsInPageTest() {
        registrationPage.openPage()
                .setFirstName(studentsData.firstName)
                .setLastName(studentsData.lastName)
                .setUserEmail(studentsData.userEmail)
                .setGender(studentsData.gender)
                .setPhoneNumber(studentsData.userNumber)
                .setBirthDate(studentsData.dayBirth, studentsData.monthBirth, studentsData.yearBirth)
                .setSubject(studentsData.subject)
                .setHobbiesWrapper(studentsData.hobby)
                .uploadPictureFile(studentsData.fileName)
                .setCurrentAddress(studentsData.currentAddress)
                .setStateAndCity(studentsData.state, studentsData.city)
                .clickSubmit();
        registrationPage.verifyResultsModalAppears()
                .checkTableResult("Student Name", studentsData.firstName + " " + studentsData.lastName)
                .checkTableResult("Address", studentsData.currentAddress)
                .checkTableResult("Hobbies", studentsData.hobby)
                .checkTableResult("Student Email", studentsData.userEmail)
                .checkTableResult("Date of Birth", studentsData.dayBirth + " " + studentsData.monthBirth + "," + studentsData.yearBirth)
                .checkTableResult("State and City", studentsData.state + " " + studentsData.city);
    }
}

