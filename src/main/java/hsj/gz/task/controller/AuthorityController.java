package hsj.gz.task.controller;

import hsj.gz.support.BTView;
import hsj.gz.support.controller.BaseController;
import hsj.gz.task.entity.SysAuthority;
import hsj.gz.task.service.ISysAuthorityService;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 菜单控制器
 * @author 胡汉三
 * @date   2017年1月22日 上午9:41:25
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController{
	
	@Resource
	private ISysAuthorityService authorityService;
	
	/**
	 * 分页查询菜单
	 * @param authority	菜单
	 * @param btView	分页参数
	 * @throws IOException 
	 */
	@RequestMapping(value = "/findAuthority", method = { RequestMethod.POST, RequestMethod.GET })
	public void findAuthority(SysAuthority authority,BTView<SysAuthority> btView) throws IOException{
		List<SysAuthority> list = authorityService.findAuthority(btView, authority);
		btView.setRows(list);
		super.writeJSON(btView);
	}
	
	/**
	 * 保存菜单
	 * @param authority		菜单
	 * @throws IOException 
	 */
	@RequestMapping(value = "/saveAuthority", method = { RequestMethod.POST, RequestMethod.GET })
	public void saveAuthority(SysAuthority authority) throws IOException{
		result.setSuccess(false);
		result.setMessage("新增失败");
		try{
			authorityService.save(authority);
			result.setSuccess(true);
			result.setMessage("新增成功");
		}catch(Exception e){
			result.setMessage("新增异常");
		}
		super.writeJSON(result);
	}
	
	
	/**
	 * 编辑菜单
	 * @param authority		菜单
	 * @throws IOException 
	 */
	@RequestMapping(value = "/editAuthority", method = { RequestMethod.POST, RequestMethod.GET })
	public void editAuthority(SysAuthority authority) throws IOException{
		result.setSuccess(false);
		result.setMessage("编辑失败");
		try{
			authorityService.update(authority);
			result.setSuccess(true);
			result.setMessage("编辑成功");
		}catch(Exception e){
			result.setMessage("编辑异常");
		}
		super.writeJSON(result);
	}
	
	/**
	 * 删除菜单
	 * @param authority		菜单
	 * @throws IOException 
	 */
	@RequestMapping(value = "/deleteAuthority", method = { RequestMethod.POST, RequestMethod.GET })
	public void deleteAuthority(Long[] ids) throws IOException{
		result.setSuccess(false);
		result.setMessage("编辑失败");
		try{
			authorityService.deleteByPK(ids);
			result.setSuccess(true);
			result.setMessage("编辑成功");
		}catch(Exception e){
			result.setMessage("编辑异常");
		}
		super.writeJSON(result);
	}
}