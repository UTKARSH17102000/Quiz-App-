package com.example.quizapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentPosition:Int =1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int =0
    private var mcorrectanswer:Int =0
    var mUser_Name :String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mUser_Name = intent.getStringExtra(Constants.User_Name)
         mQuestionList = Constants.getQuestions()


      setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

    }
     private fun setQuestion(){


         val question:Question? = mQuestionList!![mcurrentPosition-1]

         defaultOptionsView()
         if (mcurrentPosition == mQuestionList!!.size) {
             btn_submit.text = "FINISH"
         } else {
             btn_submit.text = "SUBMIT"
         }

         progressBar.progress = mcurrentPosition
         tv_progress.text = "$mcurrentPosition" + "/" + progressBar.max

         tv_Question.text = question!!.question
         iv_image.setImageResource(question.image)

         tv_option_one.text = question.optionone
         tv_option_two.text = question.optiontwo
         tv_option_three.text = question.optionthree
         tv_option_four.text = question.optionfour

         btn_submit.setOnClickListener(this)

     }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.border)

        }
    }

    override fun onClick(v: View?) {
      when(v?.id){
          R.id.tv_option_one ->{
              selectedoptionView(tv_option_one,1)
          }
          R.id.tv_option_two ->{
              selectedoptionView(tv_option_two,2)
          }
          R.id.tv_option_three ->{
              selectedoptionView(tv_option_three,3)
          }
          R.id.tv_option_four ->{
          selectedoptionView(tv_option_four,4)
      }
          R.id.btn_submit -> {
              if (mSelectedOptionPosition == 0) {
                  mcurrentPosition++

                  when {
                      mcurrentPosition <= mQuestionList!!.size -> {
                          setQuestion()
                      }
                      else -> {
                          val intent = Intent(this,ResultActivity::class.java)
                          intent.putExtra(Constants.User_Name,mUser_Name)
                          intent.putExtra(Constants.CORRECT_ANSWER,mcorrectanswer)
                          intent.putExtra(Constants.Total_Question,mQuestionList!!.size)
                          startActivity(intent)
                          finish()

                      }
                  }
              } else {
                  val question = mQuestionList?.get(mcurrentPosition - 1)

                  if (question!!.correctAnswer != mSelectedOptionPosition) {
                      answerView(mSelectedOptionPosition, R.drawable.wrongoption)
                  }else{
                      mcorrectanswer++
                  }

                  answerView(question.correctAnswer, R.drawable.correctoptionborder)

                  if (mcurrentPosition == mQuestionList!!.size) {
                      btn_submit.text = "FINISH"
                  } else {
                      btn_submit.text = "GO TO NEXT QUESTION"
                  }

                  mSelectedOptionPosition =0
              }
          }


      }
    }

    private fun answerView(answer:Int,drawableView: Int){
        when(answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    fun selectedoptionView(tv:TextView,Selectedoption:Int){

        defaultOptionsView()
        mSelectedOptionPosition = Selectedoption

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(this,R.drawable.selectedborder)

    }
}