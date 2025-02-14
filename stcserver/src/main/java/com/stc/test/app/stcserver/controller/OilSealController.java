package com.stc.test.app.stcserver.controller;

import com.stc.test.app.stcserver.model.OilSeal;
import com.stc.test.app.stcserver.service.OilSealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/oilseals")
public class OilSealController {

    private final OilSealService service;

    public OilSealController(OilSealService service) {
        this.service = service;
    }

    @PostMapping
    public OilSeal createOilSeal(@RequestBody OilSeal oilSeal) {
        return service.createOilSeal(oilSeal);
    }

    @GetMapping
    public List<OilSeal> getAllOilSeals() {
        return service.getAllOilSeals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OilSeal> getOilSealById(@PathVariable Long id) {
        Optional<OilSeal> oilSeal = service.getOilSealById(id);
        return oilSeal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OilSeal> updateOilSeal(@PathVariable Long id, @RequestBody OilSeal updatedOilSeal) {
        OilSeal updated = service.updateOilSeal(id, updatedOilSeal);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOilSeal(@PathVariable Long id) {
        return service.deleteOilSeal(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<OilSeal> searchOilSeals(
            @RequestParam(required = false) Double innerDiameter,
            @RequestParam(required = false) Double outerDiameter,
            @RequestParam(required = false) Double thickness) {
        return service.searchOilSeals(innerDiameter, outerDiameter, thickness);
    }
}