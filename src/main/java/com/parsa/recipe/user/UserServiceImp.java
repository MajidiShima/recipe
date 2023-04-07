package com.parsa.recipe.user;


import com.parsa.recipe.common.SearchCriteria;
import com.parsa.recipe.common.SearchSpecification;
import com.parsa.recipe.common.exception.ConflictException;
import com.parsa.recipe.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements IUserService {

    private final UserRepository repository;


    @Override
    public User save(User user) {
        List<User> list = getAll();
        for (User user1 : list) {
            if (user1.getName().equals(user.getName())) {
                if (user1.getId() == user.getId()) {
                    continue;
                }
                throw new ConflictException("this name is already registered");
            }
            if ((user1.getEmail().equals(user.getEmail())) &&
                    (user1.getPassword().equals(user.getPassword()))) {
                if (user1.getId() == user.getId()) {
                    continue;
                }
                throw new ConflictException("This is has already been registered");
            }

        }

        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User lastUser = getById(user.getId());
        List<User> list = getAll();
        for (User user1 : list) {
            if (user1.getName().equals(user.getName())) {
                if (user1.getId() == user.getId()) {
                    continue;
                }
                throw new ConflictException("this name is already registered");
            }
            if ((user1.getEmail().equals(user.getEmail())) &&
                    (user1.getPassword().equals(user.getPassword()))) {
                if (user1.getId() == user.getId()) {
                    continue;
                }
                throw new ConflictException("This is has already been registered");
            }
        }

        lastUser.setEmail(user.getEmail());
        lastUser.setName(user.getName());
        lastUser.setPassword(user.getPassword());
        return repository.save(lastUser);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException("User Not Found");
        }

        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Page<User> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }


    @Override
    public List<User> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<User> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);

    }
}
