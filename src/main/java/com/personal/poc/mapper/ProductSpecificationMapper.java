package com.personal.poc.mapper;

import java.util.ArrayList;
import java.util.List;

import com.personal.poc.model.ProductSpecification;
import com.personal.poc.model.RootEntity;
import com.personal.poc.model.source.ProductSpecificationSource;
import com.personal.poc.model.source.SourceInformationModel;

public class ProductSpecificationMapper extends RootEntityMapper implements IMapper {

	ProductSpecificationMapper() {
		// TODO Auto-generated constructor stub
	}

	public <T extends SourceInformationModel> List<? extends RootEntity> map(List<T> source) {
		List<RootEntity> psList = new ArrayList<RootEntity>();

		for (T t : source) {
			if (t instanceof ProductSpecificationSource) {
				ProductSpecificationSource psSource = (ProductSpecificationSource) t;
				ProductSpecification ps = new ProductSpecification();

				ps.setDate(psSource.getDate());
				ps.setSubType(psSource.getSubType());
				ps.setVersion(psSource.getVersion());

				psList.add(super.map(psSource, ps));
			} else {
				//TODO: throw exception due to wrong source type to convert
				System.out.println("Throw exception due to wrong source type");
			}

		}

		return psList;
	}

}
