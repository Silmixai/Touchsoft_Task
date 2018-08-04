package com.mixail.util;


import com.mixail.model.Event;
import com.mixail.model.EventType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TimeManager {

    private static final String REGEX_SPLIT_FILE = "\\s+";
    private static final String REGEX_SPLIT_TIME = ":";


    private static List<Event> getSortedEventsList(String filePath) {

        ArrayList<Event> events = new ArrayList<>();
        try {
            List<String> strings = Files.readAllLines(Paths.get(filePath));
            strings.forEach((oneLine) -> {
                String[] staffTime = oneLine.split(REGEX_SPLIT_FILE);
                LocalTime arrive = getTime(staffTime[0]);
                LocalTime leave = getTime(staffTime[1]);
                events.add(new Event(arrive, EventType.COME));
                events.add(new Event(leave, EventType.LEAVE));

            });

        } catch (IOException e) {
            System.err.println(String.format("A problem with   reading %s file: %s", filePath, e.getMessage()));
        }

        Collections.sort(events);
        return events;
    }


    public static int getMaxOfEmployees(String filePath) {
        int count = 0;
        List<Event> events = getSortedEventsList(filePath);
        List<Integer> listOfCount = new ArrayList<>();

        int j = 0;
        while (j < events.size() - 1) {
            if (events.get(j).getTime().equals(events.get(j + 1).getTime()) && events.get(j).getType() != events.get(j + 1).getType()) {
                count++;
            }
            j++;
        }

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getType() == EventType.COME) {
                count++;
                listOfCount.add(count);

            } else {
                count--;
                listOfCount.add(count);
            }
        }
        int max = Collections.max(listOfCount);
        return max;
    }

    private static LocalTime getTime(String stringToParse) {
        String[] str = stringToParse.split(REGEX_SPLIT_TIME);
        LocalTime time = LocalTime.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        return time;

    }

}
