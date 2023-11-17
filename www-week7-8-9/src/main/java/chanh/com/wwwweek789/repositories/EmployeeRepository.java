package chanh.com.wwwweek789.repositories;

import chanh.com.wwwweek789.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}