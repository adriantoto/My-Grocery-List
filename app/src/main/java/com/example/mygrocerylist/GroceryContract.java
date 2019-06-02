package com.example.mygrocerylist;

import android.provider.BaseColumns;

public class GroceryContract {

    // To define some strings constant

    private GroceryContract() {
    }

    public static final class GroceryEntry implements BaseColumns {
        public final static String TABLE_NAME = "groceryList";
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_AMOUNT = "amount";
        public final static String COLUMN_TIMESTAMP = "timestamp";
    }

}
