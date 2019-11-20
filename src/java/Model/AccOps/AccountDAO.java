/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AccOps;

import Model.SignUp.UserSignup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class AccountDAO {
    Configuration cf = null;
    SessionFactory sf = null;
    Session session = null;
    public void save(Account s){
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
    
    public Account search(Account a){
        Account u1=null;
        cf = new Configuration();
        cf.configure();
        sf = cf.buildSessionFactory();
        session=sf.openSession();
        u1=(Account)session.get(Account.class,a.getAccno());
        session.close();
        sf.close();
        if(u1 == null){
            return null;
        }
        else{
            return u1;
        }
    }
    
    public void delete(Account s){
        Account u1=null;
        Transaction tx =null;
        try{
            cf = new Configuration();
            cf.configure();
            sf = cf.buildSessionFactory();
            session=sf.openSession();
            u1=(Account)session.get(Account.class,s.getAccno());
            tx = session.beginTransaction();
            session.delete(u1);
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
