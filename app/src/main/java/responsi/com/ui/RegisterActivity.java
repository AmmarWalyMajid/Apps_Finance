package responsi.com.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import responsi.com.R;
import responsi.com.data.UserDao;
import responsi.com.data.UserDataBase;
import responsi.com.model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextEmail = findViewById(R.id.et_emaireg);
        editTextPassword = findViewById(R.id.et_passreg);
        editTextCnfPassword = findViewById(R.id.et_Conpassreg);
        buttonRegister = findViewById(R.id.btn_loginRg);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(email,password);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}