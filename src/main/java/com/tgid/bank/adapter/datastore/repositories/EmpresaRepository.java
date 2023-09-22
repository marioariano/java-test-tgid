package com.tgid.bank.adapter.datastore.repositories;

import com.tgid.bank.adapter.datastore.entities.Cliente;
import com.tgid.bank.adapter.datastore.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,UUID>{

    Optional<Empresa> findByCnpj(String cnpj);
}
