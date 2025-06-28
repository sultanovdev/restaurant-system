package org.example.service;

import org.example.model.Food;
import org.example.model.User;

import java.util.ArrayList;
import java.util.UUID;

import static org.example.DB.DataSource.*;

public class AdminService {
    public void service() {

        while (true) {
            System.out.println("""
                    1.Add foods
                    2.Show foods
                    3.Add waiter
                    4.Show waiter
                    5.Orderservice
                    6.Waiters statistic
                    7.Manage waiter status 
                    
                    0.Exit
                    """);
            switch (scannerInt.nextInt()) {
                case 1 -> {
                    addFoods();
                }
                case 2 -> {
                    showFoods();
                }
                case 3 -> {
                    addWaiter();
                }
                case 4 -> {
                   showWaiter();
                }
                case 5 -> {
                    OrderService orderService = new OrderService();
                    orderService.service();
                }
                case 6 ->{
                    showWaiterStatistic();
                }
                case 7 ->{
                    manageWaiterStatus();
                }
                case 0 -> {
                    return;
                }
            }

        }
    }

    private void manageWaiterStatus() {
        boolean temp = false;
        for (User user : users) {
            if (user.getIsAviable().equals(true)) {
                System.out.println(user);
                temp = true;
                break;
            }
        }
        if (temp) {
            System.out.println("Enter waiter id :");
            String waiterId = scannerStr.nextLine();
            for (User user : users) {
                if (user.getUuid().toString().equals(waiterId)) {
                    user.setIsAviable(false);
                    System.out.println("Replaced waiter status !");
                    return;
                }
            }
        }else {
            System.out.println("at the moment all waiters not connected stoles !");
        }
    }

    private void showWaiterStatistic() {
        for (User user : users) {
            System.out.println(user.getName()+ " orders: "+user.getOrders()+" total profit: "+user.getTotalProfit());
        }

    }

    private void showWaiter() {
        for (User user : users) {

                System.out.println(user);

        }
    }

    private void showFoods() {
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    private void addWaiter() {
        System.out.println("Enter waiter name: ");
        String waiterName = scannerStr.nextLine();
        if (users.add(new User(UUID.randomUUID(), waiterName,false, 0, 0.0))) {
            System.out.println("Waiter successfully added !");
        }
    }

    private void addFoods() {
        System.out.println("Enter food name :");
        String foodName = scannerStr.nextLine();
        System.out.println("Enter food price:");
        Double foodPrice = scannerInt.nextDouble();

        if (foods.add(new Food(UUID.randomUUID(), foodName, foodPrice))) {
            System.out.println("Successfully added !");
        } else {
            System.out.println("This food already added ! ");
        }
    }
}
