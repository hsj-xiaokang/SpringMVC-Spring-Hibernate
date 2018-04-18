package hsj.gz.support.controller;

import hsj.gz.task.entity.SysUser;
import hsj.gz.task.util.Result;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 父类控制器
 * @author 胡汉三
 * @date   2017年1月9日 下午5:23:52
 */
@SuppressWarnings("deprecation")
public class BaseController{
	public static final String USER_SESSION = "USER_SESSION";
	protected static ObjectMapper mapper = new ObjectMapper();
	protected static JsonFactory factory = mapper.getJsonFactory();
	protected static Result result = new Result();
	
	protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
	
	/**将json字符串输出**/
	protected void writeJSON(String json) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
	}
	/**将对象转成json输出**/
	protected void writeJSON(Object obj) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
		responseJsonGenerator.writeObject(obj);
	}

	/**
	 * 获得session用户对象
	 * @return
	 */
	protected SysUser getUser(){
		Object userObj = session.getAttribute(USER_SESSION);
		if(userObj == null){
			return null;
		}
		return (SysUser)userObj;
	}
}
