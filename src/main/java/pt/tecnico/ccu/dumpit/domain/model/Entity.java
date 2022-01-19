package pt.tecnico.ccu.dumpit.domain.model;

public abstract class Entity
{
    private final long id;
    private final String address;

    public Entity(long id, String address) {
        this.id = id;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
