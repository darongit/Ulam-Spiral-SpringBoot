package com.example.ulamspiral.ulamspiral;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class UlamSpiral {
    public static final int MAX_EDGE_LENGTH = 31;
    public static final int MIN_EDGE_LENGTH = 3;

    /**
     *
     * @param edgeLength Length of edge size. Must be odd number. If not it will be incremented
     * @param onlyPrimes If true all not primes numbers will be replaced by 0
     * @return Array of arrays with generated Ulam's spiral
     */
    public static int[][] getSpiral(int edgeLength, boolean onlyPrimes) {
        // edge size must be odd number between MIN_LENGTH_SIZE and MAX_LENGTH_SIZE
        if (edgeLength<MIN_EDGE_LENGTH) edgeLength = MIN_EDGE_LENGTH;
        else if (edgeLength > MAX_EDGE_LENGTH) edgeLength = MAX_EDGE_LENGTH;
        else if (edgeLength % 2 == 0) edgeLength++;

        // create empty matrix
        int[][] spiral = new int[edgeLength][edgeLength];
        // set start position and get directions array
        int height = edgeLength/2;
        int width = edgeLength/2;
        char[] directions = getDirections(edgeLength);


        for (int i=0; i<edgeLength*edgeLength; i++) {
            if (!onlyPrimes) {
                spiral[height][width] = i+1;
            } else {
                if (isPrime(i+1)) {
                    spiral[height][width] = i+1;
                } else {
                    spiral[height][width] = 0;
                }
            }
            switch (directions[i]) {
                case 'r':
                    width++;
                    break;
                case 'u':
                    height--;
                    break;
                case 'l':
                    width--;
                    break;
                case 'd':
                    height++;
                    break;
            }

        }
        return spiral;
    }

    /**
     *
     * @param edgeLength
     * @return Array of chars where 'r' represents right, 'u' up, 'l' left and 'd' down
     */
    private static char[] getDirections(int edgeLength) {
        char[] directions = new char[edgeLength*edgeLength];
        char actualDirection = 'r';
        Map<Character, Character> nextStep = new HashMap<>(4);
        nextStep.put('r', 'u');
        nextStep.put('u', 'l');
        nextStep.put('l', 'd');
        nextStep.put('d', 'r');

        int idx = 0;
        int insideLoop = 1;
        mainLoop:
        while (true) {
            for (int i=0; i<2; i++) {
                for (int j=0; j<insideLoop; j++) {
                    if (idx >= directions.length-1) break mainLoop;
                    directions[idx++] = actualDirection;
                }
                actualDirection = nextStep.get(actualDirection);
            }
            insideLoop++;
        }

        return directions;
    }

    private static boolean isPrime(int n) {
        if (n<2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i=3; i<(int)Math.pow(n, 0.5)+1; i+=2) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
