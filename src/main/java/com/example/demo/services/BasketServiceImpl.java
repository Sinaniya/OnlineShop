package com.example.demo.services;


import com.example.demo.repository.BasketRepository;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository repository;

    @Override
    public List<Basket> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Basket> filterByName(String name) {

        List<Basket> baskets = repository.findBasketsByName(name);
        //List<Basket> baskets = findAll();
        //List<Basket> result = baskets.stream().filter(basket -> basket.getName().startsWith(name)).collect(Collectors.toList());
        return baskets;
    }

    @Transactional
    @Override
    public void save(Basket basket) {
        repository.save(basket);

    }

    @Transactional
    @Override
    public void delete(Basket basket) {
        repository.deleteById(basket.getId());
    }


    @Override
    public void deleteByName(String name) {
        repository.findBasketByName(name).ifPresent(basket -> {
            repository.delete(basket);
        });
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Basket basket = repository.findBasketById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(basket.getId());

    }

}
