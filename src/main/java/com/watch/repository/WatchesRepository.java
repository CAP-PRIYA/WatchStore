package com.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchApp.pojo.Watches;

import java.util.List;

@Repository
public interface WatchesRepository extends JpaRepository<Watches, Long> {

    // Get Watcheses by brand
    List<Watches> findByBrand(String brand);

    // Optional: Get Watcheses within a price range
    List<Watches> findByPriceBetween(Double min, Double max);

    // Optional: Search by model name
    List<Watches> findByModelContainingIgnoreCase(String model);
}
