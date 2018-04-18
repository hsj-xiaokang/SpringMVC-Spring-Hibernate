package hsj.gz.task.dao.impl;


import hsj.gz.support.dao.impl.BaseDaoImpl;
import hsj.gz.task.dao.ISysUserDao;
import hsj.gz.task.entity.SysUser;

import org.springframework.stereotype.Repository;

/**
 * 用户数据层接口实现类
 * @author 胡汉三
 * @date   2017年1月16日 下午2:43:48
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements ISysUserDao {

	public SysUserDaoImpl() {
		super(SysUser.class);
	}
	@Override
	public SysUser getLoginUser(SysUser user) {
		// TODO 用户登录
		String[] pn = {"loginAccount"};
		String[] pv = {user.getLoginAccount()};
		return super.getByProerties(pn, pv, null);
	}
	
}
