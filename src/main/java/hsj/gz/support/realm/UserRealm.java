package hsj.gz.support.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class UserRealm extends AuthorizingRealm {

  

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String userName = (String) super.getAvailablePrincipal(principals) ; //获取用户名 
		SimpleAuthorizationInfo info=null ;
		try{
			// 权限信息对象info，用来存放查出的用户的所有的角色及权限
			info = new SimpleAuthorizationInfo();
			    List<String> roles = new ArrayList<String>(){{
			    	add("ROLE_USER");
			    	add("ROLE_ADMIN");
			    }};   //根据用户名查询角色
				info.addRoles(roles);
			    List<String> permissions= new ArrayList<String>(){{
			    	add("add");
			    	add("delete");
			    }}; //根据用户名查询权限 
				info.addStringPermissions(permissions);
		}catch(Exception e){
			e.printStackTrace();
		}
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;

//        return new SimpleAuthenticationInfo("hsjhsj","8e24137dee97c9bbddb9a0cd6e043be4" , getName());
        return new SimpleAuthenticationInfo("hsj","e10adc3949ba59abbe56e057f20f883e" , getName());
        //查出是否有此用户
//        TbUser user=null;
//        if(user!=null){
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            return new SimpleAuthenticationInfo(user.getUsername(), , getName());
//        }
//        return null;
	}

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}
