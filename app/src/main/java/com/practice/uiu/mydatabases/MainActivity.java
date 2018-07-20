package com.practice.uiu.mydatabases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.practice.uiu.mydatabases.database.DBHelper;
import com.practice.uiu.mydatabases.model.UsersInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText u_name_et,u_password_et,u_city_et,u_country_et;
    Button u_submit_btn, u_showdata_btn;
    DBHelper mDBHelper;
    UsersInfo usersInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        u_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name=u_name_et.getText().toString();
                    String password=u_password_et.getText().toString();
                    String city=u_city_et.getText().toString();
                    String country=u_country_et.getText().toString();

                    usersInfo=new UsersInfo(name, password, city, country);
                    mDBHelper.addUserInfo(usersInfo);


                }catch (Exception e)
                {

                }
            }
        });

        u_showdata_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<UsersInfo> usersInfoArrayList= mDBHelper.showDataALL();

                for (UsersInfo  u: usersInfoArrayList)
                {
                    Toast.makeText(MainActivity.this, ""+u.getName(), Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private void initView() {

        u_name_et=findViewById(R.id.u_name_et_id);
        u_password_et=findViewById(R.id.u_password_et_id);
        u_city_et   =   findViewById(R.id.u_city_et_id);
        u_country_et    =   findViewById(R.id.u_country_et_id);
        u_submit_btn = findViewById(R.id.u_submit_btn_id);
        u_showdata_btn= findViewById(R.id.u_showdata_btn_id);

        mDBHelper=new DBHelper(this);
    }
}
