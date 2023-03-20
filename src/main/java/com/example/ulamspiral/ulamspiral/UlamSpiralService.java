package com.example.ulamspiral.ulamspiral;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UlamSpiralService {
    public int[][] getRawSpiral(String length, String onlyPrimes) {
        int edgeLength;
        boolean showOnlyPrimes = false;

        // check is possible to cast length to integer. If not assign value 9
        try {
            edgeLength = Integer.parseInt(length);
        } catch (NumberFormatException e) {
            edgeLength = 9;
        }
        showOnlyPrimes = Boolean.parseBoolean(onlyPrimes);

        return UlamSpiral.getSpiral(edgeLength, showOnlyPrimes);
    }

    public String[][] getTextSpiral(String length, String onlyPrimes) {
        int[][] spiral = getRawSpiral(length, onlyPrimes);
        String[][] resultSpiral = new String[spiral.length][spiral[0].length];

        // convert integer arrays to string arrays. Zeros(not prime numbers if onlyPrimes is true) will be replaced by " "
        for (int i=0; i<spiral.length; i++) {
            for (int j=0; j<spiral[i].length; j++) {
                if (spiral[i][j] != 0) {
                    resultSpiral[i][j] = String.valueOf(spiral[i][j]);
                }
                else {
                    resultSpiral[i][j] = " ";
                }
            }
        }

        return resultSpiral;
    }

    public String getMain(Model model, String length, String onlyprimes) {
        if (length.equals("0")) {
            return "main"; }

        model.addAttribute("spiral", getTextSpiral(length, onlyprimes));

        return "main";
    }
}
