package example.kevinwu.com.myandroidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private Button liveListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        liveListBtn = findViewById(R.id.liveListBtn);

        loginBtn.setOnClickListener((view)->{
            Toast.makeText(this,"登录按钮点击",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            this.startActivity(intent);
        });
        liveListBtn.setOnClickListener((view)->{
            Toast.makeText(this,"登录按钮点击",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LiveListActivity.class);
            this.startActivity(intent);
        });
    }

}
