package hsj.gz.task.controller;

import hsj.gz.support.BTView;
import hsj.gz.support.controller.BaseController;
import hsj.gz.task.entity.SysRole;
import hsj.gz.task.entity.SysUser;
import hsj.gz.task.service.ISysRoleService;
import hsj.gz.task.service.ISysUserService;
import hsj.gz.task.util.DateUtil;
import hsj.gz.task.util.MD5;
import hsj.gz.task.util.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户控制器
 * @author 胡汉三
 * @date   2017年1月16日 下午2:31:39
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends BaseController{

	@Resource
	private ISysUserService userService;
	@Resource
	private ISysRoleService roleService;

	/**
	 * 分页查询用户
	 * @param response
	 * @param user
	 * @param btView
	 * @throws IOException 
	 */
	@RequestMapping(value = "/findUser", method = { RequestMethod.POST, RequestMethod.GET })
	public void findUser(SysUser user,BTView<SysUser> btView) throws IOException{
		List<SysUser> list = userService.findSysUserPage(btView, null);
		btView.setRows(list);
		super.writeJSON(btView);
	}

	/**
	 * 用户登录
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public void login(SysUser user,boolean rememberMe) throws IOException{
		result.setSuccess(false);
		//用户登录
		/*SysUser userInfo = userService.getByProerties(new String[]{"loginAccount"}, new String[]{user.getLoginAccount()},null);
		if(userInfo==null){
			result.setMessage("用户名错误");
			super.writeJSON(result);
			return;
		}
		if(!userInfo.getLoginPass().equals(new Sha256Hash(user.getLoginPass()).toHex())){
			result.setMessage("密码错误");
			super.writeJSON(result);
			return;
		}
		//存入session
		Subject subject = SecurityUtils.getSubject();
		//记得传入明文密码
		subject.login(new UsernamePasswordToken(userInfo.getLoginAccount(), user.getLoginPass(), rememberMe));
		session.setAttribute(USER_SESSION, userInfo);
		result.setMessage("登录成功");
		result.setSuccess(true);*/
		String msg = "";
		boolean flag = true;
		String userName = user.getLoginAccount();
		String password = user.getLoginPass();
		System.out.println(userName);
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		if(rememberMe){token.setRememberMe(true);}
		
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				;
			} else {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			flag = false;
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			flag = false;
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			flag = false;
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			flag = false;
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			flag = false;
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			flag = false;
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			flag = false;
		}
//		if(flag){session.setAttribute(USER_SESSION, user);}
		result.setMessage(msg);
		result.setSuccess(flag);
		super.writeJSON(result);
	}

	/**
	 * 用户注册
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET })
	public void register(SysUser user) throws IOException{
		result.setSuccess(false);
		Long count = userService.getCountByProerties(new String[]{"loginAccount"}, new String[]{user.getLoginAccount()});
		if(count>0){
			result.setMessage("账号已存在");
			super.writeJSON(result);
			return;
		}
		Long countEmail = userService.getCountByProerties(new String[]{"userEmail"}, new String[]{user.getUserEmail()});
		if(countEmail>0){
			result.setMessage("邮箱已存在");
			super.writeJSON(result);
			return;
		}
		try{
			//注册时间
			user.setRegisterTime(DateUtil.getDateTime(new Date()));
			//Sha256Hash加密
			user.setLoginPass(MD5.crypt(user.getLoginPass()));
			//默认为注册用户
			SysRole role = roleService.getByProerties(new String[]{"roleKey"},new String[]{"ROLE_USER"},null);
			user.getRoles().add(role);
			userService.save(user);
			//存入session
//			Subject subject = SecurityUtils.getSubject();
//			subject.login(new UsernamePasswordToken(user.getLoginAccount(), user.getLoginPass()));
//			session.setAttribute(USER_SESSION, user);
			result.setMessage("注册成功");
			result.setSuccess(true);
		}catch(Exception e){
			result.setMessage("注册失败");
		}
		super.writeJSON(result);
	}


	/**
	 * 判断用户账号是否已存在
	 * @param response
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping(value = "/getUserNameCount", method = { RequestMethod.POST, RequestMethod.GET })
	public void getUserNameCount(String loginAccount) throws IOException{
		result.setSuccess(false);
		if(StringUtils.isBlank(loginAccount)){
			result.setMessage("账号不能为空");
			super.writeJSON(result);
			return;
		}
		Long count = userService.getCountByProerties(new String[]{"loginAccount"}, new String[]{loginAccount});
		if(count>0){
			result.setMessage("账号已存在");
		}else{
			result.setSuccess(true);
			result.setMessage("该账号可用");
		}
		super.writeJSON(result);
	}
	
	/**
	 * 判断用户邮箱是否已存在
	 * @param response
	 * @param email
	 * @throws IOException
	 */
	@RequestMapping(value = "/getEMailCount", method = { RequestMethod.POST, RequestMethod.GET })
	public void getEMailCount(String email) throws IOException{
		result.setSuccess(false);
		if(StringUtils.isBlank(email)){
			result.setMessage("邮箱不能为空");
			super.writeJSON(result);
			return;
		}
		Long count = userService.getCountByProerties(new String[]{"userEmail"}, new String[]{email});
		if(count>0){
			result.setMessage("邮箱已存在");
		}else{
			result.setSuccess(true);
			result.setMessage("该邮箱可用");
		}
		super.writeJSON(result);
	}

	// 登出
	@RequestMapping("/logout")
	public void logout() throws IOException {
		//退出权限验证
		SecurityUtils.getSubject().logout();
		//销毁session
//		session.invalidate(); 
//		session.removeAttribute(USER_SESSION);
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	    /**
	     * 权限
	     * @throws IOException
	     */
	    @RequestMapping("/permissionsListNo")
	    @RequiresPermissions("delete123456")
	    public void permissionsListNo() throws IOException {
	    	result.setSuccess(true);
			result.setMessage("权限未通过-delete123456");
			super.writeJSON(result);
	    }
	    
	    
	    /**
	     * 权限
	     * @throws IOException
	     */
	    @RequestMapping("/permissionsListYes")
	    @RequiresPermissions("delete")
	    public void permissionsListYes() throws IOException {
	    	result.setSuccess(true);
			result.setMessage("权限通过-delete");
			super.writeJSON(result);
	    }
}
