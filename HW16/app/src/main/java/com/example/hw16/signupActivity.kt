package com.example.hw16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class signupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)
        var repassword = findViewById<EditText>(R.id.repassword)
        var login = findViewById<Button>(R.id.login)
        var DB = DBHelper(this);

        login.setOnClickListener{
            var user = username.getText().toString()
            var pass = password.getText().toString()
            var repass = repassword.getText().toString()

            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)){
                    Toast.makeText(this, "有空白未填", Toast.LENGTH_SHORT).show()
                }
            else{
                if(pass.equals(repass)){
                    var checkuser = DB.checkusername(user)
                    if(checkuser == false){
                        var insert = DB.insertData(user,pass)
                        if(insert == true) {
                            Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show()
                            var intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "註冊失敗", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this, "用戶已被註冊", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "密碼不匹配", Toast.LENGTH_SHORT).show()
                }
                }
            }
    }
}