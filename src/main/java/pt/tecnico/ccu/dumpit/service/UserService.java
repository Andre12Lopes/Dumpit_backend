package pt.tecnico.ccu.dumpit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.ccu.dumpit.domain.model.User;
import pt.tecnico.ccu.dumpit.domain.repository.DataRepository;

import java.util.List;

@Service
public class UserService
{
    private final DataRepository dataRepository;

    @Autowired
    public UserService(DataRepository dataRepository)
    {
        this.dataRepository = dataRepository;
    }

    public List<User> all()
    {
        return dataRepository.getUsers();
    }

    public User findUser(long id)
    {
        return dataRepository.getUser(id);
    }
}
