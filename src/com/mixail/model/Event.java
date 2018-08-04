package com.mixail.model;
import java.time.LocalTime;


//This class represents one event  with the field  TypeOfEvent ( COME and  LEAVE ) and the time when this event occurred

public class Event implements Comparable {
    private LocalTime time;
    private EventType type;

    public LocalTime getTime() {
        return time;
    }

    public  EventType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "time=" + time +
                ", type=" + type +
                '}';
    }


    public Event(LocalTime time,  EventType type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        Event tmp = (Event) o;
        if (this.time.isBefore(tmp.time)) {
            return -1;
        } else if (this.time.isAfter(tmp.time)) {
            return 1;
        }
        return 0;
    }
}
