package com.example.abdur

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*


class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
    constructor(val intValue: Int) {
        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TxtLogin = findViewById<TextView>(R.id.editTextTextPersonName);
        val TxtPass = findViewById<TextView>(R.id.editTextTextPersonName2);
        val Btn = findViewById<Button>(R.id.button);

        Btn.setOnClickListener {
            when(CheckLogin(TxtLogin.text.toString() , TxtPass.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext , getString(R.string.errLogin) , Toast.LENGTH_LONG).show()
                    TxtLogin.requestFocus()

                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext , getString(R.string.errPass) , Toast.LENGTH_LONG).show()
                    TxtPass.requestFocus()
                }

                else ->
                {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext , "Success" , Toast.LENGTH_LONG)
                }
            }
        }


    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess{
        val holdLogin = "Daniel"
        val holdPass = "Booker"

        if(holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword){
            LoginSuccess.password

        } else LoginSuccess.success
    }



}