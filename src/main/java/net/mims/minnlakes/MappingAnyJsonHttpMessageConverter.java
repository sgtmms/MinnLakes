package net.mims.minnlakes;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class MappingAnyJsonHttpMessageConverter extends MappingJackson2HttpMessageConverter{
	
	public MappingAnyJsonHttpMessageConverter() {
	    List<MediaType> list = new ArrayList<MediaType>(1);
	    list.add(MediaType.ALL);
	    this.setSupportedMediaTypes(list);
	  }

}
