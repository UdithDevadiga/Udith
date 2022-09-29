package com.robosoft.insurance.service;

import com.robosoft.insurance.modal.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getInvolved(int year) {
        String query = "select count(distinct(Participated.driver_id)) from Accident inner join participated using(report_number) where year(accd_date)='"+year+"'";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }

    public int getCarBelong(String name) {
        String query = "select count(Participated.driver_id) from Person inner join participated using(driver_id) where name= '"+name+"'";
        return jdbcTemplate.queryForObject(query,Integer.class);
    }

    public int updateDamageAmount(int report_number,String regno,int damage_amount){
        String query = "update participated set damage_amount='"+damage_amount +"' where regno='"+regno+"' and report_number='"+report_number+"'";
        return jdbcTemplate.update(query);
    }

//    public int updateDamageAmount(Participated participated){
//        String query = "update participated set damage_amount='"+damage_amount +"' where regno='"+regno+"' and report_number='"+report_number+"'";
//        return jdbcTemplate.update(query);
//    }


    public int createTablePerson() {
        String query = "Create table if not exists Person(driver_id varchar(20) primary key,name varchar(20),address varchar(20))";
        int status=this.jdbcTemplate.update(query);
        return status;
    }

    public int createTableCar() {
        String query = "Create table if not exists Car(regno varchar(20) primary key,model varchar(20),year int)";
        int status=this.jdbcTemplate.update(query);
        return status;
    }

    public int createTableAccident() {
        String query = "Create table if not exists Accident(reportNumber int primary key,accd_date Date,location varchar(20))";
        int status=this.jdbcTemplate.update(query);
        return status;
    }

    public int createTableOwns() {
        String query = "Create table if not exists Owns(driver_id varchar(20),regno varchar(20),primary key(driver_id,regno),foreign key(driver_id) references Person(driver_id),foreign key(regno) references Car(regno))";
        int status=this.jdbcTemplate.update(query);
        return status;
    }

    public int createTableParticipated() {
        String query = "Create table if not exists Participated(driver_id varchar(20),regno varchar(20),reportNumber int,damage_amount int,primary key(driver_id,regno,reportNumber),foreign key(driver_id,regno) references Owns(driver_id,regno),foreign key(reportNumber) references Accident(reportNumber))";
        int status=this.jdbcTemplate.update(query);
        return status;
    }

    public int insertValuesPerson(Person person) {
        String query = "Insert into Person values(?,?,?)";
        int status = jdbcTemplate.update(query,(preparedStatement)->{
            preparedStatement.setString(1,person.getDriver_id());
            preparedStatement.setString(2,person.getName());
            preparedStatement.setString(3,person.getAddress());;
        });
        return status;

    }

    public int insertValuesCar(Car car) {
        String query = "Insert into Car values(?,?,?)";
        int status = jdbcTemplate.update(query,(preparedStatement)->{
            preparedStatement.setString(1, car.getRegno());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
        });
        return status;
    }

    public int insertValuesAccident(Accident accident) {
        String query = "Insert into Accident values(?,?,?)";
        int status = jdbcTemplate.update(query,(preparedStatement)->{
            preparedStatement.setInt(1, accident.getReportNumber());
            preparedStatement.setDate(2, (Date) accident.getAccd_date());
            preparedStatement.setString(3,accident.getLocation());
        });
        return status;
    }

    public int insertValuesOwns(Owns owns) {
        String query = "Insert into Owns values(?,?)";
        int status = jdbcTemplate.update(query,(preparedStatement)->{
            preparedStatement.setString(1, owns.getDriver_id());
            preparedStatement.setString(2, owns.getRegno());
        });
        return status;
    }

    public int insertValuesParticipated(Participated participated) {
        String query = "Insert into Participated values(?,?,?,?)";
        int status = jdbcTemplate.update(query,(preparedStatement)->{
            preparedStatement.setString(1, participated.getDriver_id());
            preparedStatement.setString(2, participated.getRegno());
            preparedStatement.setInt(3, participated.getReport_number());
            preparedStatement.setInt(4, participated.getDamage_amount());
        });
        return status;
    }

    public int deleteAllPerson(){
        String paquery = "Delete from Participated";
        String oquery = "Delete from Owns";
        String pequery = "Delete from Person";
        int status1 = jdbcTemplate.update(paquery);
        int status2 = jdbcTemplate.update(oquery);
        int status3 = jdbcTemplate.update(pequery);
        return status1+status2+status3;
    }

    public int deleteAllCar(){
        String query = "Delete from Car";
        return jdbcTemplate.update(query);
    }

    public int deleteAllAccident(){
        String query = "Delete from Accident";
        return jdbcTemplate.update(query);
    }

    public int deleteAllOwns(){
        String query = "Delete from Owns";
        return jdbcTemplate.update(query);
    }

    public int deleteAllParticipated(){
        String query = "Delete from Participated";
        return jdbcTemplate.update(query);
    }

    public int deletePersonById(String driver_id) {
        String query = "Delete from Person where driver_id = '"+driver_id+"'";
        return jdbcTemplate.update(query);
    }

    public int deleteCarById(String regno) {
        String query = "Delete from Car where regno = '"+regno+"'";
        return jdbcTemplate.update(query);
    }

    public int deleteAccidentById(int reportNumber) {
        String query = "Delete from Accident where reportNumber = '"+reportNumber+"'";
        return jdbcTemplate.update(query);
    }

    public int deleteOwnsById(String driver_id,String regno) {
        String query = "Delete from Person where driver_id = '"+driver_id+"' and regno = '"+regno+"'";
        return jdbcTemplate.update(query);
    }

    public int deleteParticipatedById(String driver_id,String regno,int reportNumber) {
        String query = "Delete from Participated where driver_id = '"+driver_id+"' and regno = '"+regno+"' and reportNumber = '"+reportNumber+"'";
        return jdbcTemplate.update(query);
    }
   public List<Owns> getAllOwns() {
        String query = "Select * from owns";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Owns.class));
   }


}

