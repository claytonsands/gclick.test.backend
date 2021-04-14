package br.com.gclick.springboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gclick.springboottest.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

}
