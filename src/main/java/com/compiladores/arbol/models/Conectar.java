
package com.compiladores.arbol.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
 
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("TESTDB2");
        dataSource.setPassword("Oracle_11g");
        return dataSource;
        
    }
}
