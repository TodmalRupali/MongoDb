package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee , Integer> {
    public List<Employee> findByEmpName(String empName);
    public Employee findByEmpEmail(String empEmail);
    public Employee findByEmpContact(long empContact);

}
