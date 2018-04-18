package hsj.gz.task.security;

import hsj.gz.task.service.ISysUserService;

import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义用户过滤器
 * @author 胡汉三
 *
 */
public class SysUserFilter extends PathMatchingFilter {
	
	@Resource
	private ISysUserService sysUserService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //可以参考http://jinnianshilongnian.iteye.com/blog/2025656
    	return true;
    }
}
