package pt.tecnico.ccu.dumpit.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class User extends Entity
{
    private final String name;
    private final String nif;
    private final String phoneNumber;
    private final String email;
    private final String accountAddress;
    private final String privateKey;
    private final Queue<Transaction> shopTransactions;
    private final Queue<Transaction> trashCanTransactions;

    public User(long id, String address, String name, String nif, String phoneNumber, String email, String accountAddress, String privateKey)
    {
        super(id, address);
        this.name = name;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountAddress = accountAddress;
        this.privateKey = privateKey;
        this.shopTransactions = new ConcurrentLinkedQueue<>();
        this.trashCanTransactions = new ConcurrentLinkedQueue<>();
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

    public String getAccountAddress()
    {
        return accountAddress;
    }

    public String getPrivateKey()
    {
        return privateKey;
    }

    public Queue<Transaction> getShopTransactions()
    {
        return shopTransactions;
    }

    public void addShopTransaction(Transaction transaction)
    {
        shopTransactions.add(transaction);
    }

    public Queue<Transaction> getTrashCanTransactions()
    {
        return trashCanTransactions;
    }

    public void addTrashCanTransaction(Transaction transaction)
    {
        trashCanTransactions.add(transaction);
    }
}
