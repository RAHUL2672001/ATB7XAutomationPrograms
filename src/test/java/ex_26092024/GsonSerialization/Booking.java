package ex_26092024.GsonSerialization;

public class Booking {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private BookingsDates bookingsDates;

    public BookingsDates getBookingsDates() {
        return bookingsDates;
    }

    public void setBookingsDates(BookingsDates bookingsDates) {
        this.bookingsDates = bookingsDates;
    }

    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
