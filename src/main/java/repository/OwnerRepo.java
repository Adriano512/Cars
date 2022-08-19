package repository;

import entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepo extends JpaRepository<Owner,Long> {

    @Query(value = "select Owner.name as Owner, count (Owner.name) as CategoryCount, Car.type as Type\n " +
            "FROM Owner,Car\n" + " group by mark", nativeQuery = true)
List<OwnerDto> getCategoryCount();

}