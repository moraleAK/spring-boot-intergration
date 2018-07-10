package com.canno.spring.boot.integration.java18;

import com.canno.spring.boot.integration.java18.animation.Canno;

import java.lang.reflect.Field;

/**
 * @author CannoGcc
 * @since 2018/7/9 11:31
 */
@Canno(count = 1)
public class CannoGcc {
    @Canno(value = "canno")
    String canno;

    public static void main(String[] args) {
        boolean isHas = CannoGcc.class.isAnnotationPresent(Canno.class);
        System.out.println(isHas);
        if(isHas){
            Canno canno = CannoGcc.class.getAnnotation(Canno.class);
            System.out.println(canno.count());
        }

        Field[] fields = CannoGcc.class.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            field.isAnnotationPresent(Canno.class);
            if(isHas){
                System.out.println(field.getAnnotation(Canno.class).value());
            }
        }
    }
}
