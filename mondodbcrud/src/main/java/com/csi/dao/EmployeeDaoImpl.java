package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee signUp(Employee employee){
       return employeeRepository.save(employee);
    }
    public boolean signIn(String empEmail , String empPass){
        boolean flag = false;
        for( Employee employee : employeeRepository.findAll()){
            if(employee.getEmpEmail().equals(empEmail) && employee.getEmpPass().equals(empPass)){
                flag = true;
            }
        }
        return  flag;
    }

    public List<Employee> getAllData(){
        return  employeeRepository.findAll();
    }
    public Optional<Employee> getDataById(int empId){
        return employeeRepository.findById(empId);
    }
    public List<Employee> getDataByName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }
    public Employee getDataByEmail(String empEmail){
        return employeeRepository.findByEmpEmail(empEmail);
    }
    public Employee getDataByContact(long empContact){
        return employeeRepository.findByEmpContact(empContact);
    }

    public List<Employee> getDtaUsingAnyInput(String input){
        List <Employee> employees = new ArrayList<>();
        for (Employee employee : getAllData()){
            if(employee.getEmpName().equals(input) || employee.getEmpEmail().equals(input)||String.valueOf(employee.getEmpId()).equals(input) || String.valueOf(employee.getEmpContact()).equals(input) || String.valueOf(employee.getEmpSalary()).equals(input) || String.valueOf(employee.getEmpAge()).equals(input) || String.valueOf(employee.getEmpDob()).equals(input)){
                employees.add(employee);
            }
        }
        return employees;
    }
   public List<Employee> sortByName(){
        return getAllData().stream().sorted((e1,e2)-> e1.getEmpName()
                .compareTo(e2.getEmpName())).collect(Collectors.toList());
   }
    public List<Employee> sortById(){
        return getAllData().stream().sorted(Comparator.comparingInt(Employee:: getEmpId)).collect(Collectors.toList());
    }
    public List<Employee> sortBySalary(){
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee :: getEmpSalary)).collect(Collectors.toList());
    }
    public List<Employee> sortByAge(){
        return getAllData().stream().sorted(Comparator.comparingInt(Employee :: getEmpAge)).collect(Collectors.toList());
    }
    public List<Employee> sortByDob(){
        return getAllData().stream().sorted((e1,e2)-> e1.getEmpDob()
                .compareTo(e2.getEmpDob())).collect(Collectors.toList());
    }
    public List<Employee> filterBySalary(double empSalary){
        return getAllData().stream().filter(emp->emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
    }
    public  boolean loanEligibility(String input){
        boolean flag = false;
        for(Employee employee : getAllData()){
            if (employee.getEmpName().equals(input) || employee.getEmpEmail().equals(input) || String.valueOf(employee.getEmpId()).equals(input)|| String.valueOf(employee.getEmpContact()) .equals(input) || String.valueOf(employee.getEmpSalary()).equals(input)){
                if(employee.getEmpSalary()>=5000){
                    flag=true;
                }
            }
        }
        return flag;
    }
    public Employee updateData(Employee employee){
        return  employeeRepository.save(employee);
    }
    public void deleteDataById(int empId){
        employeeRepository.deleteById(empId);
    }
    public void deleteAllData(){
        employeeRepository.deleteAll();
    }
   public Optional<Employee> fetchSecondLargestSalary(){
        Optional<Employee> employee = employeeRepository.findAll().stream().sorted(Comparator.comparingDouble(Employee:: getEmpSalary).reversed()).skip(1).findFirst();
        return  employee;
   }

}
