package spittr.daoimpl;

import org.springframework.stereotype.Component;

import spittr.data.SpitterRepository;
import spittr.Spitter;

/**
 * simple implementation for Autowiring
 */
@Component
public class SpitterRepositoryImpl implements SpitterRepository {

    public Spitter save(Spitter spitter) {
        return new Spitter();
    }

    public Spitter findByUsername(String username) {
        return  new Spitter();
    }
}
