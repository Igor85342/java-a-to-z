package ru.moskalets.spring.section002.task001.stores;
import org.springframework.data.repository.CrudRepository;
import ru.moskalets.spring.section002.task001.models.UserSpring;

public interface UserRepository extends CrudRepository<UserSpring, Integer> {
    UserSpring findByLogin(String login);
}