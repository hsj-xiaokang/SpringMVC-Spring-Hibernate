package hsj.gz.task.dao;

import hsj.gz.support.dao.IBaseDao;
import hsj.gz.task.entity.SysUser;

/**
 * 用户数据层接口
 * @author 胡汉三
 * @date   2017年1月16日 下午2:43:57
 */
public interface ISysUserDao extends IBaseDao<SysUser>{
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public SysUser getLoginUser(SysUser user);
}
