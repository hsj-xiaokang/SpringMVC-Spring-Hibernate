package hsj.gz.task.service.impl;


import hsj.gz.support.service.impl.BaseServiceImpl;
import hsj.gz.task.dao.ISysRoleDao;
import hsj.gz.task.entity.SysRole;
import hsj.gz.task.service.ISysRoleService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 角色业务层接口实现类
 * @author 胡汉三
 * @date   2017年1月18日 下午5:25:26
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {
	private ISysRoleDao sysRoleDao;
	@Resource
	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
		this.dao = sysRoleDao; 
	}
}
