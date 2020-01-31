package com.hci.Pome.configuration;

import org.h2.jdbcx.JdbcDataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Primary;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "mainDataSource")
    public DataSource createMainDataSource() {

        JdbcDataSource ds = new JdbcDataSource();

        return ds;
    }

}
