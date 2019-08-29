package com.github.cosmicdisorder.antefare.models.data;

import com.github.cosmicdisorder.antefare.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDao extends
CrudRepository<User, Integer>{
}
