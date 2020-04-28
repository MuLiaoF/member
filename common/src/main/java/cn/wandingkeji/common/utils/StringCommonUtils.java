package cn.wandingkeji.common.utils;

/**
 * 
 */
public class StringCommonUtils {


    /**
     * 获取数据类型
     * @param object
     * @return
     */
    public static String getType(Object object){
        String typeName=object.getClass().getName();
        int length= typeName.lastIndexOf(".");
        String type =typeName.substring(length+1);
        return type;
    }


}
