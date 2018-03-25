/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author M.Gebaly
 */
public class DatabaseTables {

    static class UserTable {

        public static String tableName = "USERS";
        public static String idColumn = "USER_ID";
        public static String nameColumn = "USER_NAME";
        public static String birthdateColumn = "BIRTHDATE";
        public static String emailColumn = "USER_EMAIL";
        public static String passwordColumn = "USER_PASSWORD";
        public static String jobColumn = "USER_JOB";
        public static String crediteColumn = "CREDIT_LIMIT";
        public static String addressColumn = "USER_ADDRESS";
        public static String adminColumn = "ADMIN";
    }

    static class CategoryTable {

        public static String tableName = "CATEGORY";
        public static String idColumn = "CATEGORY_ID";
        public static String nameColumn = "CATEGORY_NAME";
    }

    static class ProductsTable {

        public static String tableName = "PRODUCTS";
        public static String idColumn = "PRODUCT_ID";
        public static String nameColumn = "PRODUCT_NAME";
        public static String descriptionColumn = "PRODUCT_DESCRIPTION";
        public static String quantitiyColumn = "PRODUCT_QUANITITY";
        public static String imageColumn = "PRODUCT_IMAGE";
        public static String salaryColumn = "PRODUCT_SALARY";
        public static String categoryColumn = "CATEGORY_ID";
    }

    static class IntersticesTable {

        public static String tableName = "INTERSTICES";
        public static String userIdColumn = "USER_ID";
        public static String productIdColumn = "PRODUCT_ID";
    }
}
