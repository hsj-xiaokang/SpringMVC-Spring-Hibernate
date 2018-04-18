package hsj.gz.task.controller;

import hsj.gz.support.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 访问页面
 * @author 胡汉三
 * @date   2017年1月16日 下午4:10:15
 */
@Controller
@RequestMapping("/page")
public class PageController extends BaseController{
	
	/**访问用户页面**/
	@RequestMapping("/user")
	public String toUser(){
		return "user/user";
	}
	
	/**访问主页面**/
	@RequestMapping("/main")
	public String index(){
		return "main";
	}
}
