package com.attinix.coronatus.server.ibatis;

import static com.google.inject.Scopes.SINGLETON;
import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;

import com.ibatis.sqlmap.client.SqlMapClient;

public class IbatisModule extends ExtendedModule
{
    @Override
    protected void configure()
    {
        bind(SqlMapClient.class).toProvider(SqlMapClientProvider.class)
                .in(SINGLETON);
        bindInterceptor(any(), annotatedWith(Transactional.class),
                new TransactionalInterceptor());
    }
}
