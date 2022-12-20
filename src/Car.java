import java.time.LocalDate;

public class Car extends Transport {


    double engineVol;
    String transmissionType;
    final String bodyType;
    String numberPlate;
    final int numberOfSeats;

    boolean winterTires = false;

    int currentMonth;


    public Car(String model, String subModel, double engineVol, String color, int year, String country, String transmissionType, String bodyType, String numberPlate, int numberOfSeats,
               boolean winterTires, int maxSpeed) { ///Конструктор класса Car c проверкой полей на заполнение

        super(model, subModel, color, year, country, maxSpeed);
        //Поля, добавленные для выполнения ДЗ от 15 декабря ->

        if (transmissionType.isEmpty() || transmissionType == null) {

            this.transmissionType = "default";

        } else {

            this.transmissionType = transmissionType;

        }


        if (bodyType.isEmpty() || bodyType == null) {

            this.bodyType = "default";

        } else {

            this.bodyType = bodyType;

        }

        if (numberPlate.isEmpty() || numberPlate == null) {

            this.numberPlate = "default";

        } else {

            this.numberPlate = numberPlate;
        }

        if(numberOfSeats < 0){

            this.numberOfSeats = -numberOfSeats;

        } else {

            this.numberOfSeats = numberOfSeats;

        }


        //<- Поля, добавленные для выполнения ДЗ от 15 декабря

        if(engineVol < 0){

            this.engineVol = 1.5;
        } else {

            this.engineVol = engineVol;

        }

        this.winterTires = winterTires;

    } // <- Конструктор для класса Car

    // Геттеры и сеттеры для полей класса ->


    public String getModel() {
        return model;
    }

    public String getSubModel() {
        return subModel;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getEngineVol() {
        return engineVol;
    }

    public void setEngineVol(double engineVol) {
        this.engineVol = engineVol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public boolean getWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }

    // <- Геттеры и сеттеры для полей класса


    @Override
    void requestInformation() {     //Вывод информации об объекте класса Car (автомобиле)

        System.out.println(model + subModel + ", " + year + " год выпуска, " + country + ", " + color + " цвет кузова. Объем двигателя "
                + engineVol + " литра(-ов). " + transmissionType + " трансмиссия, " + bodyType + ". Номерной знак: "
                + numberPlate + ". " + numberOfSeats + " сидения. Шины зимние? " + winterTires + ". " + maxSpeed + " - максимальная скорость.");
    }


    static void changeTires(int currentMonth, Car car) {       //Метод для смены шин в зависимости от месяца

        if ((currentMonth >= 11 && currentMonth <= 12) || (currentMonth >= 1 && currentMonth <= 3)){

            car.setWinterTires(true);

        } else if(currentMonth > 12 || currentMonth <= 0) {

            System.out.println("Месяц введён ошибочно. Не понятно, менять шины или нет.");

        } else {

            car.setWinterTires(false);

        }

    }

    class Key {      //Внутренний класс "Ключ"

        private boolean remoteEngineLaunch = false;
        private boolean noKeyAccess = false;

        public Key(boolean remoteEngineLaunch, boolean noKeyAccess) {
            this.remoteEngineLaunch = remoteEngineLaunch;
            this.noKeyAccess = noKeyAccess;
        }
    }

    public void checkNumberPlate(Car car){      //Метод для проверки номерного знака

        String plateToCheck = car.getNumberPlate();
        boolean plateMatches = plateToCheck.matches("[а-я]{1}\\d{3}[а-я]{2}\\d{3}");

        if(plateMatches == true){

            System.out.println("Номерной знак соответствует шаблону <x000xx000>.");
        } else {

            System.out.println("Номер не соответствует шаблону <x000xx000>.");
        }


    }


    class Insurance {


        Car car;
        private final int expiryDay;
        private final int expiryMonth;
        private final int expiryYear;
        private final int insuranceCost;
        private final int insuranceNumber;


        //Геттеры для даты истечения страховки ->

        public int getExpiryDay() {
            return expiryDay;
        }

        public int getExpiryMonth() {
            return expiryMonth;
        }

        public int getExpiryYear() {
            return expiryYear;
        }

        public int getInsuranceNumber() {
            return insuranceNumber;
        }

        //<- Геттеры для даты истечения страховки

        public Insurance(Car car, int expiryDay, int expiryMonth, int expiryYear, int insuranceCost, int insuranceNumber) { //Конструктор для страховки

            this.car = car;

            if(expiryDay > 31 || expiryDay < 0){

                this.expiryDay = 1;
            } else {

                this.expiryDay = expiryDay;}


            if(expiryMonth > 12 || expiryMonth < 0){
                this.expiryMonth = 1;
            } else {
                this.expiryMonth = expiryMonth;}

            if(expiryYear < 0){

                this.expiryYear = 1980;
            } else {
                this.expiryYear = expiryYear;}

            if(insuranceCost < 0){
                this.insuranceCost = Math.abs(insuranceCost);
            } else {
                this.insuranceCost = insuranceCost;}

            if(insuranceNumber < 0){
                this.insuranceNumber = Math.abs(insuranceNumber);
            } else {
                this.insuranceNumber = insuranceNumber;}
        }

        public void checkInsuranceExpired(Insurance insurance) {     //Метод для проверки действительности страховки по дате

            LocalDate expiryDate = LocalDate.of(insurance.getExpiryYear(), insurance.getExpiryMonth(), insurance.getExpiryDay());
            LocalDate today = LocalDate.now();

            boolean insuranceExpired = today.isAfter(expiryDate);

            if (insuranceExpired == true) {

                System.out.println("Страховка истекла, её нужно срочно переоформить!");
            }
        }

        public void checkInsuranceNumber(Insurance insurance) {

            if ( ((insurance.getInsuranceNumber() / 100000000) > 10) || ((insurance.getInsuranceNumber() / 100000000) < 1)) {

                System.out.println("Номер страховки некорректный!");

            }

        }


    }
}