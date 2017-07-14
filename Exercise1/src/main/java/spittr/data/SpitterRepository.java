package spittr.data;

import spittr.Spitter;

/**
 * basic interface for database implementation
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
