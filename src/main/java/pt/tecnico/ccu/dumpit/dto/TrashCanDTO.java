package pt.tecnico.ccu.dumpit.dto;

import pt.tecnico.ccu.dumpit.domain.model.Entity;

public class TrashCanDTO
{
    private final String id;
    private final String address;
    private final long distance;

    public TrashCanDTO(String id, String address, long distance)
    {
        this.id = id;
        this.address = address;
        this.distance = distance;
    }

    public String getId()
    {
        return id;
    }

    public String getAddress()
    {
        return address;
    }

    public long getDistance()
    {
        return distance;
    }
}
