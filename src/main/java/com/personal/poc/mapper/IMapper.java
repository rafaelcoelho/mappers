package com.personal.poc.mapper;

import java.util.List;

import com.personal.poc.model.RootEntity;
import com.personal.poc.model.source.SourceInformationModel;

public interface IMapper {

	public <T extends SourceInformationModel> List<? extends RootEntity> map(List<T> source);

}
