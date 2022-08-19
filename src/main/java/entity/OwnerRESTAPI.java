package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.OwnerDto;
import repository.OwnerRepo;

import java.util.List;

@RestController
public class OwnerRESTAPI {

    private OwnerRepo ownerRepo;

    @Autowired
    public OwnerRESTAPI(OwnerRepo ownerRepo){
        this.ownerRepo = ownerRepo;
    }

    @GetMapping ("/getOwnerCategoryCount")
    public List<OwnerDto> get()
    {
        return ownerRepo.getCategoryCount();
    }
}
