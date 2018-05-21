package example.kevinwu.com.myandroidstudy.mvpLoginDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import example.kevinwu.com.myandroidstudy.R;
import example.kevinwu.com.myandroidstudy.mvpLoginDemo.bean.UserInfo;
import example.kevinwu.com.myandroidstudy.mvpLoginDemo.present.UserLoginPresent;
import example.kevinwu.com.myandroidstudy.mvpLoginDemo.view.ILoginView;

/**
 * Created by Administrator on 2018/5/21.
 */

public class LoginMvpDemoActivity extends AppCompatActivity implements ILoginView{
    private EditText user_name_edit, user_pwd_edit;
    private Button user_login_btn, user_clear_btn;
    private ProgressBar user_login_bar;
    private UserLoginPresent presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_mvp_demp);
        presenter=new UserLoginPresent(this);
        initView();
    }
    private void initView() {
        user_name_edit = (EditText) findViewById(R.id.user_name_edit);
        user_pwd_edit = (EditText) findViewById(R.id.user_pwd_edit);
        user_login_btn = (Button) findViewById(R.id.user_login_btn);
        user_clear_btn = (Button) findViewById(R.id.user_clear_btn);
        user_login_bar = (ProgressBar) findViewById(R.id.user_login_bar);
        user_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
        user_clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }
    @Override
    public String getUserName() {
        return user_name_edit.getText().toString();
    }

    @Override
    public String getPassword() {
        return user_pwd_edit.getText().toString();
    }

    @Override
    public void clearUserName() {
        user_name_edit.setText("");
    }

    @Override
    public void clearPassword() {
        user_pwd_edit.setText("");
    }

    @Override
    public void showLoading() {
        user_login_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        user_login_bar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(UserInfo user) {
        Toast.makeText(this, user.getUserName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
