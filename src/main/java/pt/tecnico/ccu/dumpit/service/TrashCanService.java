package pt.tecnico.ccu.dumpit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.ccu.dumpit.domain.model.TrashCan;
import pt.tecnico.ccu.dumpit.domain.repository.DataRepository;

import java.util.List;

@Service
public class TrashCanService
{
    private final DataRepository dataRepository;

    @Autowired
    public TrashCanService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<TrashCan> all()
    {
        return dataRepository.getTrashCans();
    }

    public TrashCan findTrashCan(long id)
    {
        return dataRepository.getTrashCan(id);
    }
}
