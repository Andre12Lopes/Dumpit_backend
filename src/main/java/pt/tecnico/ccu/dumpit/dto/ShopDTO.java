package pt.tecnico.ccu.dumpit.dto;

public class ShopDTO
{
    private final String id;
    private final String address;
    private final String name;

    public ShopDTO(String id, String address, String name)
    {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getAddress()
    {
        return address;
    }

    public String getName()
    {
        return name;
    }
}
