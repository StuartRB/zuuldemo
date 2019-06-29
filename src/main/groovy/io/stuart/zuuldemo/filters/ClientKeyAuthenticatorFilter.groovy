//package io.stuart.zuuldemo.filters
//
//import com.netflix.zuul.ZuulFilter
//import com.netflix.zuul.context.RequestContext
//import com.netflix.zuul.exception.ZuulException
//
//import javax.servlet.http.HttpServletRequest
//import java.util.stream.Collectors
//
//class ClientKeyAuthenticatorFilter extends ZuulFilter{
//    @Override
//    String filterType() {
//        return "pre"
//    }
//
//    @Override
//    int filterOrder() {
//        return 0
//    }
//
//    @Override
//    boolean shouldFilter() {
//        return true
//    }
//
//    @Override
//    Object run() throws ZuulException {
//        RequestContext context = RequestContext.getCurrentContext()
//
//        Enumeration<String> headerNames = context.getRequest().getHeaderNames()
//
//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                System.out.println("Header: " + context.getRequest().getHeader(headerNames.nextElement()))
//
//            }
//        }
//
//
//        Map.Entry clientKey = headers.get("ClientKey")
//        if (clientKey==null){
//            throw new Exception("no client key found")
//        }
//        if (clientKey.getValue() != "fartknocker") {
//            throw new Exception("invalid key value")
//        }
//        return null
//    }
//}
