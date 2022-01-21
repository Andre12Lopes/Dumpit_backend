package pt.tecnico.ccu.dumpit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.ccu.dumpit.Utils.Blockchain;
import pt.tecnico.ccu.dumpit.domain.model.Transaction;
import pt.tecnico.ccu.dumpit.domain.model.User;
import pt.tecnico.ccu.dumpit.domain.repository.DataRepository;

import java.time.LocalDate;

@Service
public class TransactionService
{
    private final DataRepository dataRepository;

    @Autowired
    public TransactionService(DataRepository dataRepository)
    {
        this.dataRepository = dataRepository;
    }

    public void create(String userId, String place, String tokenAmount) throws Exception
    {
        double amount = Double.parseDouble(tokenAmount);

        if (amount == 0)
        {
            return;
        }

        User user = dataRepository.getUser(Long.parseLong(userId));

        Blockchain.createTransaction(amount, user.getAccountAddress(), user.getPrivateKey());

        Transaction transaction = new Transaction(place, LocalDate.now(), amount);

        if (amount > 0)
        {
            user.addTrashCanTransaction(transaction);
        }
        else
        {
            user.addShopTransaction(transaction);
        }
    }
}
