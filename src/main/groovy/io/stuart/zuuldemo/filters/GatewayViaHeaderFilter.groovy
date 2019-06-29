package io.stuart.zuuldemo.filters

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException

class GatewayViaHeaderFilter extends ZuulFilter{
    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 1
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext()
        context.addZuulRequestHeader("Via", "cts.proxy")
        return null
    }
}
