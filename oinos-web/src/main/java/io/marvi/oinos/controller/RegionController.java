package io.marvi.oinos.controller;

import io.marvi.oinos.model.Region;
import io.marvi.oinos.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
public class RegionController {

    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/list")
    public Iterable<Region> list() {
        return regionService.list();
    }

}
