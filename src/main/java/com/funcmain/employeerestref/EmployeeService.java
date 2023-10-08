package com.funcmain.employeerestref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    static {
        employeeMap.put(1, new Employee(1, "Alex",
                "Titan", "U.S."));
        employeeMap.put(2, new Employee(2, "Love",
                "Dove", "India"));
        employeeMap.put(3, new Employee(3, "Ricky",
                "Picky", "U.K."));
        employeeMap.put(4, new Employee(4, "Tina",
                "Mina", "China"));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployee(Integer id) {
        return employeeMap.get(id);
    }

    public boolean createEmployee(Employee employee) {
        try {
            employeeMap.put(employee.getId(), employee);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
