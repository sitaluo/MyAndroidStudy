package example.kevinwu.com.myandroidstudy.mvpLoginDemo.model;

import example.kevinwu.com.myandroidstudy.mvpLoginDemo.bean.UserInfo;

/**
 * Created by Administrator on 2018/5/21.
 */

public class UserLoginModel implements IUserLoginModel {
    @Override
    public void login(String name, String pwd,IUserLoginModel.OnLoginListenser loginListener) {
        new Thread(()->{
            try {
                Thread.sleep(2000);
                if ("admin".equals(name) && "admin".equals(pwd)) {
                    UserInfo userInfoBean = new UserInfo();
                    userInfoBean.setUserId(System.currentTimeMillis());
                    userInfoBean.setUserName(name);
                    userInfoBean.setPassword(pwd);
                    loginListener.loginSuccess(userInfoBean);
                } else {
                    loginListener.loginFailed("密码错误");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
