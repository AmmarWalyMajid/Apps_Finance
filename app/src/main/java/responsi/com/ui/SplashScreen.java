package responsi.com.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import responsi.com.R;

public class SplashScreen extends AppCompatActivity {

    private int load=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            //if(
            // )
            Intent home=new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(home);
            finish();

        },load);
    }
}