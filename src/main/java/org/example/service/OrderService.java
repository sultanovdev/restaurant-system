package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Food;
import org.example.model.Order;
import org.example.model.Stole;
import org.example.model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import static org.example.DB.DataSource.*;

public class OrderService {
    public void service() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Order order = new Order();
        for (Stole stole : stoles) {
            if (stole.getIsAviable().equals(false)) {
                System.out.println(stole);
            }
        }
        System.out.println("Enter number stole not ID ! ");
        Integer numberStole = scannerInt.nextInt();
        boolean temp = false;
        for (Stole stole : stoles) {
            if (stole.getIsAviable().equals(false)) {
                if (stole.getNumberStole() == numberStole) {

                    temp = true;
                    stole.setIsAviable(true);
                    break;
                }
            }
        }
        double totalProfit = 0;
        if (temp) {

            for (Food food : foods) {
                System.out.println(food);
            }
            boolean kx = false;
            System.out.println("Enter food by Id ( not name ! )");
            String foodId = scannerStr.nextLine();
            for (Food food : foods) {
                if (food.getUuid().toString().equals(foodId)) {
                    System.out.println("How many do you need ?");
                    Integer quantity = scannerInt.nextInt();
                    System.out.println("Total price : " + quantity * food.getPrice());
                    kx = true;
                    totalProfit = quantity * food.getPrice();
                    order.setUuid(UUID.randomUUID());
                    order.setTotalPrice(totalProfit);
                    List<Food> foods1 = new ArrayList<>(Arrays.asList(food));
                    order.setFoodsName(foods1);
                    break;
                }
            }

            if (kx) {
                boolean zx = false;
                for (User user : users) {
                    if (user.getIsAviable().equals(false)) {
                        System.out.println(user);
                        zx = true;
                    }
                }
                if (zx) {
                    int count = 0;
                    System.out.println("Enter waiter by id ");
                    String waiterId = scannerStr.nextLine();
                    for (User user : users) {
                        if ( user.getIsAviable().equals(false) && user.getUuid().toString().equals(waiterId)) {
                            System.out.println(user.getName() + " connected ");
                            user.setIsAviable(true);
                            user.setOrders(++count);
                            user.setTotalProfit(totalProfit);
                            order.setWaiterName(user.getName());

                            Type listType = new TypeToken<List<Order>>() {}.getType();
                            List<Order> myList = null;
                            try{
                                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/history.json"));
                                myList = gson.fromJson(bufferedReader,listType);
                                bufferedReader.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            myList.add(order);
                            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/history.json"))){
                                bufferedWriter.write(gson.toJson(myList));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                } else {
                    System.out.println("At the moment no waiter !");
                }

            }
        } else {
            System.out.println("You entered mistake number or stole already broned !");
        }

    }
}
