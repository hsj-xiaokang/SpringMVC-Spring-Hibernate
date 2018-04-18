package hsj.gz.task.service.impl;


import hsj.gz.support.BTView;
import hsj.gz.support.service.impl.BaseServiceImpl;
import hsj.gz.task.dao.ISysAuthorityDao;
import hsj.gz.task.entity.SysAuthority;
import hsj.gz.task.service.ISysAuthorityService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 菜单表业务层接口实现类
 * @author 胡汉三
 * @dataTime 2017-01-19 17:35:01
 */
@Service
public class SysAuthorityServiceImpl extends BaseServiceImpl<SysAuthority> implements ISysAuthorityService {

	private ISysAuthorityDao sysAuthorityDao;
 
	@Resource
	public void setSysAuthorityDao(ISysAuthorityDao sysAuthorityDao) {
		this.sysAuthorityDao = sysAuthorityDao;
		this.dao = sysAuthorityDao;
	}

	@Override
	public List<SysAuthority> findAuthority(BTView<SysAuthority> bt, SysAuthority auth) {
		return sysAuthorityDao.findAuthority(bt, auth);
	}
 
}
