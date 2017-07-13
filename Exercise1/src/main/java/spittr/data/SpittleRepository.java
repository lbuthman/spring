package spittr.data;

import java.util.List;

import spittr.Spittle;

/**
 * Simple interface to set stage for database integration
 */

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(Long spittleId);
}
