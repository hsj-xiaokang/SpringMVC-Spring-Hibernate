package hsj.gz.task.dao;

import hsj.gz.support.BTView;
import hsj.gz.support.dao.IBaseDao;
import hsj.gz.task.entity.SysAuthority;

import java.util.List;
/**
 * 菜单表数据层接口 
 * @author 胡汉三
 * @dataTime 2017-01-19 17:35:01
 */
public interface ISysAuthorityDao extends IBaseDao<SysAuthority> {
	
	/**
	 * 查询菜单
	 * @param bt	分页
	 * @param auth	菜单对象
	 * @return
	 */
	public List<SysAuthority> findAuthority(BTView<SysAuthority> bt, SysAuthority auth);
}
