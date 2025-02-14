package com.stc.test.app.stcserver.service;

import com.stc.test.app.stcserver.model.OilSeal;
import com.stc.test.app.stcserver.repository.OilSealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OilSealService {

    private final OilSealRepository repository;

    public OilSealService(OilSealRepository repository) {
        this.repository = repository;
    }

    public OilSeal createOilSeal(OilSeal oilSeal) {
        return repository.save(oilSeal);
    }

    public List<OilSeal> getAllOilSeals() {
        return repository.findAll();
    }

    public Optional<OilSeal> getOilSealById(Long id) {
        return repository.findById(id);
    }

    public OilSeal updateOilSeal(Long id, OilSeal updatedOilSeal) {
        return repository.findById(id).map(oilSeal -> {
            oilSeal.setInnerDiameter(updatedOilSeal.getInnerDiameter());
            oilSeal.setOuterDiameter(updatedOilSeal.getOuterDiameter());
            oilSeal.setThickness(updatedOilSeal.getThickness());
            oilSeal.setQuantity(updatedOilSeal.getQuantity());
            return repository.save(oilSeal);
        }).orElse(null);
    }

    public boolean deleteOilSeal(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<OilSeal> searchOilSeals(Double innerDiameter, Double outerDiameter, Double thickness) {
        return repository.searchOilSeals(innerDiameter, outerDiameter, thickness);
    }
}