package com.ubisam.demo.api.items;

import com.ubisam.demo.domain.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository repo;

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Item> list(@RequestParam(required = false) String q) {
        if (q == null || q.isBlank()) return repo.findAll();
        return repo.findByNameContainingIgnoreCase(q.trim());
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody Item req) {
        Item i = new Item();
        i.setName(req.getName());
        return repo.save(i);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item req) {
        Item i = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
        i.setName(req.getName());
        return repo.save(i);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Not found: " + id);
        repo.deleteById(id);
    }
}
