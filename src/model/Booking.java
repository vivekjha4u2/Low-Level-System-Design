package model;

public class Booking {
    private String bookingId;
    private User user;
    private ConferenceRoom room;
    private Slot slot;

    public Booking(String bookingId, User user, ConferenceRoom room, Slot slot) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.slot = slot;
    }

    public Booking() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConferenceRoom getRoom() {
        return room;
    }

    public void setRoom(ConferenceRoom room) {
        this.room = room;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
