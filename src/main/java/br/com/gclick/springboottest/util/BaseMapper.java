package br.com.gclick.springboottest.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.modelmapper.config.Configuration.AccessLevel;



public abstract class BaseMapper<TEntity, TDTO> {

	private ModelMapper modelMapper;

	private Class<TEntity> typeEntity;

	private Class<TDTO> typeDTO;

	@SuppressWarnings("unchecked")
	public BaseMapper() {
		this.typeEntity = (Class<TEntity>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.typeDTO = (Class<TDTO>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	protected ModelMapper getModelMapper() {
		if (modelMapper == null) {
			modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			modelMapper.getConfiguration().setDeepCopyEnabled(true);
			modelMapper.getConfiguration().setFieldAccessLevel(AccessLevel.PUBLIC);
			modelMapper.getConfiguration().setAmbiguityIgnored(false);
			modelMapper.getConfiguration().setFieldMatchingEnabled(false);

			configure(modelMapper);
		}

		return modelMapper;
	}

	protected void configure(ModelMapper modelMapper) {
	}

	public TDTO toDTO(TEntity entity) {
		//Object e = deepClone(entity);
		return getModelMapper().map(entity, typeDTO);
	}

	public void toDTO(TDTO dtoSource, TDTO dtoDestination) {
		getModelMapper().map(dtoSource, dtoDestination);
	}

	public TEntity toEntity(TDTO dto) {
		//Object d = deepClone(dto);
		return getModelMapper().map(dto, typeEntity);
	}

	public void toEntity(TEntity entitySource, TEntity entityDestination) {
		getModelMapper().map(entitySource, entityDestination);
	}

	public List<TDTO> toDTO(List<TEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public List<TEntity> toEntity(List<TDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	public Page<TDTO> toDTO(Page<TEntity> listEntity) {
		return listEntity.map(new Function<TEntity, TDTO>() {
			@Override
			public TDTO apply(TEntity source) {
				return toDTO(source);
			}
		});
	}

	public Page<TEntity> toEntity(Page<TDTO> dtos) {
		return dtos.map(new Function<TDTO, TEntity>() {
			@Override
			public TEntity apply(TDTO source) {
				return toEntity(source);
			}
		});
	}

}
