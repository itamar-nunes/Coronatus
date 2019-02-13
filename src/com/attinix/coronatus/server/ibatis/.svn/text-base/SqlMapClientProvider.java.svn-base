package com.attinix.coronatus.server.ibatis;

import java.io.IOException;

import com.google.inject.Provider;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientProvider implements Provider<SqlMapClient>
{
    public SqlMapClient get()
    {
        try
        {
            return SqlMapClientBuilder.buildSqlMapClient(
                    Resources.getResourceAsReader("com/attinix/coronatus/server/SqlMapConfig.xml"));
        }
        catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
