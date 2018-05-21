package example.kevinwu.com.myandroidstudy.mvpLoginDemo.view;

import example.kevinwu.com.myandroidstudy.mvpLoginDemo.bean.UserInfo;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface ILoginView {
    //获得用户信息
    String getUserName();

    String getPassword();

    //清除用户信息
    void clearUserName();

    void clearPassword();

    //遮罩层
    void showLoading();

    void hideLoading();

    //登陆成功
    void toMainActivity(UserInfo user);

    //登陆失败
    void showFailedError(String message);
}

