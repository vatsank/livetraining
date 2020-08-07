package com.example.demo.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
			return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletResponse response=	  RequestContext.getCurrentContext().
				                            getResponse();

		log.info("Post Filter"+ response.getContentType());
		log.info("Post Filter"+ response.getStatus());
		
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
