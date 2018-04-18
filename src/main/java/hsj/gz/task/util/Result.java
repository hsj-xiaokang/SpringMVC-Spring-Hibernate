package hsj.gz.task.util;

import java.io.Serializable;

/**
 * 返回结果
 * @author 胡汉三
 * @date   2017年1月18日 上午11:40:32
 */
public class Result implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2267751680865696851L;
	/**是否成功**/
	private Boolean success = false ;
	/**返回消息**/
	private String message;
	/**返回数据**/
	private Object data;
	
	
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
