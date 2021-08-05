package ru.netology.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RepeatEntryTest {

    private Faker faker;
//Используйте Faker, Lombok, Data-классы (для группировки нужных полей)
//и утилитный класс-генератор данных* - см. пример в презентации.

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru/netology,delivery"));
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {

        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();

        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").setValue(timeStamp);
        $("[data-test-id=name] input").setValue(name);
        $("[data-test-id=phone] input").setValue(phone);
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
    }
}
