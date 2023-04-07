package com.parsa.recipe.user;


import com.parsa.recipe.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements IUserService {

    private final UserRepository repository;


    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Page<User> paging(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<User> search(List<SearchCriteria> searchCriteria) {
        return null;
    }
}
