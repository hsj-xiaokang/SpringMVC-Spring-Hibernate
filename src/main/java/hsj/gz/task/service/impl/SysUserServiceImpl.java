package hsj.gz.task.service.impl;


import hsj.gz.support.BTView;
import hsj.gz.support.service.impl.BaseServiceImpl;
import hsj.gz.task.dao.ISysUserDao;
import hsj.gz.task.entity.SysUser;
import hsj.gz.task.service.ISysUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 用户service层接口实现类
 * @author 胡汉三
 * @date   2017年1月16日 下午2:27:25
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService {
	
	private ISysUserDao sysUserDao;
	@Resource
	public void setSysUserDao(ISysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
		this.dao = sysUserDao; 
	}
	@Override
	public List<SysUser> findSysUserPage(BTView<SysUser> bt, Object[] param) {
		String hql = "from SysUser";
		Map<String, String> orderMap = null;
		if(bt.getSortName()!=null && !bt.getSortName().equals("")){
			orderMap = new HashMap<String, String>();
			orderMap.put(bt.getSortName(), bt.getSortOrder());
		}
		return sysUserDao.findByPage(hql, bt, param, orderMap);
	}
	
}
