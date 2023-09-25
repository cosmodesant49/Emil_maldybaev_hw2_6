    package com.geeks.emil_maldybaev_hw6;

    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.text.Editable;
    import android.text.TextWatcher;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        private EditText emailEditText;
        private EditText passwordEditText;
        private Button loginButton;
        private TextView welcomeTextView;
        private TextView textEnterTextView;
        private TextView underWelcomeTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            emailEditText = findViewById(R.id.email);
            passwordEditText = findViewById(R.id.password);
            loginButton = findViewById(R.id.button);
            welcomeTextView = findViewById(R.id.wellcome);
            textEnterTextView = findViewById(R.id.textEnter);
            underWelcomeTextView = findViewById(R.id.underWellcome);

            emailEditText.addTextChangedListener(textWatcher);
            passwordEditText.addTextChangedListener(textWatcher);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    login();
                }
            });
        }

        private TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateLoginButtonState();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        private void updateLoginButtonState() {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                loginButton.setBackgroundResource(R.drawable.bg_button_orange);
                loginButton.setEnabled(true);
            } else {
                loginButton.setBackgroundResource(R.drawable.bg_button_grey);
                loginButton.setEnabled(false);
            }
        }

        private void login() {
            String enteredEmail = emailEditText.getText().toString().trim();
            String enteredPassword = passwordEditText.getText().toString().trim();

            if (enteredEmail.equals("admin") && enteredPassword.equals("admin")) {
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                welcomeTextView.setVisibility(View.VISIBLE);
                textEnterTextView.setVisibility(View.GONE);
                underWelcomeTextView.setVisibility(View.GONE);
                emailEditText.setVisibility(View.GONE);
                passwordEditText.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);
            } else {
                Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        }
    }
