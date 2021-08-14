package com.g3tecnologia.crud.core.infrastructure.repositories.users;

import com.g3tecnologia.crud.core.domain.business.users.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserModel, Long> {

    List<UserModel> findAll();

    @Query(value = "SELECT * FROM user WHERE active = true", nativeQuery = true)
    List<UserModel> findAllActive();

    @Query(value = "UPDATE user SET active = false WHERE id = ?1", nativeQuery = true)
    Boolean logicDelete(Long id);

    @Query(value = "SELECT * FROM user WHERE active =  true AND cpf = ?1", nativeQuery = true)
    UserModel findByCpf(String cpf);
}
