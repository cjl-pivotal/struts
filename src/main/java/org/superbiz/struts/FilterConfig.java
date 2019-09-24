package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.List;

@Configuration
public class FilterConfig
{
    @Bean
    public FilterRegistrationBean siteMeshFilter( )
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new SiteMeshFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilter( )
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
        registrationBean.addUrlPatterns("/");
        registrationBean.addUrlPatterns("/addUserForm.action");
        registrationBean.addUrlPatterns("/addUser.action");
        registrationBean.addUrlPatterns("/findUserForm.action");
        registrationBean.addUrlPatterns("/findUser.action");
        registrationBean.addUrlPatterns("/listAllUsers.action");
        registrationBean.setOrder(2);

        return registrationBean;
    }

    private FilterRegistrationBean buildFilterRegistration(int order, Filter filter, List<String> urlPatterns) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setUrlPatterns(urlPatterns);
        registration.setOrder(order);
        return registration;
    }
}