package com.parsa.recipe.user;


import com.parsa.recipe.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    User save(User user);
    User update(User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAll();
    Page<User> paging(Integer page,Integer size);
    List<User> search(List<SearchCriteria> searchCriteria);

}
