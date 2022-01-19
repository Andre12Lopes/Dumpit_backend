package pt.tecnico.ccu.dumpit.domain.repository;

import org.springframework.stereotype.Repository;
import pt.tecnico.ccu.dumpit.domain.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepository
{
    private final List<User> users;
    private final List<Shop> shops;
    private final List<TrashCan> trashCans;

    public DataRepository()
    {
        this.users = new ArrayList<>();
        this.shops = new ArrayList<>();
        this.trashCans = new ArrayList<>();
        populate();
    }

    public List<User> getUsers()
    {
        return users;
    }

    public User getUser(long id)
    {
        return getEntity(users, id);
    }

    public List<Shop> getShops()
    {
        return shops;
    }

    public Shop getShop(long id)
    {
        return getEntity(shops, id);
    }

    public List<TrashCan> getTrashCans() {
        return trashCans;
    }

    public TrashCan getTrashCan(long id)
    {
        return getEntity(trashCans, id);
    }

    private <T extends Entity> T getEntity(List<? extends Entity> list, long id)
    {
        return (T) list.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    private void populate()
    {
        User user = new User(1L, "Av. Rovisco Pais 1, 1049-001 Lisboa", "Joana", "999999999", "+351 000000000", "joana@mail.pt");

        user.addShopTransaction(new Transaction("Pingo Doce", LocalDate.of(2021, 12, 15), -1));
        user.addShopTransaction(new Transaction("100 Montaditos", LocalDate.of(2021, 12, 5), -2.5));

        user.addTrashCanTransaction(new Transaction("Arco do Cego", LocalDate.of(2021, 12, 13), 0.3));
        user.addTrashCanTransaction(new Transaction("Bairro Alto", LocalDate.of(2021, 12, 11), 0.1));
        user.addTrashCanTransaction(new Transaction("Alameda", LocalDate.of(2021, 12, 5), 0.4));
        user.addTrashCanTransaction(new Transaction("Anjos", LocalDate.of(2021, 12, 5), 0.3));
        user.addTrashCanTransaction(new Transaction("Martim Moniz", LocalDate.of(2021, 12, 1), 0.1));

        users.add(user);

        shops.add(new Shop(1L, "Av. Barbosa Du Bocage 117, 1050-031 Lisboa", "Continente"));
        shops.add(new Shop(2L, "R. Dona Filipa de Vilhena 2, 1000-135 Lisboa", "Continente"));
        shops.add(new Shop(3L, "Av. de Paris 20-A, 1000-091 Lisboa", "Pingo Doce"));
        shops.add(new Shop(4L, "R. Carlos Mardel 12, 1900-122 Lisboa", "Pingo Doce"));
        shops.add(new Shop(5L, "Av. Visc. de Valmor 68, 1050-242 Lisboa", "Lidl"));
        shops.add(new Shop(6L, "R. Cordeiro de Sousa, 1050-077 Lisboa", "Lidl"));
        shops.add(new Shop(7L, "R. Filipe Folque 10, 1050-999 Lisboa", "ALDI"));
        shops.add(new Shop(8L, "R. Frederico George 20, 1600-414 Lisboa", "ALDI"));

        trashCans.add(new TrashCan(1L, "R. Barão de Sabrosa 104-172", 124L));
        trashCans.add(new TrashCan(2L, "R. Carvalho Araújo", 258L));
        trashCans.add(new TrashCan(3L, "R. Rosa Damasceno 2-22", 567L));
        trashCans.add(new TrashCan(4L, "R. Abade Faria 31", 845L));
        trashCans.add(new TrashCan(5L, "R. Jorge Castilho 1613f", 1056L));
    }
}
