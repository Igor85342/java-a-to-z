package ru.moskalets.spring.section002.task001.stores;
import org.springframework.data.repository.CrudRepository;
import ru.moskalets.spring.section002.task001.models.TransmissionSpring;

public interface TransmissionRepository extends CrudRepository<TransmissionSpring, Integer> {
}