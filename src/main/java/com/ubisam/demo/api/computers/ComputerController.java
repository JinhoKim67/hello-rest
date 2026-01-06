package com.ubisam.demo.api.computers;

import com.ubisam.demo.domain.Computer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    private final ComputerRepository repo;

    public ComputerController(ComputerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Computer> list(@RequestParam(required = false) String q) {
        if (q == null || q.isBlank()) return repo.findAll();
        return repo.findByNameContainingIgnoreCase(q.trim());
    }

    @GetMapping("/{id}")
    public Computer get(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Computer create(@RequestBody Computer req) {
        Computer c = new Computer();
        c.setName(req.getName());
        return repo.save(c);
    }

    @PutMapping("/{id}")
    public Computer update(@PathVariable Long id, @RequestBody Computer req) {
        Computer c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
        c.setName(req.getName());
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Not found: " + id);
        repo.deleteById(id);
    }
}
