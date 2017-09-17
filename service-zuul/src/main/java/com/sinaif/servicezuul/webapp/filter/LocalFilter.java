package com.sinaif.servicezuul.webapp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author darben
 * @Date 2017/9/1717:48
 */

@Component
public class LocalFilter extends ZuulFilter {

    private static Logger LOG = LoggerFactory.getLogger(LocalFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        LOG.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String accessToken=request.getParameter("token");
        if (accessToken == null) {
            LOG.warn("token is empty.");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty.");
            } catch (Exception e) {
            }
        } else {
            LOG.info("token is ok.");
        }
        return null;
    }
}
