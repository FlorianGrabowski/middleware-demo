package com.financeplanner.api.database.repo;

import com.financeplanner.api.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<ClientEntity, Long> {
}
