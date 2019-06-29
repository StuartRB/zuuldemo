package io.stuart.zuuldemo.filters

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import io.stuart.zuuldemo.config.FilterProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

class RequestUuidHeaderFilter extends ZuulFilter {

    @Autowired
    FilterProperties filterProperties


    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 0
    }

    @Override
    boolean shouldFilter() {
        return filterProperties.getEnabled()
    }

    @Override
    Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext()
        context.addZuulRequestHeader("X-Request-ID", UUID.randomUUID().toString())
        return null
    }
}
