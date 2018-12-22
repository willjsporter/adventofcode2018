package com.willjsporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FrequencyReader {
    private File file;// = new File("/home/will/projects/adventofcode2018/day1Input1.txt");
    private int frequencyShift = 0;
    private Scanner fileContentsScanner;
    private List<Integer> fileContents;

    public FrequencyReader(String filePath) {
        this.file = new File(filePath);
        try {
            this.fileContentsScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.fileContents = Files
                    .lines(Paths.get(filePath))
                    .map(num -> Integer.parseInt(num))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFinalFrequency() {
        while (fileContentsScanner.hasNextLine()) {
            frequencyShift += fileContentsScanner.nextInt();
        }
        System.out.println(frequencyShift);

    }

    public int getFrequencyRepetitions() {
        int fileLength = fileContents.size();
        List<Integer> frequencyShiftList = new ArrayList();
        int totalFrequencyShift = 0;

        frequencyShiftList.add(totalFrequencyShift);

        int i = 0;
        while(!frequencyShiftList.contains(fileContents.get(i % fileLength ) + totalFrequencyShift)) {
            totalFrequencyShift += fileContents.get(i % fileLength);
            frequencyShiftList.add(totalFrequencyShift);
            i++;
        }

        frequencyShiftList.add(fileContents.get(i % fileLength));
        totalFrequencyShift += fileContents.get(i % fileLength);
        return totalFrequencyShift;
    }
}

