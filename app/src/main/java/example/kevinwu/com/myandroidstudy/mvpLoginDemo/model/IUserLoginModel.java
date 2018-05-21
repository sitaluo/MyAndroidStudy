package example.kevinwu.com.myandroidstudy.mvpLoginDemo.model;

import example.kevinwu.com.myandroidstudy.mvpLoginDemo.bean.UserInfo;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface IUserLoginModel {
    void login(String userName,String password,OnLoginListenser loginListener);

    interface OnLoginListenser{
        void loginSuccess(UserInfo user);
        void loginFailed(String message);
    }
}
