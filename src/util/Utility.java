package util;

import model.Slot;

import java.time.LocalTime;

public class Utility {
    public static Slot convertStringToSlot(String timeString){
        Slot slot = new Slot();
        String [] time = timeString.split(":");
        slot.setStart(  LocalTime.of(Integer.parseInt(time[0]),0) );
        slot.setEnd(  LocalTime.of(Integer.parseInt(time[1]),0) );
        return slot;
    }
}
