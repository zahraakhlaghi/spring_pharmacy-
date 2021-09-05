package com.mkyong.repository;

import com.mkyong.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select e from #{#entityName} e where e.username like ?1 and e.password like ?2")
    User login(String username, String password);
}
