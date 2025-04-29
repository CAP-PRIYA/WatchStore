package com.watch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.repository.WatchesRepository;
import com.watchApp.pojo.Watches;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService {

    private final WatchesRepository watchRepository;

    @Autowired
    public WatchService(WatchesRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    // Get all watches
    public List<Watches> getAllWatches() {
        return watchRepository.findAll();
    }

    // Get watches by brand
    public List<Watches> getWatchesByBrand(String brand) {
        return watchRepository.findByBrand(brand);
    }

    // Get watch by ID
    public Optional<Watches> getWatchById(Long id) {
        return watchRepository.findById(id);
    }

    // Add a new watch
    public Watches addWatch(Watches watch) {
        return watchRepository.save(watch);
    }

    // Update watch details
    public Watches updateWatch(Long id, Watches updatedWatch) {
        if (watchRepository.existsById(id)) {
            updatedWatch.setId(id);
            return watchRepository.save(updatedWatch);
        }
        return null;
    }
}
