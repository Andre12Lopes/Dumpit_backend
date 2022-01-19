package pt.tecnico.ccu.dumpit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tecnico.ccu.dumpit.domain.model.Shop;
import pt.tecnico.ccu.dumpit.dto.ShopDTO;
import pt.tecnico.ccu.dumpit.service.ShopService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shop")
public class ShopController
{
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    private ShopDTO toDTO(Shop shop)
    {
        return new ShopDTO(Long.toString(shop.getId()), shop.getAddress(), shop.getName());
    }

    private List<ShopDTO> toDTOs(List<Shop> shops)
    {
        return shops.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/")
    public ResponseEntity<List<ShopDTO>> all()
    {
        return new ResponseEntity<>(toDTOs(shopService.all()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShop(@PathVariable long id)
    {
        Shop shop = shopService.findShop(id);

        if (shop != null)
        {
            return new ResponseEntity<>(toDTO(shop), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
