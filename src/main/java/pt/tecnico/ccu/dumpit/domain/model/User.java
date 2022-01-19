package pt.tecnico.ccu.dumpit.domain.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity
{
    private final String name;
    private final String nif;
    private final String phoneNumber;
    private final String email;
    private final List<Transaction> shopTransactions;
    private final List<Transaction> trashCanTransactions;

    public User(long id, String address, String name, String nif, String phoneNumber, String email) {
        super(id, address);
        this.name = name;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shopTransactions = new ArrayList<>();
        this.trashCanTransactions = new ArrayList<>();
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

    public List<Transaction> getShopTransactions()
    {
        return shopTransactions;
    }

    public void addShopTransaction(Transaction transaction)
    {
        shopTransactions.add(transaction);
    }

    public List<Transaction> getTrashCanTransactions()
    {
        return trashCanTransactions;
    }

    public void addTrashCanTransaction(Transaction transaction)
    {
        trashCanTransactions.add(transaction);
    }
}
