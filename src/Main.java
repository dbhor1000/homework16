import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //Имеем 5 разных автомобилей с заданными характеристиками.

        Car car1 = new Car("Opel", "Astra", 1.6, "Красный", 2003, "Румыния",
                "Ручная", "Кабриолет", "в132пп199", 4, false, 100);

        Car car2 = new Car("Mazda", "RX7", 2.2, "Чёрный", 2006, "Япония",
                "Ручная", "Спорт", "е765ла890", 2, false, 180);

        Car car3 = new Car("Toyota", "Corolla", 1.8, "Синий", 2012, "Япония",
                "Автомат", "Семейный", "о134ощ564", 4, false, 130);

        Car car4 = new Car("Ford", "Focus", 1.7, "Серый", -2015, "Америка",
                "Автомат", "Хэтчбек", "у146пв794", 4, false, 170);

        Car car5 = new Car("Лада", "Гранта", 1.6, "Белый", 2020, "Россия",
                "Ручная", "Седан", "т563ип86с", 4, false, 250);

        //Страховка для автомобилей 1, 3, 4, 5:

        Car.Insurance insuranceCar1 = car1.new Insurance(car1, 12, 8, 2021, 1000, 123456789);
        Car.Insurance insuranceCar3 = car3.new Insurance(car3, 17, 2, 2023, 1000, 12345678);
        Car.Insurance insuranceCar4 = car4.new Insurance(car4, 23, 3, 2020, 1000, 123456789);
        Car.Insurance insuranceCar5 = car5.new Insurance(car5, 7, 8, 2025, 1000, 1234567891);

        //Страховка для автомобиля 2 ("новая" и "старая"):

        Car.Insurance insuranceCar2Old = car2.new Insurance(car2, 12, 8, 2021, 1000, 123456789);
        Car.Insurance insuranceCar2New = car2.new Insurance(car2, 12, 8, 2023, 1200, 123456789);




        //Запрашиваем информацию о 2, 4, 5 автомобилях:

        car2.requestInformation();
        car4.requestInformation();
        car5.requestInformation();

        //На дворе 12 месяц(декабрь), меняем шины на 4 и 5 автомобилях, проверяем.

        Car.changeTires(12, car4);
        Car.changeTires(13, car5);

        car4.requestInformation();
        car5.requestInformation();

        //Ошибочно указан месяц для смены шин на 5 автомобиле. Исправляем, проверяем.

        Car.changeTires(12, car5);

        car5.requestInformation();

        //Полицейский останавливает автомобили 4 и 5 для проверки номеров.

        car4.checkNumberPlate(car4);
        car5.checkNumberPlate(car5);

        //У автомобиля номер 5 проблема с номерами. Идём в гараж и проверяем автомобиль номер 2 и страховку.

        car2.requestInformation();
        insuranceCar2Old.checkInsuranceExpired(insuranceCar2Old);

        //Страховка истекла... Быстро звоним товарищу и просим помочь оформить новую. Ведь без страховки за руль садиться нельзя!

        insuranceCar2New.checkInsuranceExpired(insuranceCar2New);

        //Новая страховка действительна и можно садиться за руль. На всякий случай, проверим её номер.

        insuranceCar2New.checkInsuranceNumber(insuranceCar2New);

        //Номер страховки верен. Можно ехать! :)

        Car.Key keyCar2 = car2.new Key(true, true);

        //Проверка страховки на автомобиле 5 и её номера.

        insuranceCar5.checkInsuranceExpired(insuranceCar5);
        insuranceCar5.checkInsuranceNumber(insuranceCar5);

        //Страховка действительна, а вот в номере ошибка.

        //->ДЗ от 19 декабря (Наследование)

        //The blue bus is calling us
        //Driver, where you taking us?

        Bus bus1 = new Bus("Volvo", "B9R", "Blue", 1967, "Sweden", 120);
        Bus bus2 = new Bus("Volvo", "B11R", "Red", 2015, "Denmark", 150);
        Bus bus3 = new Bus("Volvo", "B7R", "Orange", -6, "Sweden", 140);

        bus1.requestInformation();
        bus2.requestInformation();
        bus3.requestInformation();

    }
}