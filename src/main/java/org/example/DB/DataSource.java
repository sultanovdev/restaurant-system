package org.example.DB;

import org.example.model.Food;
import org.example.model.Order;
import org.example.model.Stole;
import org.example.model.User;

import java.util.*;

public class DataSource {
    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);
    public static List<User> users = new ArrayList<>();
    public static Set<Food> foods = new HashSet<>();
    public static List<Stole> stoles = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    static {
        stoles.add(new Stole(UUID.randomUUID(),1,false));
        stoles.add(new Stole(UUID.randomUUID(),2,false));
        stoles.add(new Stole(UUID.randomUUID(),3,false));
        stoles.add(new Stole(UUID.randomUUID(),4,false));
        stoles.add(new Stole(UUID.randomUUID(),5,false));
        stoles.add(new Stole(UUID.randomUUID(),6,false));
        stoles.add(new Stole(UUID.randomUUID(),7,false));
        stoles.add(new Stole(UUID.randomUUID(),8,false));
        stoles.add(new Stole(UUID.randomUUID(),9,false));
        stoles.add(new Stole(UUID.randomUUID(),10,false));

        foods.add(new Food(UUID.randomUUID(),"Mastava",25000.0));
        foods.add(new Food(UUID.randomUUID(),"Plov",45000.0));
        foods.add(new Food(UUID.randomUUID(),"Shashlik",20000.0));
        foods.add(new Food(UUID.randomUUID(),"Somsa",8000.0));
        users.add(new User(UUID.randomUUID(),"Maqsud",false,0,0.0));
        users.add(new User(UUID.randomUUID(),"Ali",false,0,0.0));
        users.add(new User(UUID.randomUUID(),"Vali",false,0,0.0));
        users.add(new User(UUID.randomUUID(),"Kozim",false,0,0.0));
    }
}
