package hsj.gz.task.dao.impl;


import hsj.gz.support.dao.impl.BaseDaoImpl;
import hsj.gz.task.dao.ISysRoleDao;
import hsj.gz.task.entity.SysRole;

import org.springframework.stereotype.Repository;

/**
 * 角色数据层接口实现类
 * @author 胡汉三
 * @date   2017年1月18日 下午5:21:23
 */
@Repository
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements ISysRoleDao {
	
	public SysRoleDaoImpl(){
		super(SysRole.class);
	}
}
