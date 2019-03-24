package com.jdc.cdi;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class LogInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext ctx) {
		
		Object obj = null;
		
		
		try {
			
			Object target = ctx.getTarget();
			CounterBean counter = (CounterBean) target;
			
			System.out.printf("Before Count Up : %d%n", counter.getCount());

			obj = ctx.proceed();

			System.out.printf("After Count Up : %d%n", counter.getCount());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}


}
