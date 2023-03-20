package com.example.ulamspiral.ulamspiral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UlamSpiralController {
    private UlamSpiralService ulamSpiralService;
    @Autowired
    public UlamSpiralController(UlamSpiralService ulamSpiralService) {
        this.ulamSpiralService = ulamSpiralService;
    }

    @GetMapping("/")
    public String getMain(Model model, @RequestParam(defaultValue = "0") String length,@RequestParam(defaultValue = "false") String onlyprimes) {
        return ulamSpiralService.getMain(model, length, onlyprimes);
    }
}
