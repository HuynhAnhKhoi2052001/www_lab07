package vn.edu.iuh.fit.wwwweek789.repositories;

import vn.edu.iuh.fit.wwwweek789.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//set run va doi ten duong dan
//@RepositoryRestResource(exported = true,collectionResourceRel = "cus",path = "cus")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select e from Customer e where e.name=?1")
    List<Customer> getCusByNameIndexParam(String name);

}