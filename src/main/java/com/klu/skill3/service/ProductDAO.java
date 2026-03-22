package com.klu.skill3.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.klu.skill3.entity.Product;

public class ProductDAO {

    // Sorting
    public void a(Session s) {
        List<Product> l = s.createQuery("from Product order by price asc", Product.class).list();
        l.forEach(x -> System.out.println(x.getName() + " " + x.getPrice()));
    }

    public void b(Session s) {
        List<Product> l = s.createQuery("from Product order by price desc", Product.class).list();
        l.forEach(x -> System.out.println(x.getName() + " " + x.getPrice()));
    }

    public void c(Session s) {
        List<Product> l = s.createQuery("from Product order by quantity desc", Product.class).list();
        l.forEach(x -> System.out.println(x.getName() + " " + x.getQuantity()));
    }

    // Pagination
    public void d(Session s) {
        Query<Product> q = s.createQuery("from Product", Product.class);
        q.setFirstResult(0);
        q.setMaxResults(3);
        q.list().forEach(x -> System.out.println(x.getName()));
    }

    public void e(Session s) {
        Query<Product> q = s.createQuery("from Product", Product.class);
        q.setFirstResult(3);
        q.setMaxResults(3);
        q.list().forEach(x -> System.out.println(x.getName()));
    }

    // Aggregate
    public void f(Session s) {
        Long x = (Long) s.createQuery("select count(*) from Product").uniqueResult();
        System.out.println("Total: " + x);
    }

    public void g(Session s) {
        Long x = (Long) s.createQuery("select count(*) from Product where quantity > 0").uniqueResult();
        System.out.println("Available: " + x);
    }

    public void h(Session s) {
        List<Object[]> l = s.createQuery("select description, count(*) from Product group by description").list();
        l.forEach(x -> System.out.println(x[0] + " -> " + x[1]));
    }

    public void i(Session s) {
        Object[] x = (Object[]) s.createQuery("select min(price), max(price) from Product").uniqueResult();
        System.out.println("Min: " + x[0] + " Max: " + x[1]);
    }

    // WHERE
    public void j(Session s) {
        List<Product> l = s.createQuery("from Product where price between 50 and 500", Product.class).list();
        l.forEach(x -> System.out.println(x.getName()));
    }

    // LIKE
    public void k(Session s) {
        s.createQuery("from Product where name like 'P%'", Product.class)
         .list().forEach(x -> System.out.println(x.getName()));
    }

    public void l(Session s) {
        s.createQuery("from Product where name like '%n'", Product.class)
         .list().forEach(x -> System.out.println(x.getName()));
    }

    public void m(Session s) {
        s.createQuery("from Product where name like '%oo%'", Product.class)
         .list().forEach(x -> System.out.println(x.getName()));
    }

    public void n(Session s) {
        s.createQuery("from Product where length(name)=4", Product.class)
         .list().forEach(x -> System.out.println(x.getName()));
    }
}