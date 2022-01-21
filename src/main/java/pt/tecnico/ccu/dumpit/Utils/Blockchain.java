package pt.tecnico.ccu.dumpit.Utils;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Blockchain
{
    private static final Web3j web3j = Web3j.build(new HttpService(BlockchainData.RPC_SERVER_ADDRESS));

    public static String getUserTokens(String accountAddress)
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

    public static void createTransaction(double amount, String userAccountAddress, String userPrivateKey) throws Exception
    {
        Credentials credentials = amount > 0 ? Credentials.create(BlockchainData.GOVERNMENT_PRIVATE_KEY) : Credentials.create(userPrivateKey);
        String toAddress = amount > 0 ? userAccountAddress : BlockchainData.GOVERNMENT_ACCOUNT;

        amount = amount < 0 ? amount * -1 : amount;

        Transfer.sendFunds(web3j, credentials, toAddress, BigDecimal.valueOf(amount), Convert.Unit.ETHER).send();
    }
}
