package io.stuart.zuuldemo.filters

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PostLoggingFilter extends ZuulFilter {

    private static Logger logger = LogManager.getLogger(PostLoggingFilter.class)

    @Override
    String filterType() {
        return "post"
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
        logger.info("Request complete: " + context.getZuulRequestHeaders().get("x-request-id"))
        return null
    }
}
