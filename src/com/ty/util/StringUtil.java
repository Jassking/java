package com.ty.util;
/**
 * �ַ���������
 * @author 23981
 *
 */
public class StringUtil {
	/**
	 * �ж��ǲ��ǿ�
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
	 * �ж��Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null&&!"".equals(str.trim())){//str!=null���ǿգ�!"".equals(str.trim())���ǿգ�Ҫ��������Ų��ǿ�
			return true;
		}else{
			return false;
		}
	}
}
