package spittr.data;

import java.util.List;

import org.springframework.stereotype.Component;
import spittr.Spittle;

/**
 * Simple interface to set stage for database integration
 */
@Component
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
