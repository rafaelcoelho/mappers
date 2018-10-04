package com.personal.poc.mapper;

import java.util.List;

import com.personal.poc.model.RootEntity;
import com.personal.poc.model.source.SourceInformationModel;

public class ProxyMapper implements IMapper {

	private IMapper realMapper;
	
	ProxyMapper(IMapper mapper) {
		this.realMapper = mapper;
	}

	public <T extends SourceInformationModel> List<? extends RootEntity> map(List<T> source) {
		System.out.println("Proxy mapper is working");
		
		List<? extends RootEntity> list = realMapper.map(source);
		
		for (RootEntity rootEntity : list) {
			map(rootEntity);				
		}
		
		return realMapper.map(source);
		
	}
	
	private void map(RootEntity rootEntity) {
		//TODO: Check for VersionAware interface
		if (RootEntity.class.isAssignableFrom(rootEntity.getClass())) {
			
			try {
				RootEntity x = rootEntity.getClass().newInstance();
				System.out.println("X: " + x.getHref());
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			System.out.println("Running map on proxy" + rootEntity.getId());
			
		}
	}
	
}
