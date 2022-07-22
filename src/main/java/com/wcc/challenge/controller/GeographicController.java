package com.wcc.challenge.controller;

import com.wcc.challenge.dto.GeographicDistanceDto;
import com.wcc.challenge.dto.GeographicDto;
import com.wcc.challenge.service.GeographicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GeographicController {

    private final GeographicService geopraphicService;

    public GeographicController(GeographicService geopraphicService) {
        this.geopraphicService = geopraphicService;
    }

    @GetMapping("/distance")
    public GeographicDistanceDto findDistance(@RequestParam String postCode, @RequestParam String postCode2){
        log.info("Calculating distance between postcode1: {}, postCode2: {} ", postCode,postCode2);
        return geopraphicService.findDistance(postCode,postCode2);
    }

    @PutMapping(value="/postcode")
    @ResponseStatus(HttpStatus.OK)
    public GeographicDto updatePostcode(@RequestBody GeographicDto geographic) {
        return geopraphicService.updateGeographic(geographic);

    }

}
