package com.example.quizapp

import android.content.Intent
import android.content.pm.ActivityInfo
// import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
          window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start.setOnClickListener {
            // add validation
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.User_Name,et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}