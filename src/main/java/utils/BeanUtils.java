package utils;

import model.Person;
import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>(){
            private static final long serialVersionUID = 1L;
            {
                put("name", "001");
                put("age", "23");
            }
        };

        map.put("birthday", DateUtil.getCurrentDate().toLocaleString());

        map.put("remainMoney","1000000");
        for (String s:
             map.values()) {

            System.out.println(s);
        }
    }
    public static void setAndGetCodeTest(){
        try {
            Person p=new Person("张三",12);
            String propertyName="name";
            String propertyName2="age";
            Integer val=15;
            getPropertyByBeanInfo(p,"age");
            setProperty(p,propertyName2,val);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void getPropertyByBeanInfo(Person p,String propertyName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo= Introspector.getBeanInfo(p.getClass());
        PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd:pds){
            if(pd.getName().equals(propertyName)){
                System.out.println(pd.getReadMethod().invoke(p));
                break;
            }
        }
    }
    //设置属性方法
    public  static void setProperty(Person p,String propertyName,Object val) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd1=new PropertyDescriptor(propertyName, p.getClass());
        Method method=pd1.getWriteMethod();
        method.invoke(p,val);
        System.out.println(p);
    }
}
