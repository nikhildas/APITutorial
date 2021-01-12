package example.controllers;

import example.connection.mysqlentitymodel.State;
import example.connection.mysqlentitymodel.StateRepository;
import example.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/state")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @PostMapping
    public Iterable<State> addStates(@RequestBody Iterable<State> states) {
        return stateRepository.saveAll(states);
    }

    @GetMapping
    public Iterable<State> getAllStates() {
        return stateRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<State> getStateByID(@PathVariable Integer id) {
        Optional<State> state = stateRepository.findById(id);

        try {
            state.get();
        } catch (Exception e) {
            throw new StateNotFoundException();
        }

        return state;
    }

    @PutMapping
    public State updateState(@RequestBody State state) {
        if (state.getID() == null)
            throw new StateNotFoundException();
        return stateRepository.save(state);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteState(@PathVariable Integer id) {
        stateRepository.deleteById(id);

        return "State Deleted Successfully!!";
    }
}
