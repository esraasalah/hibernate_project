/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import enitiy.Users;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author M.Gebaly
 */
public class UserTableOperations {

    private Session session;

    public boolean signUpHandler(Users user) {
        boolean returnVal = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
//            Transaction transaction = session.beginTransaction();
//            transaction.begin();
//            session.persist(user);
//            transaction.commit();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                System.out.println("Transaction is being rolled back.");
                session.getTransaction().rollback();
                returnVal = false;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return returnVal;
    }

    public Users loginHandler(String email, String password) {
        session = HibernateUtil.getSessionFactory().openSession();
        Users user = new Users();
        //String hql = "FROM Users U WHERE U.userEmail = '" + email + "' AND U.userPassword = '" + password + "'";
        String hql = "FROM Users U WHERE U.userEmail = :email AND U.userPassword = :password";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
//        List<Users> result1 = query.list();
//        user = result1.get(0);
        if(query.uniqueResult() != null){
            user = (Users) query.uniqueResult();
        }else{
            user = null;
        }
        session.close();
        return user;
    }
    
     public boolean editeUser(Users user){
         boolean returnVal = true;
         session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
//        String hql = "UPDATE Users set userName = :userName, birthdate = :birthdate,"
//                + " userPassword = :password, "
//                + " userJob = :job, "
//                + " creditLimit = :credite, "
//                + " userAddress = :address, "
//                + " admin = :admin "
//                + " WHERE userEmail = :email";
//        Query query = session.createQuery(hql);
//        query.setParameter("userName", user.getUserName());
//        query.setParameter("birthdate", user.getBirthdate());
//        query.setParameter("password", user.getUserPassword());
//        query.setParameter("job", user.getUserJob());
//        query.setParameter("credite", user.getCreditLimit());
//        query.setParameter("address", user.getUserAddress());
//        query.setParameter("admin", user.getAdmin());
//        
//        query.setParameter("email", user.getUserEmail());
//        session.save(user);
//        session.flush();
//        session.clear();
//        session.getTransaction().commit();
//        session.close();


//        BigDecimal userId = user.getUserId();

        Users userc = getUser(user);
        BigDecimal userId = userc.getUserId();
        Users userN = (Users) session.load(Users.class, userId);
        userN.setUserName(user.getUserName());
        userN.setBirthdate(user.getBirthdate());
        userN.setUserPassword(user.getUserPassword());
        userN.setUserJob(user.getUserJob());
        userN.setCreditLimit(user.getCreditLimit());
        userN.setUserAddress(user.getUserAddress());
        userN.setAdmin(user.getAdmin());
        //session.save(userN);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
        
         
         return returnVal;
     }
     
     public List<Users> retriveAllUsers(){
        String hql = "FROM Users";
        Query query = session.createQuery(hql);
        List<Users> users = query.list();
        session.close();
        return users;
     }
     
     private Users getUser(Users user){
         String hql = "FROM Users U WHERE U.userEmail = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", user.getUserEmail());
        List<Users> result1 = query.list();
        user = result1.get(0);
         return user;
     }
     
     public boolean checkCreditLimit(int money,int id){
        
        boolean retValue = false;
        
        try {
            String query = "select credit_limit from "
                    + DatabaseTables.UserTable.tableName
                    + " where " + DatabaseTables.UserTable.idColumn + " = " + id + "";
            ResultSet resultSet = DatabaseHandler.getInstance().select(query);
            while (resultSet.next()) {
                if(resultSet.getInt(DatabaseTables.UserTable.crediteColumn) >= money){
                    retValue = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserTableOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retValue;
    }
     
     public void updateCrediteLimit(int id, double credit){
        String updatequery = "update " + DatabaseTables.UserTable.tableName
                        + " set " + DatabaseTables.UserTable.crediteColumn + " = " + credit
                        + " where " + DatabaseTables.UserTable.idColumn + " = " + id;
        DatabaseHandler.getInstance().update(updatequery);
               
    } 
     
     public boolean isExist(String email) {
        boolean retValue = true;
        String query = "select * from "
                + DatabaseTables.UserTable.tableName
                + " where " + DatabaseTables.UserTable.emailColumn + " = '" + email + "'";
        try {
            if (DatabaseHandler.getInstance().select(query).next()) {
                retValue = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserTableOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retValue;
    }
}
