package com.willjsporter;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        FrequencyReader frequencyReader = new FrequencyReader("/home/will/projects/adventofcode2018/day1Input1.txt");
        frequencyReader.getFinalFrequency();
        System.out.println(frequencyReader.getFrequencyRepetitions());
    }
}
