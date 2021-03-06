/**
 * 
 */
package com.jeetemplates.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import com.jeetemplates.domain.model.HelloWorld;
import com.jeetemplates.service.dto.HelloWorldDTO;
import com.jeetemplates.web.form.HelloWorldForm;

/**
 * Orika mapper.
 * 
 * @author jeetemplates
 */
public class OrikaMapper extends ConfigurableMapper {

	@Override
	public void configure(MapperFactory mapperFactory) {
		// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
				.classMap(HelloWorld.class, HelloWorldDTO.class)
				.field("lastName", "lastName")
				.field("firstName", "firstName")
				.toClassMap());
		
		// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
				.classMap(HelloWorld.class, HelloWorldForm.class)
				.field("lastName", "lastName")
				.field("firstName", "firstName")
				.toClassMap());
	}

	@Override
	public void configureFactoryBuilder(DefaultMapperFactory.Builder builder) {
		// configure properties of the factory, if needed
	}

}
