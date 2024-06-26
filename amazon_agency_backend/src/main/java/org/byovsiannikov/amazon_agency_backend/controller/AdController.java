package org.byovsiannikov.amazon_agency_backend.controller;

import org.byovsiannikov.amazon_agency_backend.bom.Advertising;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AdController {

    @GetMapping("/ads")
    public List<Advertising> getAds () {
        return Arrays.asList(new Advertising("Google", 100), new Advertising("Tesla", 200), new Advertising("Microsoft", 150));
    }
}
