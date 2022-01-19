package pt.tecnico.ccu.dumpit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.tecnico.ccu.dumpit.domain.model.TrashCan;
import pt.tecnico.ccu.dumpit.dto.TrashCanDTO;
import pt.tecnico.ccu.dumpit.service.TrashCanService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/trashcan")
public class TrashCanController
{
    private final TrashCanService trashCanService;

    @Autowired
    public TrashCanController(TrashCanService trashCanService) {
        this.trashCanService = trashCanService;
    }


    private TrashCanDTO toDTO(TrashCan trashCan)
    {
        return new TrashCanDTO(Long.toString(trashCan.getId()), trashCan.getAddress(), trashCan.getDistance());
    }

    private List<TrashCanDTO> toDTOs(List<TrashCan> trashCans)
    {
        return trashCans.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/")
    public ResponseEntity<List<TrashCanDTO>> all()
    {
        return new ResponseEntity<>(toDTOs(trashCanService.all()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrashCanDTO> getTrashCan(@PathVariable long id)
    {
        TrashCan trashCan = trashCanService.findTrashCan(id);

        if (trashCan != null)
        {
            return new ResponseEntity<>(toDTO(trashCan), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
