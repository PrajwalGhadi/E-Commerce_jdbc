package com.ecommerce.main;

import java.sql.Connection;

import com.ecommerce.config.DBconfig;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection con = DBconfig.getConnection();
    }
}
