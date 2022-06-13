package com.example.hw16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)
        var login = findViewById<Button>(R.id.login)
        var signup = findViewById<Button>(R.id.signup)
        var DB = DBHelper(this);

        login.setOnClickListener{
            var user = username.getText().toString()
            var pass = password.getText().toString()

            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(this, "有空白未填", Toast.LENGTH_SHORT).show()
            }
            else {
                var checkuserpass = DB.checkusernamepassword(user,pass)
                if(checkuserpass == false){
                    Toast.makeText(this, "登錄成功", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "登錄失敗", Toast.LENGTH_SHORT).show()
                }
            }
        }
        signup.setOnClickListener{
            var intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }
    }
}