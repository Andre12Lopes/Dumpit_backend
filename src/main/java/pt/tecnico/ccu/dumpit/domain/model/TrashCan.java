package pt.tecnico.ccu.dumpit.domain.model;

public class TrashCan extends Entity
{
    private final long distance;

    public TrashCan(long id, String address, long distance) {
        super(id, address);
        this.distance = distance;
    }

    public long getDistance()
    {
        return distance;
    }
}
