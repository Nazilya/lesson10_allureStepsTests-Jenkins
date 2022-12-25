package qa.demo.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TextBoxWithStepsTest extends BaseTest {

    @Test
    void textBoxWithStepsNegativeTest() {

        step("open textBox page form", () -> {
            open("/text-box");
        });

        step("fill form ", () -> {
            $("#userName").setValue("Egor");
            $("#userEmail").setValue("Egor@egor.com");
            $("#currentAddress").setValue("Some address 1");
            $("#permanentAddress").setValue("Other address 1");
        });
        step("click submit button", () -> {
            $("#submit").click();
        });
        step("Check form results", () -> {
            //$("#output").shouldBe(Condition.visible);
            $("#output #name").shouldHave(text("Egor"));
            $("#output #email").shouldHave(text("Egor@egor.com"));
            $("#output #currentAddress").shouldHave(text("Some address 1"));
            $("#output #permanentAddress").shouldHave(text("Other address 1"));
        });
    }

    @Disabled("disabled test for report")
    @Test
    void someDisabledTest() {
        step("open textBox page form", () -> {
            open("/text-box");
        });
    }
}
