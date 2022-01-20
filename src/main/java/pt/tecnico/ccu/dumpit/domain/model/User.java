package pt.tecnico.ccu.dumpit.domain.model;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class User extends Entity
{
    private final String name;
    private final String nif;
    private final String phoneNumber;
    private final String email;
    private final String accountAddress;

    private final List<Transaction> shopTransactions;
    private final List<Transaction> trashCanTransactions;
    private final Web3j web3j;

    public User(long id, String address, String name, String nif, String phoneNumber, String email, String accountAddress) {
        super(id, address);
        this.name = name;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountAddress = accountAddress;

        this.shopTransactions = new ArrayList<>();
        this.trashCanTransactions = new ArrayList<>();
        this.web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
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

    public String getTokens()
    {
        try
        {
            BigInteger balance = web3j.ethGetBalance(accountAddress, DefaultBlockParameterName.LATEST).send().getBalance();

            return Convert.fromWei(balance.toString(), Convert.Unit.ETHER).toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return "N/A";
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
