package vn.edu.iuh.fit.wwwweek789.repositories;

import vn.edu.iuh.fit.wwwweek789.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}