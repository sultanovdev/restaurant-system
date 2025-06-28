package org.example;

import org.example.service.AdminService;

public class Main {
    public static void main(String[] args) {
        AdminService orderService = new AdminService();
        orderService.service();
    }
}