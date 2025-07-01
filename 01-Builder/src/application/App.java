package application;

import domain.Pizza;

public class App {
    public static void main(String[] args) {

        Pizza pizza = new Pizza.Builder()
                .cheese(true)
                        .build();

        System.out.println(pizza);

    }
}
