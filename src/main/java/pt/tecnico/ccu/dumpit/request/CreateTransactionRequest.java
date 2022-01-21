package pt.tecnico.ccu.dumpit.request;


public class CreateTransactionRequest
{
    private String userId;
    private String place;
    private String tokenAmount;

    public CreateTransactionRequest() { }

    public CreateTransactionRequest(String userId, String place, String tokenAmount)
    {
        this.userId = userId;
        this.place = place;
        this.tokenAmount = tokenAmount;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getTokenAmount()
    {
        return tokenAmount;
    }

    public void setTokenAmount(String tokenAmount)
    {
        this.tokenAmount = tokenAmount;
    }
}
