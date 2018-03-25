/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlles;


/**
 *
 * @author M.Gebaly
 */
public class User {
    private int id;
    private String name;
    private String date;
    private String email;
    private String password;
    private String job;
    private double cridet;
    private String address;
    private int admin;

    public User(){}
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    public User( String name, String date, String email, String password, String job, double cridet, String address, int admin) {
        
        this.name = name;
        this.date = date;
        this.email = email;
        this.password = password;
        this.job = job;
        this.cridet = cridet;
        this.address = address;
        this.admin = admin;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the cridet
     */
    public double getCridet() {
        return cridet;
    }

    /**
     * @param cridet the cridet to set
     */
    public void setCridet(double cridet) {
        this.cridet = cridet;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the admin
     */
    public int getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
