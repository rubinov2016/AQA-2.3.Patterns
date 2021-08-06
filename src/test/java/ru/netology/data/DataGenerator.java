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
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        LocalDate date = LocalDate.now(); // получаем текущую дату
        date = date.plusDays(shift);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String output = date.format(dtf);
        return output;
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        String[] cityList = {
                "Москва",
                "Омск",
                "Томск",
                "Петропавловск-Камчатский",
                "Сочи",
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
        int rnd = new Random().nextInt(cityList.length)
        return cityList[rnd];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
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
