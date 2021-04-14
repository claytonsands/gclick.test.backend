package br.com.gclick.springboottest.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import br.com.gclick.springboottest.exception.ResourceNotFoundException;


@Transactional
public abstract class CrudBaseService<TDTO extends BaseDTO, TEntity extends BaseEntity, TID, TRepository extends BaseRepository<TEntity, TID>, TMapper extends BaseMapper<TEntity, TDTO>>
		extends BaseService<TRepository, TMapper> {
	
	//protected RegraNegocio<TEntity> regra;

	public CrudBaseService(TRepository repository, TMapper mapper) {
		super(repository, mapper);
	}

	public Page<TDTO> findAll(Pageable pageable) {
		Page<TEntity> listEntity = repository.findAll(pageable);
		return mapper.toDTO(listEntity);
	}

	public TDTO findById(TID id) {
		TEntity entity = repository.findById(id).orElseThrow(() -> {
			return new RuntimeException(getClass().getSimpleName() + "@findById: " + this.getClass().getName()
					+ " with ID " + id + " not found!");
		});

		return mapper.toDTO(entity);
	}

	public TDTO create(TDTO dto) throws ResourceNotFoundException {
		TEntity entityNew = mapper.toEntity(dto);
		// criticar(entityNew);
		entityNew = repository.saveAndFlush(entityNew);
		return mapper.toDTO(entityNew);
	}

	public TDTO update(TID id, TDTO dto) {
		TEntity entityDB = repository.findById(id).orElseThrow(() -> {
			return new RuntimeException(getClass().getSimpleName() + "@update: " + this.getClass().getName()
					+ " with ID " + id + " not found!");
		});

		TEntity entityNew = mapper.toEntity(dto);
		repository.saveAndFlush(entityNew);

		return mapper.toDTO(entityDB);
	}

	public void delete(TID id) {
		repository.deleteById(id);
	}
}