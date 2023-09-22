package com.tgid.bank.adapter.datastore.repositories;

import com.tgid.bank.adapter.datastore.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,UUID>{
}
