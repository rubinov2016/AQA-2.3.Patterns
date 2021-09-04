package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        date = date.plusDays(shift);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String output = date.format(dtf);
        return output;
    }

    public static String generateCity(String locale) {
        String[] cityList = {
                "Москва",
                "Омск",
                "Томск",
                "Петропавловск-Камчатский",
                "Краснодар",
                "Красноярск",
                "Великий Новгород",
                "Екатеринбург",
                "Йошкар-Ола",
                "Калининград",
                "Кемерово",
                "Киров",
                "Кострома",
                "Курган",
                "Курск",
                "Санкт-Петербург",
                "Сыктывкар",
                "Чебоксары",
                "Великий Новгород",
                "Владивосток",
                "Владикавказ",
                "Волгоград",
                "Вологда",
                "Севастополь",
                "Ставрополь",
                "Ярославль"
        };
        int rnd = new Random().nextInt(cityList.length);
        return cityList[rnd];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
