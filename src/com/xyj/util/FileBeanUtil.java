package com.xyj.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 把请求信息封装到bean里面
 * @author Administrator
 *
 */
public class FileBeanUtil {
	public static<T> T fillBean(HttpServletRequest request,Class<T> clazz){
		T t;
		try {
			t = clazz.newInstance();
			BeanUtils.copyProperties(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
