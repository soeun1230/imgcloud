package iise_capston.imgcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/api/hello")
    public String test(){
        logger.info("String "+ "success");
        return "success";
    }

    @GetMapping("/api/json")
    public ResponseEntity<Map<String, Object>> jsonTest(){
        Map<String, Object> responseBody = new HashMap<>();
        logger.info("Json "+ "good");
        responseBody.put("hello", "good");
        return ResponseEntity.ok(responseBody);
    }
}
