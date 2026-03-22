package com.klu.skill3.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.klu.skill3.entity.Product;

public class App {
    public static void main(String[] args) {

        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s = f.openSession();

        s.beginTransaction();

        // Insert data
        s.save(new Product("Pen", "Stationary", 10, 50));
        s.save(new Product("Book", "Education", 200, 20));
        s.save(new Product("Phone", "Electronics", 15000, 5));
        s.save(new Product("Laptop", "Electronics", 50000, 2));
        s.save(new Product("Bag", "Accessories", 800, 10));
        s.save(new Product("Mouse", "Electronics", 500, 25));

        s.getTransaction().commit();

        ProductDAO d = new ProductDAO();

        System.out.println("\n--- Price ASC ---");
        d.a(s);

        System.out.println("\n--- Price DESC ---");
        d.b(s);

        System.out.println("\n--- Quantity DESC ---");
        d.c(s);

        System.out.println("\n--- First 3 ---");
        d.d(s);

        System.out.println("\n--- Next 3 ---");
        d.e(s);

        System.out.println("\n--- Total Count ---");
        d.f(s);

        System.out.println("\n--- Available Count ---");
        d.g(s);

        System.out.println("\n--- Group By ---");
        d.h(s);

        System.out.println("\n--- Min Max ---");
        d.i(s);

        System.out.println("\n--- Price Range ---");
        d.j(s);

        System.out.println("\n--- Starts With ---");
        d.k(s);

        System.out.println("\n--- Ends With ---");
        d.l(s);

        System.out.println("\n--- Contains ---");
        d.m(s);

        System.out.println("\n--- Length = 4 ---");
        d.n(s);

        s.close();
        f.close();
    }
}