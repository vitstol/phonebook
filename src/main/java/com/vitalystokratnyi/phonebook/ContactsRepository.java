package com.vitalystokratnyi.phonebook;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactsRepository extends CrudRepository<Contacts, Long>
{
    List<Contacts> findByName(String name);

    @Modifying
    @Transactional
    @Query("update Contacts c set c.phone = ?3 where c.name = ?1 and c.phone=?2")
    void  updatePhone(@Param("name") String name, @Param("phone") String phone, @Param("phone") String new_phone);
}