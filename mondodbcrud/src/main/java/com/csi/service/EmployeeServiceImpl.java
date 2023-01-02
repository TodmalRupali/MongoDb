package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDao;
    public Employee signUp(Employee employee){
        return employeeDao.signUp(employee);
    }
    public boolean signIn(String empEmail , String empPass){
       return  employeeDao.signIn(empEmail,empPass);
    }

    public List<Employee> getAllData(){
        return  employeeDao.getAllData();
    }
    public Optional<Employee> getDataById(int empId){
        return employeeDao.getDataById(empId);
    }
    public List<Employee> getDataByName(String empName) {
        return employeeDao.getDataByName(empName);
    }
    public Employee getDataByEmail(String empEmail){
        return employeeDao.getDataByEmail(empEmail);
    }
    public Employee getDataByContact(long empContact){
        return employeeDao.getDataByContact(empContact);
    }

    public List<Employee> getDtaUsingAnyInput(String input){

        return employeeDao.getDtaUsingAnyInput(input);
    }
    public List<Employee> sortByName(){
        return employeeDao.sortByName();
    }
    public List<Employee> sortById(){
        return employeeDao.sortById();
    }
    public List<Employee> sortBySalary(){
        return employeeDao.sortBySalary();
    }
    public List<Employee> sortByAge(){
        return employeeDao.sortByAge();
    }
    public List<Employee> sortByDob(){
        return employeeDao.sortByDob();
    }
    public List<Employee> filterBySalary(double empSalary){
        return employeeDao.filterBySalary(empSalary);
    }
    public  boolean loanEligibility(String input){

        return employeeDao.loanEligibility(input);
    }
    public Employee updateData(Employee employee){
        return  employeeDao.updateData(employee);
    }
    public void deleteDataById(int empId){
        employeeDao.deleteDataById(empId);
    }
    public void deleteAllData(){
        employeeDao.deleteAllData();
    }
    public Optional<Employee> fetchSecondLargestSalary(){
        return  employeeDao.fetchSecondLargestSalary();
    }

}
