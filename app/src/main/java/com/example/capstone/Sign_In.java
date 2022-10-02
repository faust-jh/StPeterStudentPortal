package com.example.capstone;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class Sign_In extends AppCompatActivity {

    //DECLARATION
    public String user, pass, usertype;
    public String studUser = "Student", studPass = "Student";
    public String facUser = "Faculty", facPass = "Faculty";
    EditText txtUsername;
    EditText txtPassword;
    Spinner txtUsertype;
    TextView signUp;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //How to organize spinner
        final List<String> states = Arrays.asList("Student", "Faculty");

        final Spinner spinner = findViewById(R.id.Usertype);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_selected_item, states);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);



        //HOW TO CONNECT THE XML INTO THE VARIABLES
        txtUsertype = (Spinner) findViewById(R.id.Usertype);
        txtUsername = (EditText) findViewById(R.id.Usernamefield);
        txtPassword = (EditText) findViewById(R.id.Passwordfield);
        signUp = (TextView) findViewById(R.id.SignUp);
        signIn = (Button) findViewById(R.id.Signbtn);


        //FUNCTION FOR THE SIGNIN AND SIGNUP BUTTON\
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                user = txtUsername.getText().toString();
                pass = txtPassword.getText().toString();
                usertype = txtUsertype.getSelectedItem().toString();
                SignIn();
            }
        });
        signUp.setOnClickListener(view -> {
            Intent Sign_Up = new Intent(this, Sign_Up.class);
            startActivity(Sign_Up);
        });
    }


   void SignIn()
   {

        if(user.isEmpty())
        {
           Toast.makeText(getApplicationContext(), "Please enter username", LENGTH_LONG).show();
           txtUsername.setError("Please enter username!");
        }
        else if(pass.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please enter password", LENGTH_LONG).show();
            txtPassword.setError("Please enter Password!");
        }
        else if(user.isEmpty() && pass.isEmpty())
        {
           Toast.makeText(getApplicationContext(), "Please fill up the fields!", LENGTH_LONG).show();
           txtUsername.setError("Please enter username!");
           txtPassword.setError("Please enter Password!");
        }
        else
        {
            if (usertype.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please fill up the fields!", LENGTH_LONG).show();
            }
            else if (usertype.equals("Student")) {
                if (user.equals(studUser) && pass.equals(studPass)) {
                    Intent studNav = new Intent(this, StudentNavigation.class);
                    startActivity(studNav);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Account!", LENGTH_LONG).show();
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            }
            else if (usertype.equals("Faculty")) {
                if (user.equals(facUser) && pass.equals(facPass)) {
                    Intent facNav = new Intent(this, FacultyNavigation.class);
                    startActivity(facNav);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Account!", LENGTH_LONG).show();
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            }
        }
   }
}