package pt.tecnico.ccu.dumpit.dto;

import java.time.LocalDate;

public class TransactionDTO {

    private final String place;
    private final String date;
    private final String tokenAmount;

    public TransactionDTO(String place, String date, String tokenAmount)
    {
        this.place = place;
        this.date = date;
        this.tokenAmount = tokenAmount;
    }

    public String getPlace()
    {
        return place;
    }

    public String getDate()
    {
        return date;
    }

    public String getTokenAmount()
    {
        return tokenAmount;
    }
}
