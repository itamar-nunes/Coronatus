package com.attinix.coronatus.server.guice;

import static com.attinix.coronatus.server.guice.GuiceListener.GUICE_INJECTOR;
import static com.google.gwt.user.server.rpc.RPC.decodeRequest;
import static com.google.gwt.user.server.rpc.RPC.encodeResponseForFailure;
import static com.google.gwt.user.server.rpc.RPC.invokeAndEncodeResponse;

import javax.servlet.ServletException;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Injector;

public final class GuiceServlet extends RemoteServiceServlet
{
    private static final long serialVersionUID = 6115386339715841565L;

    private Injector injector;
    
    @Override
    public void init() throws ServletException
    {
        injector = (Injector) getServletContext().getAttribute(GUICE_INJECTOR);
    }
    
    @Override
    public String processCall(String payload) throws SerializationException
    {
        String result = null;
        RPCRequest request = decodeRequest(payload);

        try
        {
            result = invokeAndEncodeResponse(getService(request.getMethod()
                    .getDeclaringClass()), request.getMethod(), request
                    .getParameters(), request.getSerializationPolicy());
        }
        catch (IncompatibleRemoteServiceException exception)
        {
            getServletContext().log("Incompatible Remote Service", exception);
            result = encodeResponseForFailure(request.getMethod(), exception);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private RemoteService getService(Class serviceClass)
    {
        return (RemoteService) injector.getInstance(serviceClass);
    }
}
