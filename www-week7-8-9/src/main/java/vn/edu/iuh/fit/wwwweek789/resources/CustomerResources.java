package vn.edu.iuh.fit.wwwweek789.resources;

import vn.edu.iuh.fit.wwwweek789.services.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class CustomerResources {
   // @Autowired
    private ProductServices services;
    @GetMapping("/api/v1/health")
    public ResponseEntity<String> heartbeat(){
        return ResponseEntity.ok("live");
    }
    
}
