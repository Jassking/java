package com.ty.util;
/**
 * 字符串工具类
 * @author 23981
 *
 */
public class StringUtil {
	/**
	 * 判断是不是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null&&!"".equals(str.trim())){//str!=null不是空，!"".equals(str.trim())不是空，要两者相与才不是空
			return true;
		}else{
			return false;
		}
	}
}
