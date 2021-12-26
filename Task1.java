package IBS_Tasks;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        SweetBox sweetBox = new SweetBox();
        sweetBox.add(new CaramelCandy("Ирис", 5, 1.25, "Тянущаяся конфета"));
        sweetBox.add(new ChocolateCandy("Марс", 7, 2.1, "Мягкая конфета"));
        sweetBox.add(new ChocolateNuts("Степ", 10, 5.25, "Шоколадная конфета с ореховой начинкой"));
        sweetBox.add(new Lollipop("Барбарис", 6, 0.75, "Конфета-леденец"));
        sweetBox.add(new CaramelCandy("Ирис", 5, 1.25, "Тянущаяся конфета"));
        sweetBox.add(new ChocolateCandy("Марс", 7, 2.1, "Мягкая конфета"));
        sweetBox.add(new ChocolateNuts("Степ", 10, 5.25, "Шоколадная конфета с ореховой начинкой"));
        sweetBox.add(new Lollipop("Барбарис", 6, 0.75, "Конфета-леденец"));
        sweetBox.add(new CaramelCandy("Ирис", 5, 1.25, "Тянущаяся конфета"));
        sweetBox.add(new ChocolateCandy("Марс", 7, 2.1, "Мягкая конфета"));
        sweetBox.add(new ChocolateNuts("Степ", 10, 5.25, "Шоколадная конфета с ореховой начинкой"));
        sweetBox.add(new Lollipop("Барбарис", 6, 0.75, "Конфета-леденец"));

        sweetBox.showWeight();
        sweetBox.showPrice();
        sweetBox.showInfo();

        sweetBox.optimizeWeight(21);
        //sweetBox.optimizePrice(21);

        sweetBox.showWeight();
        sweetBox.showPrice();
        sweetBox.showInfo();
    }


}
abstract class Sweet{
    String name;
    double weight;
    double price;
    String parameter;

    @Override
    public String toString() {
        return "Конфета " + name + ", вес=" + weight + ", цена=" + price + ", особенность=" + parameter;
    }
}

class CaramelCandy extends Sweet{
    public CaramelCandy(String name, double weight, double price, String parameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.parameter = parameter;
    }
}

class ChocolateCandy extends Sweet{
    public ChocolateCandy(String name, double weight, double price, String parameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.parameter = parameter;
    }
}

class ChocolateNuts extends Sweet{
    public ChocolateNuts(String name, double weight, double price, String parameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.parameter = parameter;
    }
}

class Lollipop extends Sweet{
    public Lollipop(String name, double weight, double price, String parameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.parameter = parameter;
    }
}

interface Box{
    void add(Sweet sweet);
    void remove();
    void showWeight();
    void showPrice();
    void showInfo();
    void optimizeWeight(double requiredWeight);
    void optimizePrice(double requiredWeight);
}
class SweetBox implements Box{
    private List <Sweet> boxOfSweets = new ArrayList<>();

    @Override
    public void add(Sweet sweet) {
        boxOfSweets.add(sweet);
    }

    @Override
    public void remove() {
        //removeLast
        boxOfSweets.remove(boxOfSweets.size()-1);
    }

    public void remove(int index) {
        //removeByIndex
        boxOfSweets.remove(index);
    }
    double getWeight(){
        double boxWeight = 0;
        for(Sweet sweet:boxOfSweets){
            boxWeight += sweet.weight;
        }
        return boxWeight;
    }

    @Override
    public void showWeight() {
        System.out.println("Общий вес подарка: " + getWeight());
    }

    double getPrice(){
        double boxPrice = 0;
        for(Sweet sweet:boxOfSweets){
            boxPrice += sweet.price;
        }
        return boxPrice;
    }

    @Override
    public void showPrice() {
        System.out.println("Общая стоимость подарка: " + getPrice());
    }

    @Override
    public void showInfo() {
        System.out.println("Сладости в коробке: \n");
        System.out.println(boxOfSweets.toString());
    }

    double getMinWeight(){
        double minWeight = boxOfSweets.get(0).weight;
        for(int i = 1; i < boxOfSweets.size(); i++){
            if(boxOfSweets.get(i).weight < minWeight) minWeight = boxOfSweets.get(i).weight;
        }
        return minWeight;
    }

    @Override
    public void optimizeWeight(double requiredWeight) {
        System.out.println("---------------------Оптимизация по весу подарка------------------");

        while (getWeight() > requiredWeight){
            for(int i = 0; i < boxOfSweets.size(); i++){
                if(boxOfSweets.get(i).weight == getMinWeight()) {
                    boxOfSweets.remove(i);
                    break;
                }
            }
        }

    }

    double getMinPrice(){
        double minPrice = boxOfSweets.get(0).price;
        for(int i = 0; i < boxOfSweets.size(); i++){
            if(boxOfSweets.get(i).price < minPrice) minPrice = boxOfSweets.get(i).price;
        }
        return minPrice;
    }
    @Override
    public void optimizePrice(double requiredWeight) {
        System.out.println("---------------------Оптимизация по цене подарка------------------");
        while (getWeight() > requiredWeight){
            for(int i = 0; i < boxOfSweets.size(); i++){
                if(boxOfSweets.get(i).price == getMinPrice()) boxOfSweets.remove(i);
            }

        }
    }

}