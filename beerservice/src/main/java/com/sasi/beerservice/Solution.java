package com.sasi.beerservice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */



public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String gene = sc.nextLine();

        int result = steadyGene(gene);

        System.out.println(result);
    }
    public static int steadyGene(String gene) {
        int minLength = gene.length();
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('G',0);
        mapping.put('A',0);
        mapping.put('C',0);
        mapping.put('T',0);
        int expectedLength = gene.length()/4;
        for(int i=0;i<gene.length();i++)
            mapping.put(gene.charAt(i),mapping.get(gene.charAt(i))+1);
        for(Character c:mapping.keySet())
            mapping.put(c,Math.max(0,mapping.get(c)-expectedLength));
        if(mapping.get('A')==0 && mapping.get('G')==0 && mapping.get('C')==0 && mapping.get('T')==0 )
            return 0;

        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('G',0);
        expectedMap.put('A',0);
        expectedMap.put('C',0);
        expectedMap.put('T',0);

        int start = 0;
        int end =0;
        while(end<=gene.length()-1 && start<=gene.length()-1){
            expectedMap.put(gene.charAt(start),expectedMap.get(gene.charAt(start))+1);
            if(expectedMap.get('A')>=mapping.get('A') && expectedMap.get('C')>=mapping.get('C')
                    && expectedMap.get('G') >= mapping.get('G') && expectedMap.get('T')>=mapping.get('T')){
                minLength = Math.min(minLength, start-end+1);
                while(expectedMap.get(gene.charAt(end)) > mapping.get(gene.charAt(end))){
                    expectedMap.put(gene.charAt(end),expectedMap.get(gene.charAt(end))-1);
                    end += 1;
                    minLength = Math.min(minLength, start-end+1);
                }
            }
            start+= 1;
        }
        return minLength;

    }
}






