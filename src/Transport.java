public class Transport {

    final String model;
    final String subModel;
    String color;
    final int year;
    final String country;
    int maxSpeed;

    public Transport(String model, String subModel, String color, int year, String country, int maxSpeed) {

        if(maxSpeed <= 0){

            this.maxSpeed = 0;
        } else {

            this.maxSpeed = maxSpeed;
        }

        if(model.isEmpty() || model == null){

            this.model = "default";
        } else {

            this.model = model;

        }

        if(year <= 0){

            this.year = 2000;
        } else {

            this.year = year;

        }

        if(subModel.isEmpty() || subModel == null){

            this.subModel = "default";

        } else {

            this.subModel = subModel;

        }

        if(country.isEmpty() || country == null){

            this.country = "default";
        } else {

            this.country = country;

        }

        if(color.isEmpty() || color == null){

            this.color = "Белый";
        } else {

            this.color = color;

        }

    }

    void requestInformation() {     //Вывод информации об объекте класса Car (автомобиле)

        System.out.println(model + subModel + ", " + year + " год выпуска, " + country + ", " + color + " цвет кузова. " + maxSpeed + " - максимальная скорость.");
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
