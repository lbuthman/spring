package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;
import spittr.data.SpittleRepository;
import spittr.Spittle;

/**
 * Listing 5.10 SpittleController: places a list of recent spittles in the model
 */

@Controller

@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittles";
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="max", defaultValue="9223372036854775807") long max,
            @RequestParam(value="count", defaultValue="20") int count) {

        return spittleRepository.findSpittles(max, count);
    }
}
