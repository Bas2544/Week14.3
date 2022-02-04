package nvc.it.springapi.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.springapi.model.Product;
import nvc.it.springapi.service.ProductSevice;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductSevice productSevice;

    @GetMapping("")
    public ResponseEntity<Object> getAllProduct(){
        List<Product> products = productSevice.getProducts();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Success!");
        map.put("data", products);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }
}
