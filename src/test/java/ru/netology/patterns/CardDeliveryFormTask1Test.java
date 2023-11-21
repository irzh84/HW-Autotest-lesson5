package ru.netology.patterns;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryFormTask1Test {

    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

//    @Test
//    void shouldChangeDateFirstFill() {
//        open("http://localhost:9999/");
//        $("[data-test-id='city'] input").setValue("Москва");
//        String planningDate = generateDate(3, "dd.MM.yyyy");
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(planningDate);
//        $("[data-test-id='name'] input").setValue("Сергей Петров");
//        $("[data-test-id='phone'] input").setValue("+79010010101");
//        $("[data-test-id='agreement']").click();
//        $(".button").click();
//        $(".notification__content")
//                .shouldBe(Condition.visible, Duration.ofSeconds(20))
//                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + planningDate));
//    }

    @Test
    void shouldChangeDate() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Москва");
        String planningDate = generateDate(6, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Иванова Ольга");
        $("[data-test-id='phone'] input").setValue("+79012244678");
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id='replan-notification'] .button").click();
        $("[data-test-id='success-notification'] .notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(20))
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + planningDate));
    }
}
