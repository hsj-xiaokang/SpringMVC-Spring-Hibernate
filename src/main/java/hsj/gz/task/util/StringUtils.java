package hsj.gz.task.util;

/**
 * String工具类
 * @author 胡汉三
 * @date   2017年1月18日 上午10:49:37
 */
public class StringUtils {
	
	/**
	 * 判断字符不为空
	 * @param str	
	 * @return	为空返回false，不为空返回true
	 */
	public static boolean isNotBlank(String str){
		return str != null && !"".equals(str);
	}
	
	
	/**
	 * 判断字符是否为空
	 * @param str
	 * @return	为空返回true，不为空返回false
	 */
	public static boolean isBlank(String str){
		return str == null || "".equals(str);
	}
}
