package responsi.com.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import responsi.com.R;
import responsi.com.data.UserDao;
import responsi.com.data.UserDataBase;
import responsi.com.model.User;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textRegister,textForgot;
    UserDao db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.et_emailog);
        editTextPassword = findViewById(R.id.et_passlog);
        buttonLogin = findViewById(R.id.btn_login);

        textRegister = findViewById(R.id.tv_RegHere);
        textForgot = findViewById(R.id.tv_ForgotHere);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();


        textRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        textForgot.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RecorveryActivity.class)));

        buttonLogin.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            User user = db.getUser(email, password);
            if (user != null) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("User", user);
                startActivity(i);
                finish();
            }else{
                Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
            }
        });

    }
}