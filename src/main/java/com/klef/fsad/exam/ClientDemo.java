package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class ClientDemo {

public static void main(String[] args) {

SessionFactory sf = new Configuration().configure().buildSessionFactory();
Session session = sf.openSession();
Transaction tx = session.beginTransaction();

Vehicle v = new Vehicle();
v.setName("Car");
v.setDescription("New Vehicle");
v.setDate(new Date());
v.setStatus("Available");

session.save(v);

tx.commit();

session.beginTransaction();

Vehicle v2 = session.get(Vehicle.class, 1);

if(v2 != null) {
    v2.setName("Updated Car");
    v2.setStatus("Sold");
    session.update(v2);
} else {
    System.out.println("Record not found");
}

session.getTransaction().commit();

session.close();
sf.close();
}
}