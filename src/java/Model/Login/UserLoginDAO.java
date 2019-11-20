/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class UserLoginDAO {
    Configuration cf = null;
    SessionFactory sf = null;
    Session session = null;
    
    public boolean search(UserLogin u){
        UserLogin u1=null;
        cf = new Configuration();
        cf.configure();
        sf = cf.buildSessionFactory();
        session=sf.openSession();
        u1=(UserLogin)session.get(UserLogin.class,u.getUname());
        session.close();
        sf.close();
        if(u1 == null){
            return false;
        }
        else{
            return u1.equals(u);
        }
    }
}

