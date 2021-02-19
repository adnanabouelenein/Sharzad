package com.adnanabouelenein.sharzadcleaningcenter.database;

public class Constants {

    public final static int CART = 1;
    public final static int REPORT = 2;
    public final static int SETTINGS = 3;
    public final static int TRANSACTION = 4;
    public final static int PURCHASE = 5;

    public final static String PRODUCT_TABLE = "product";
    public final static String CUSTOMER_TABLE = "customer";
    public final static String TRANSACTION_TABLE = "transaction";

    //create columns for customer table
    public final static String COLUMN_ID = "_id";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_EMAIL = "email";
    public final static String COLUMN_PHONE = "phone";
    public final static String COLUMN_DATE_CREATED = "create_date";
    public final static String COLUMN_LAST_UPDATED = "last_update_date";


    //Create constants for column names of Product Table
    public final static String COLUMN_DESCRIPTION = "description";
    public final static String COLUMN_PRICE = "price";
    public final static String COLUMN_IMAGE_PATH = "image_path";
    public final static String COLUMN_CATEGORY_ID = "category_id";

    public static final String COLUMN_PURCHASE_PRICE = "purchase_price";
    public static final String COLUMN_CHECKOUT_COMPLETED = "checkout_completed";
    public static final String OPEN_CART_EXITS = "open_cart_exists";
    public static final String SERIALIZED_CUSTOMER = "serialized_customer";
    public static final String COLUMN_PAYMENT_TYPE = "payment_type";
    public static final String COLUMN_PAYMENT_STATUS = "payment_status";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_TRANSACTION_ID = "transaction_id";
}
