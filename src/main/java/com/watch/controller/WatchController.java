package com.watch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.watch.services.WatchService;
import com.watchApp.pojo.Watches;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/watches")
public class WatchController {

    @Autowired
    private WatchService watchService;

    @GetMapping
    public List<Watches> getAllWatches(@RequestParam(required = false) String brand) {
        return brand != null ? watchService.getWatchesByBrand(brand) : watchService.getAllWatches();
    }

    @GetMapping("/{id}")
    public Optional<Watches> getWatchById(@PathVariable Long id) {
        return watchService.getWatchById(id);
    }

    @PostMapping
    public Watches addWatch(@RequestBody Watches watch) {
        return watchService.addWatch(watch);
    }

    @PutMapping("/{id}")
    public Watches updateWatch(@PathVariable Long id, @RequestBody Watches watch) {
        return watchService.updateWatch(id, watch);
    }
}

