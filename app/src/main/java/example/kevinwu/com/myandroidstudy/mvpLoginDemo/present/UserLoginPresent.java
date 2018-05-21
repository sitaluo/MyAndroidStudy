package example.kevinwu.com.myandroidstudy.mvpLoginDemo.present;


import android.os.Handler;

import example.kevinwu.com.myandroidstudy.mvpLoginDemo.bean.UserInfo;
import example.kevinwu.com.myandroidstudy.mvpLoginDemo.model.IUserLoginModel;
import example.kevinwu.com.myandroidstudy.mvpLoginDemo.model.UserLoginModel;
import example.kevinwu.com.myandroidstudy.mvpLoginDemo.view.ILoginView;

/**
 * Created by Administrator on 2018/5/21.
 */

public class UserLoginPresent {
    private ILoginView loginView;
    private IUserLoginModel userLoginModel;
    private Handler mHandler = new Handler();

    public UserLoginPresent(ILoginView loginView){
        this.loginView = loginView;
        this.userLoginModel = new UserLoginModel();

    }
    public void login() {
        loginView.showLoading();
        userLoginModel.login(loginView.getUserName(), loginView.getPassword(), new UserLoginModel.OnLoginListenser() {
            @Override
            public void loginSuccess(final UserInfo user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed(final String message) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError(message);
                        loginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        loginView.clearPassword();
        loginView.clearUserName();
    }

}
