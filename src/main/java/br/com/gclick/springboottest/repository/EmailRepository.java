package br.com.gclick.springboottest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gclick.springboottest.entity.EmailEntity;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long>{
	List<EmailEntity> findByClientId(Long clientId);
}
