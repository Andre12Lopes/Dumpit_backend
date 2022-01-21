package pt.tecnico.ccu.dumpit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.tecnico.ccu.dumpit.request.CreateTransactionRequest;
import pt.tecnico.ccu.dumpit.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/api/transaction")
public class TransactionController
{
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createTransaction(@RequestBody CreateTransactionRequest request)
    {
        try
        {
            transactionService.create(request.getUserId(), request.getPlace(), request.getTokenAmount());

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return new ResponseEntity<>("[ERROR] Unable to process transaction", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
