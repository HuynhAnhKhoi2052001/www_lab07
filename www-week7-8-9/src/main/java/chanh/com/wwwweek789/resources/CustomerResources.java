package chanh.com.wwwweek789.resources;

import chanh.com.wwwweek789.services.ProductServices;
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
