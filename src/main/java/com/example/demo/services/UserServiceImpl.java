package com.example.demo.services;

import com.example.demo.exceptions.basket.BasketNotFoundException;
import com.example.demo.exceptions.users.UserNotFoundException;
import com.example.demo.model.Basket;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.UserRepository;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> filterByName(String name) {

        //List<User> users = findAll();
        //List<User> result=users.stream().filter(user -> user.getUserName().startsWith(name)).collect(Collectors.toList());
        List<User> users = repository.findUsersByUserName(name);
        return users;
    }

    @Transactional
    @Override
    public void save(User user) {
        Optional<User> u = repository.findUserByUserName(user.getUserName());
        if (!u.isPresent()) {
            repository.save(user);
            return;
        }
        throw new RuntimeException("User already exists");

    }

    @Transactional
    @Override
    public void delete(User user) {
        repository.deleteById(user.getId());
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        repository.findUserByUserName(name).ifPresent(user -> {
            repository.delete(user);
        });
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        User user = repository.findUserById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        repository.deleteById(user.getId());
    }

    @Transactional
    @Override
    public void addOrder(long userId, Order order) {
        User user = repository.findUserById(userId).orElseThrow(() -> {
            return new RuntimeException("User not found");
        });

        user.addOrder(order);

        repository.save(user);
    }

    @Transactional
    @Override
    public void removeOrder(long userId, Order order) {
        if(order.getUser().getId() != userId){
            throw new RuntimeException("Bad request!");
        }

        User user = repository.findUserById(userId).orElseThrow(() -> {
            return new RuntimeException("User not found");
        });

        user.removeOrder(order);

        repository.save(user);

        orderService.deleteById(order.getId());

    }
    @Transactional
    @Override
    public void removeBasket(long userId, Basket basket) {
        if(basket.getUser().getId() != userId){
            throw new RuntimeException("Bad request!");
        }

        User user = repository.findUserById(userId).orElseThrow(() -> {
            return new RuntimeException("User not found");
        });

        user.removeBasket(basket);

        repository.save(user);

        orderService.deleteById(basket.getId());

    }

    @Transactional
    @Override
    public void addBasket(long userId, Basket basket) {
        User user = repository.findUserById(userId).orElseThrow(() -> {
            return new RuntimeException("User not found");
        });


        user.addBasket(basket);

        repository.save(user);
    }

    @Transactional
    @Override
    public void addProduct(long userId, long basketId, Product product){
//        User user = repository.findUserById(userId).orElseThrow(() -> {
//            return new RuntimeException("User not found");
//        });
//        user.addProduct(basketId,product);


    }

    @Transactional
    @Override
    public void addProductToBasket(long id, long basketId, long productId) {
        User user = repository.findById(id).orElseThrow(UserNotFoundException::new);
        Basket basket = user
                .getBaskets()
                .stream()
                .filter(b -> b.getId() == basketId)
                .findFirst()
                .orElseThrow(BasketNotFoundException::new);
        Product product = productService.findById(productId);
        basket.addProduct(product);
        repository.save(user);

    }


}
