package com.g3tecnologia.crud.core.infrastructure.repositories.email;

import com.g3tecnologia.crud.core.domain.business.email.EmailModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IEmailRepository extends PagingAndSortingRepository<EmailModel, Long> {

    List<EmailModel> findAll();

    @Query(value = "SELECT * FROM email WHERE ativo = true", nativeQuery = true)
    List<EmailModel> findAllActive();

    @Query(value = "UPDATE email SET ativo = false WHERE id = ?1", nativeQuery = true)
    Boolean logicDelete(Long id);
}
