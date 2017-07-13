package spittr.daoimpl;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import spittr.data.SpittleRepository;
import spittr.Spittle;

/**
 * in the hope of actually running
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {

        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;

    }

    @Override
    public Spittle findOne(Long spittleId) {
        return new Spittle("Spittle " + spittleId, new Date());
    }
}
