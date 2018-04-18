package hsj.gz.task.dao.impl;


import hsj.gz.support.BTView;
import hsj.gz.support.dao.impl.BaseDaoImpl;
import hsj.gz.task.dao.ISysAuthorityDao;
import hsj.gz.task.entity.SysAuthority;
import hsj.gz.task.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/** 
 * 菜单表数据层接口实现类
 * @author 胡汉三
 * @dataTime 2017-01-19 17:35:01
 */
@Repository
public class SysAuthorityDaoImpl extends BaseDaoImpl<SysAuthority> implements ISysAuthorityDao {

	public SysAuthorityDaoImpl(){
		super(SysAuthority.class);
	}

	@Override
	public List<SysAuthority> findAuthority(BTView<SysAuthority> bt, SysAuthority auth) {
		StringBuffer hql = new StringBuffer();
		hql.append("from SysAuthority t where 1=1 ");
		Map<String, String> orderMap = null;
		if(bt.getSortName()!=null && !bt.getSortName().equals("")){
			orderMap = new HashMap<String, String>();
			orderMap.put(bt.getSortName(), bt.getSortOrder());
		}
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(auth.getMenuName())){
			hql.append(" and menuName = ? ");
			params.add(auth.getMenuName());
		}
		if(StringUtils.isNotBlank(auth.getMenuCode())){
			hql.append(" and menuCode = ? ");
			params.add(auth.getMenuCode());
		}
		return super.findByPage(hql.toString(), bt, params.toArray(), orderMap);
	}
	
	
	
}
