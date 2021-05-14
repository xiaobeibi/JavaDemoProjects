package com.bjpowernode.exception;

import org.hibernate.tool.schema.spi.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ExceptionHandlerFactory {

    /**
     * 外挂的自定义处理器,用于外部扩展
     */
    private static Map<String, ExceptionHandler> handlerList = null;

    static ExceptionHandler createExceptionhandler(Throwable ex) {
        //这个是自定义的接口
        ExceptionHandler exceptionHandler = null;
        String packageName = ExceptionHandlerFactory.class.getName().replace(ExceptionHandlerFactory.class.getSimpleName(), "");
        String className = ex.getClass().getSimpleName();
        String classFullName = ex.getClass().getName();

        if (handlerList == null) {
            handlerList = new HashMap<String, ExceptionHandler>();
        }
        if (handlerList.containsKey(classFullName)) {
            return handlerList.get(classFullName);
        }

        //能走到这边,说明自定义的没有生效,走过之后,下面会将他缓存,也就是说,自定义的优先级永远大过系统自带的
        try {
            exceptionHandler = (ExceptionHandler) Class.forName(packageName + className + "Handler").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        handlerList.put(classFullName, exceptionHandler);

        return exceptionHandler;
    }

    public Map<String, ExceptionHandler> getHandlerList() {
        return handlerList;
    }

    public void setHandlerList(Map<String, ExceptionHandler> handlerList) {
        ExceptionHandlerFactory.handlerList = handlerList;
    }


}
