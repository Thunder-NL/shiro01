package com.turing.test;

import com.turing.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class Test01 {
    //psvm快捷键--->快速创建main方法
    public static void main(String[] args) {
        //创建安全管理器--->实现DefaultSecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //为安全管理器添加Realm
        securityManager.setRealm(new UserRealm());
        //使用安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体
        Subject subject =SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken upt = new UsernamePasswordToken("admin","123");
        try {
            //使用主体验证登录
            subject.login(upt);
        }catch (UnknownAccountException e){
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        //判断登录是否成功
        System.out.println("认证结果:"+subject.isAuthenticated());

    }
}
