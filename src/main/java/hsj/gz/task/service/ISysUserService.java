package hsj.gz.task.service;

import hsj.gz.support.BTView;
import hsj.gz.support.service.IBaseService;
import hsj.gz.task.entity.SysUser;

import java.util.List;

/**
 * 用户service层接口
 * @author 胡汉三
 * @date   2017年1月16日 下午2:26:26
 */
public interface ISysUserService extends IBaseService<SysUser> {
	/**
	 * 分页查询
	 * @param hql
	 * @param bt
	 * @param param
	 * @return
	 */
	public List<SysUser> findSysUserPage(BTView<SysUser> bt,Object[] param);
}
