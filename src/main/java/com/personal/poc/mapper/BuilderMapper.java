package com.personal.poc.mapper;

import java.util.HashMap;
import java.util.Map;

public class BuilderMapper {
	private static Map<String, IMapper> mappers;
	private IMapper mapper;
	private String entity;

	public BuilderMapper() {
		mappers = new HashMap<String, IMapper>();
		mappers.put("ProductSpecification", new ProductSpecificationMapper());
	}

	public BuilderMapper mapperFor(String entity) {
		this.entity = entity;
		mapper = mappers.get(entity);

		return mappers.containsKey(entity) ? this : null;
	}

	public BuilderMapper withV2Support() {
		mapper = new ProxyMapper(mappers.get(entity));

		return this;
	}

	public IMapper build() {
		return mapper;
	}
}
