/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SignUp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class UserSignupDAO {
    Configuration cf = null;
    SessionFactory sf = null;
    Session session = null;
    public void save(UserSignup s){
        try{
            cf = new Configuration();
            cf.configure("hibernate.cfg.xml");
            sf = cf.buildSessionFactory();
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(s);
            tx.commit();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        finally{
            session.close();
            sf.close();
        }
    }
}
