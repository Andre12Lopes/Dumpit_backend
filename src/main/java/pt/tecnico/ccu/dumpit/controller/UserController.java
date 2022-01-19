package pt.tecnico.ccu.dumpit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.tecnico.ccu.dumpit.domain.model.Transaction;
import pt.tecnico.ccu.dumpit.domain.model.User;
import pt.tecnico.ccu.dumpit.dto.TransactionDTO;
import pt.tecnico.ccu.dumpit.dto.UserDTO;
import pt.tecnico.ccu.dumpit.service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserDTO toDTO(User user)
    {
        return new UserDTO(Long.toString(user.getId()), user.getAddress(), user.getName(), user.getNif(), user.getPhoneNumber(), user.getEmail(), Double.toString(20.5));
    }

    private List<UserDTO> toDTOs(List<User> users)
    {
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private TransactionDTO toDTO(Transaction transaction)
    {
        return new TransactionDTO(transaction.getPlace(), transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), Double.toString(transaction.getTokenAmount()));
    }

    private List<TransactionDTO> toDTOsTransactions(List<Transaction> transactions)
    {
        return transactions.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> all()
    {
        return new ResponseEntity<>(toDTOs(userService.all()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getShop(@PathVariable long id)
    {
        User user = userService.findUser(id);

        if (user != null)
        {
            return new ResponseEntity<>(toDTO(user), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/shopTransactions")
    public ResponseEntity<List<TransactionDTO>> getUserShopTransactions(@PathVariable long id)
    {
        User user = userService.findUser(id);

        if (user != null)
        {
            return new ResponseEntity<>(toDTOsTransactions(user.getShopTransactions()), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/trashCanTransactions")
    public ResponseEntity<List<TransactionDTO>> getUserTrashCanTransactions(@PathVariable long id)
    {
        User user = userService.findUser(id);

        if (user != null)
        {
            return new ResponseEntity<>(toDTOsTransactions(user.getTrashCanTransactions()), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
