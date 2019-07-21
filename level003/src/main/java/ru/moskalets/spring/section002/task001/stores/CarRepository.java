package ru.moskalets.spring.section002.task001.stores;
import org.springframework.data.repository.CrudRepository;
import ru.moskalets.spring.section002.task001.models.BrandSpring;
import ru.moskalets.spring.section002.task001.models.CarSpring;
import java.util.List;

public interface CarRepository extends CrudRepository<CarSpring, Integer> {

    List<CarSpring> findByImageBase64Not(String imageBase64);

    List<CarSpring> findByDateBetween(Long start, Long end);

    List<CarSpring> findByBrand(BrandSpring brand);
}

