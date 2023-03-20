package com.example.ulamspiral.ulamspiral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UlamSpiralControllerAPI {

    private UlamSpiralService ulamSpiralService;

    @Autowired
    public UlamSpiralControllerAPI(UlamSpiralService ulamSpiralService) {
        this.ulamSpiralService = ulamSpiralService;
    }

    @GetMapping("/api/getrawspiral")
    public int[][] getRawSpiral(
            @RequestParam(defaultValue = "3") String length,
            @RequestParam(defaultValue = "false") String onlyprimes) {
        return ulamSpiralService.getRawSpiral(length, onlyprimes);
    }

    @GetMapping("/api/gettextspiral")
    public String[][] getTextSpiral(
            @RequestParam(defaultValue = "3") String length,
            @RequestParam(defaultValue = "false") String onlyprimes) {
        return ulamSpiralService.getTextSpiral(length, onlyprimes);
    }
}
