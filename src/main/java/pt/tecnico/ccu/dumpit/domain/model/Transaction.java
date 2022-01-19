package pt.tecnico.ccu.dumpit.domain.model;

import java.time.LocalDate;

public class Transaction {

    private final String place;
    private final LocalDate date;
    private final double tokenAmount;

    public Transaction(String place, LocalDate date, double tokenAmount)
    {
        this.place = place;
        this.date = date;
        this.tokenAmount = tokenAmount;
    }

    public String getPlace()
    {
        return place;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public double getTokenAmount()
    {
        return tokenAmount;
    }
}
