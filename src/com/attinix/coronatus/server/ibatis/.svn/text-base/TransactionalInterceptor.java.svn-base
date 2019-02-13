package com.attinix.coronatus.server.ibatis;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TransactionalInterceptor implements MethodInterceptor
{
    @Inject
    private SqlMapClient map;
    
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        Object result = null;
        
        try
        {
            map.startTransaction();
            result = invocation.proceed();
            map.commitTransaction();
        }
        finally
        {
            map.endTransaction();
        }
        
        return result;
    }
}
