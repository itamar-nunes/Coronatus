package com.attinix.coronatus.server.guice;

import com.attinix.coronatus.client.service.core.CrudService;
import com.attinix.coronatus.server.service.CrudServiceImpl;
import com.google.inject.AbstractModule;

public class Modulo extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(CrudService.class).to(CrudServiceImpl.class);
    }
}
