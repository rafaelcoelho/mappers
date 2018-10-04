package com.personal.poc;

import java.util.ArrayList;
import java.util.List;

import com.personal.poc.mapper.BuilderMapper;
import com.personal.poc.mapper.IMapper;
import com.personal.poc.mapper.ProductSpecificationMapper;
import com.personal.poc.model.ProductSpecification;
import com.personal.poc.model.RootEntity;
import com.personal.poc.model.source.ProductSpecificationSource;
import com.personal.poc.model.source.SourceInformationModel;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MapperTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public MapperTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MapperTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testMapperPS() {
		List<? extends RootEntity> psList;
		
		List<SourceInformationModel> psSource = new ArrayList<SourceInformationModel>();

		IMapper mapper = new BuilderMapper().mapperFor("ProductSpecification").build();
		ProductSpecificationSource source = new ProductSpecificationSource();

		source.setDate("20/09/2019");
		source.setHref("http://localhost:8080/ecm/ps/x");
		source.setId("1234567890");
		source.setName("PS Pay as you go");
		source.setSubType("productSpecification");
		source.setType("psSubSubType");
		source.setVersion("v1.0");

		psSource.add(source);

		psList = mapper.map(psSource);
		
		for (RootEntity root : psList) {
			ProductSpecification ps = (ProductSpecification) root;
			
			Assert.assertEquals(source.getDate(), ps.getDate());
			assertEquals(source.getHref(), ps.getHref());
		}
	}
	
	public void testMapperPSAndProxy() {
		List<? extends RootEntity> psList;
		
		List<SourceInformationModel> psSource = new ArrayList<SourceInformationModel>();

		IMapper mapper = new BuilderMapper().mapperFor("ProductSpecification").withV2Support().build();
		ProductSpecificationSource source = new ProductSpecificationSource();

		source.setDate("20/09/2019");
		source.setHref("http://localhost:8080/ecm/ps/x");
		source.setId("1234567890");
		source.setName("PS Pay as you go");
		source.setSubType("productSpecification");
		source.setType("psSubSubType");
		source.setVersion("v1.0");

		psSource.add(source);

		psList = mapper.map(psSource);
		
		for (RootEntity root : psList) {
			ProductSpecification ps = (ProductSpecification) root;
			
			Assert.assertEquals(source.getDate(), ps.getDate());
			assertEquals(source.getHref(), ps.getHref());
		}
	}
	
	public void testMapperPSNoProxy() {
		List<? extends RootEntity> psList;
		
		List<SourceInformationModel> psSource = new ArrayList<SourceInformationModel>();

		IMapper mapper = new BuilderMapper().mapperFor("ProductSpecification").build();
		ProductSpecificationSource source = new ProductSpecificationSource();

		source.setDate("20/09/2019");
		source.setHref("http://localhost:8080/ecm/ps/x");
		source.setId("1234567890");
		source.setName("PS Pay as you go");
		source.setSubType("productSpecification");
		source.setType("psSubSubType");
		source.setVersion("v1.0");

		psSource.add(source);

		psList = mapper.map(psSource);
		
		for (RootEntity root : psList) {
			ProductSpecification ps = (ProductSpecification) root;
			
			Assert.assertEquals(source.getDate(), ps.getDate());
			assertEquals(source.getHref(), ps.getHref());
		}
	}
	
	public void testMapperPSwithWrongEntity() {
		List<? extends RootEntity> psList;
		
		List<SourceInformationModel> psSource = new ArrayList<SourceInformationModel>();

		IMapper mapper = new BuilderMapper().mapperFor("ProductSpecification").build();
		SourceInformationModel source = new SourceInformationModel();

		source.setDate("20/09/2019");
		source.setHref("http://localhost:8080/ecm/ps/x");
		source.setId("1234567890");
		source.setName("PS Pay as you go");
		source.setSubType("productSpecification");
		source.setType("psSubSubType");

		psSource.add(source);

		psList = mapper.map(psSource);
		
		assertTrue(psList.isEmpty());
		
		for (RootEntity root : psList) {
			ProductSpecification ps = (ProductSpecification) root;
			
			Assert.assertEquals(source.getDate(), ps.getDate());
			assertEquals(source.getHref(), ps.getHref());
		}
	}
}
