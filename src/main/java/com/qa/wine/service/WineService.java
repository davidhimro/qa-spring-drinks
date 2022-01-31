package com.qa.wine.service;


import com.qa.wine.domain.WineList;
import com.qa.wine.repo.WineListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineService implements ServiceMethods<WineList> {

    private WineListRepository repo;

    public WineService(WineListRepository repo){
        this.repo = repo;
    }

    @Override
    public WineList create(WineList j) {
        return this.repo.save(j);
    }

    @Override
    public List<WineList> getAll() {
        return this.repo.findAll();
    }

    @Override
    public WineList getById(long id) {
        Optional<WineList> optionalWineList= this.repo.findById(id);
        if (optionalWineList.isPresent()) {
            return optionalWineList.get();
        }
        return null;
    }

    @Override
    public WineList update(long id, WineList winelist) {
        Optional<WineList> existingWineList = this.repo.findById(id);
        if(existingWineList.isPresent()){
            WineList existing = existingWineList.get();
            existing.setWineName(winelist.getWineName());
            existing.setGrapeType(winelist.getGrapeType());
            existing.setCountry(winelist.getCountry());
            return this.repo.saveAndFlush(existing);
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}
