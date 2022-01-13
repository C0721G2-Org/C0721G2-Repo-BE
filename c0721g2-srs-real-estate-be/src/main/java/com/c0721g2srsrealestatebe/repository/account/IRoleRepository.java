package com.c0721g2srsrealestatebe.repository.account;

import com.c0721g2srsrealestatebe.model.account.Role;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IRoleRepository extends JpaAttributeConverter<Role, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "select (roles.name) from roles where roles.name = :name", nativeQuery = true)
//   Role getRoleByName(@Param("name") String name);

}
