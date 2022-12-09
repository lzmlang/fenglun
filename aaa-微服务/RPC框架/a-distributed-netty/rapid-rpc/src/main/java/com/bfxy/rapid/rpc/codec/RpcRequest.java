package com.bfxy.rapid.rpc.codec;

import lombok.Data;

import java.io.Serializable;

/**
 * 	$RpcRequest
 * @author 17475
 *
 */
@Data
public class RpcRequest implements Serializable {

	private static final long serialVersionUID = 3424024710707513070L;
	
	private String requestId;
	
	private String className;
	
	private String methodName;
	
	private Class<?>[] paramterTypes;
	
	private Object[] paramters;

}
