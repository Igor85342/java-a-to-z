package ru.moskalets.spring.section002.task001.stores;
import org.springframework.data.repository.CrudRepository;
import ru.moskalets.spring.section002.task001.models.CarbodySpring;

public interface CarbodyRepository extends CrudRepository<CarbodySpring, Integer> {
}