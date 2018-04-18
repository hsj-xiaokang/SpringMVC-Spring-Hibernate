package hsj.gz.task.service;

import hsj.gz.support.BTView;
import hsj.gz.support.service.IBaseService;
import hsj.gz.task.entity.SysAuthority;

import java.util.List;

/**
 * 菜单表业务层接口
 * @author 胡汉三
 * @dataTime 2017-01-19 17:35:01
 */
public interface ISysAuthorityService extends IBaseService<SysAuthority> {
	/**
	 * 查询菜单
	 * @param bt	分页
	 * @param auth	菜单对象
	 * @return
	 */
	public List<SysAuthority> findAuthority(BTView<SysAuthority> bt, SysAuthority auth);
}
