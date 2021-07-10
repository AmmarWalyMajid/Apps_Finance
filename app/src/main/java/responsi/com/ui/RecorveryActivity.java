package responsi.com.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import responsi.com.R;

public class RecorveryActivity extends AppCompatActivity {

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorvery);

        back = findViewById(R.id.backRec);
        back.setOnClickListener(v -> startActivity(new Intent(RecorveryActivity.this, LoginActivity.class)));

    }
}