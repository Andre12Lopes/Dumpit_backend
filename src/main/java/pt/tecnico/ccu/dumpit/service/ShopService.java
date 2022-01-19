package pt.tecnico.ccu.dumpit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.ccu.dumpit.domain.model.Shop;
import pt.tecnico.ccu.dumpit.domain.repository.DataRepository;

import java.util.List;

@Service
public class ShopService
{
    private final DataRepository dataRepository;

    @Autowired
    public ShopService(DataRepository dataRepository)
    {
        this.dataRepository = dataRepository;
    }

    public List<Shop> all()
    {
        return dataRepository.getShops();
    }

    public Shop findShop(long id)
    {
        return dataRepository.getShop(id);
    }
}
