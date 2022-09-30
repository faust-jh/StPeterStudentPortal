package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.internal.EdgeToEdgeUtils;

import org.w3c.dom.Text;

public class Sign_Up extends AppCompatActivity {

    String fname, lname, email, username, pass, conpass;

    EditText txtFname;
    EditText txtLname;
    EditText txtEmail;
    EditText txtUsername;
    EditText txtPass;
    EditText txtConpass;
    TextView txtTerms;
    TextView txtSignIn;
    Button btnSignUp;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    //FOR THE STUDENT ID POP UP VERIFICATION
    private TextView enterStudID;
    private EditText editStudID;
    private Button enterStudIDbtn;

    //FOR THE TERMS AND CONDITION POPUP
    private TextView lblTermsandConditions;
    private TextView txtTermsandConditions;
    private Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //HOW TO CONNECT THE XML INTO THE VARIABLES
        txtFname = (EditText) findViewById(R.id.FNamefield);
        txtLname = (EditText) findViewById(R.id.LNamedfield);
        txtEmail = (EditText) findViewById(R.id.MailField);
        txtUsername = (EditText) findViewById(R.id.UsernameField);
        txtPass = (EditText) findViewById(R.id.PasswordField);
        txtConpass = (EditText) findViewById(R.id.ConfirmPassField);
        txtTerms = (TextView) findViewById(R.id.TermsandCondition);
        txtSignIn = (TextView) findViewById(R.id.createSignIn);
        btnSignUp = (Button) findViewById(R.id.createSignUp);


        //SHOULD BE CHANGED MUST BE TERMS AND CONDITION
        txtTerms.setOnClickListener(view -> {
            TermspopupDialog();
        });
        //FUNCTION FOR THE SIGNIN AND SIGNUP BUTTON
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studIDpopupDialog();
            }
        });
        txtSignIn.setOnClickListener(view -> {
            Intent signIn= new Intent(this, Sign_In.class);
            startActivity(signIn);
        });

    }

    public void studIDpopupDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View StudIDpopupView = getLayoutInflater().inflate(R.layout.studidpopup, null);
        enterStudID = (TextView) StudIDpopupView.findViewById(R.id.enterStudID);
        editStudID = (EditText) StudIDpopupView.findViewById(R.id.editStudID);
        enterStudIDbtn = (Button) StudIDpopupView.findViewById(R.id.enterStudIDbtn);

        dialogBuilder.setView(StudIDpopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        enterStudIDbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //define enter button
            }
        });
    }

    public void TermspopupDialog() {
            dialogBuilder = new AlertDialog.Builder(this);
            final View TermspopupView = getLayoutInflater().inflate(R.layout.termsandconditionpopup, null);
            lblTermsandConditions = (TextView) TermspopupView.findViewById(R.id.lblTermsandConditions);
            txtTermsandConditions = (TextView) TermspopupView.findViewById(R.id.txtTermsandConditions);
            doneBtn = (Button) TermspopupView.findViewById(R.id.doneBtn);

            dialogBuilder.setView(TermspopupView);
            dialog = dialogBuilder.create();
            dialog.show();

                doneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //define done button
                    dialog.dismiss();
                }
            });
    }
}