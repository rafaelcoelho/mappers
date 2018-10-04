package com.personal.poc.mapper;

import com.personal.poc.model.RootEntity;
import com.personal.poc.model.source.SourceInformationModel;

public abstract class RootEntityMapper implements IMapper {

	RootEntityMapper() {
	}

	public <T extends SourceInformationModel> RootEntity map(T source, RootEntity target) {
		target.setHref(source.getHref());
		target.setId(source.getId());
		target.setType(source.getType());
		
		return target;
	}

}
