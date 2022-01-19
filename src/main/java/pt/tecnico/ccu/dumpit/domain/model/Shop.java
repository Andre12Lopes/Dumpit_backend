package pt.tecnico.ccu.dumpit.domain.model;

public class Shop extends Entity
{
    private final String name;

    public Shop(long id, String address, String name)
    {
        super(id, address);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
