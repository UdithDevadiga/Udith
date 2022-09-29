package com.robosoft.insurance.controller;

import com.robosoft.insurance.modal.*;
import com.robosoft.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;
    @PostMapping("/createTablePerson")
    public int createTablePerson(){
        return insuranceService.createTablePerson();
    }
    @PostMapping("/createTableCar")
    public int createTableCar(){
        return insuranceService.createTableCar();
    }
    @PostMapping("/createTableAccident")
    public int createTableAccident(){
        return insuranceService.createTableAccident();
    }
    @PostMapping("/createTableOwns")
    public int createTableOwns(){
        return insuranceService.createTableOwns();
    }
    @PostMapping("/createTableParticipated")
    public int createTableParticipated(){
        return insuranceService.createTableParticipated();
    }
    @PostMapping("/insertPerson")
    public int insertValuesPerson(@RequestBody Person person) {
        return insuranceService.insertValuesPerson(person);
    }
    @PostMapping("/insertCar")
    public int insertValuesCar(@RequestBody Car car) {
        return insuranceService.insertValuesCar(car);
    }
    @PostMapping("/insertAccident")
    public int insertValuesAccident(@RequestBody Accident accident) {
        return insuranceService.insertValuesAccident(accident);
    }
    @PostMapping("/insertOwns")
    public int insertValuesOwns(@RequestBody Owns owns) {
        return insuranceService.insertValuesOwns(owns);
    }
    @PostMapping("/insertParticipated")
    public int insertValuesParticipated(@RequestBody Participated participated) {
        return insuranceService.insertValuesParticipated(participated);
    }
    @DeleteMapping("/deletePerson")
    public int deletePerson(){
        return insuranceService.deleteAllPerson();
    }
    @DeleteMapping("/deleteCar")
    public int deleteCar(){
        return insuranceService.deleteAllCar();
    }
    @DeleteMapping("/deleteAccident")
    public int deleteAccident(){
        return insuranceService.deleteAllAccident();
    }
    @DeleteMapping("/deleteOwns")
    public int deleteOwns(){
        return insuranceService.deleteAllOwns();
    }
    @DeleteMapping("/deleteParticipated")
    public int deleteParticipated(){
        return insuranceService.deleteAllParticipated();
    }
    @DeleteMapping("/deletePerson/{driver_id}")
    public int deletePersonById(@PathVariable String driver_id){
        return insuranceService.deletePersonById(driver_id);
    }
    @DeleteMapping("/deleteCar/{regno}")
    public int deleteCarById(@PathVariable String regno){
        return insuranceService.deleteCarById(regno);
    }
    @DeleteMapping("/deleteAccident/{report_number}")
    public int deleteAccidentById(@PathVariable int report_number){
        return insuranceService.deleteAccidentById(report_number);
    }
    @GetMapping("/getInvolvement/{year}")
    public int getInvolvedInAccident(@PathVariable int year){
        return insuranceService.getInvolved(year);
    }
    @GetMapping("/getCarBelongs/{name}")
    public int getCarBelonging(@PathVariable String name){
        return insuranceService.getCarBelong(name);
    }
    @PutMapping("/updateDamageAmount/{report_number}/{regno}")
    public int updateDamageAmount(@PathVariable int report_number,@PathVariable String regno,@RequestBody int damage_amount){
        return insuranceService.updateDamageAmount(report_number,regno,damage_amount);
    }
//    @PutMapping("/updateDamageAmount")
//    public int updateDamageAmount(Participated participated){
//        return insuranceService.updateDamageAmount(participated);
//    }
    @GetMapping("/getAllOwns")
    public List<Owns> getAllOwns() {
        return insuranceService.getAllOwns();
    }
}
