package pt.tecnico.ccu.dumpit.dto;

import pt.tecnico.ccu.dumpit.domain.model.Entity;

public class UserDTO
{
    private final String id;
    private final String address;
    private final String name;
    private final String nif;
    private final String phoneNumber;
    private final String email;
    private final String tokens;

    public UserDTO(String id, String address, String name, String nif, String phoneNumber, String email, String tokens)
    {
        this.id = id;
        this.address = address;
        this.name = name;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tokens = tokens;
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

    public String getNif()
    {
        return nif;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTokens()
    {
        return tokens;
    }
}
