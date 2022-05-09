package com.company;

import java.sql.SQLException;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
	// write your code here


        UI ui = new UI();
        ui.runRestaurant();
        exit(0);

    }



    public void database() throws SQLException {

        //db.insert();
        //db.update();
        //db.selectAll();
        //db.delete();
        //db.selectOneMore("lalala");
    }
}
