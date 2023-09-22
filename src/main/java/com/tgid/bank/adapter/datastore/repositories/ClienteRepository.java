package com.tgid.bank.adapter.datastore.repositories;

import com.tgid.bank.adapter.datastore.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,UUID>{

    Optional<Cliente> findByCpf(String cpf);
}
