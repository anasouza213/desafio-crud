package com.g3tecnologia.crud.core.infrastructure.repositories.phone;
import com.g3tecnologia.crud.core.domain.business.phone.PhoneModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IPhoneRepository  extends PagingAndSortingRepository<PhoneModel, Long> {

    List<PhoneModel> findAll();

    @Query(value = "SELECT * FROM phone WHERE active = true", nativeQuery = true)
    List<PhoneModel> findAllActive();

    @Query(value = "UPDATE phone SET active = false WHERE id = ?1", nativeQuery = true)
    Boolean logicDelete(Long id);
}
