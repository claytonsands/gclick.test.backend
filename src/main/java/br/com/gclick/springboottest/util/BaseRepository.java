package br.com.gclick.springboottest.util;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@Transactional
public interface BaseRepository<TEntity extends BaseEntity, TID> extends JpaRepository<TEntity, TID> {

}
