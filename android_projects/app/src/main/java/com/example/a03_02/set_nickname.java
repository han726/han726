package com.example.a03_02;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class set_nickname extends AppCompatActivity {
    private EditText et_nn;
    private Button btn_nn;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_nickname);
        et_nn = findViewById(R.id.inputnn);
        btn_nn = findViewById(R.id.btnnn);
        //mDatabase = FirebaseDatabase.getInstance().getReference();
        btn_nn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                set_nn();
            }
        });
    }
    private void set_nn()
    {
        mRef = FirebaseDatabase.getInstance().getReference();
        String input_nn = et_nn.getText().toString();

        Map<String, Object> childUpdate = new HashMap<>();

        User user = new User(input_nn, 10);
        Map<String, Object> postValues = user.toMap();

        childUpdate.put("/user/" + input_nn, postValues);
        mRef.updateChildren(childUpdate);

        Intent intent = new Intent(this, AfterActivity.class);
        startActivity(intent);
    }
}
