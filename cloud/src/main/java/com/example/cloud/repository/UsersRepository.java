package com.example.cloud.repository;

import com.example.cloud.models.State;
import com.example.cloud.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByNameContainsIgnoreCase(String name);
    Optional<User> findByConfirmCode(String confirmCode);
    void deleteUserById(Long id);

    @Query("from User user where " +
            "(:state is null or :state = user.state) and (" +
            "upper(user.email) like concat('%', upper(:query), '%') or " +
            "upper(user.name) like concat('%', upper(:query), '%'))")
    Page<User> search(@Param("query") String query, @Param("state") State state, Pageable pageable);

    @Query("from User user where " +
            "upper(user.email) like concat('%', upper(:query), '%') or " +
            "upper(user.name) like concat('%', upper(:query), '%')")
    List<User> searchUsers(@Param("query") String query);


}
