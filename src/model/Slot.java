package model;

import java.time.LocalTime;

public class Slot {
    private LocalTime start;
    private LocalTime end;


    public Slot(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public Slot() {
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
