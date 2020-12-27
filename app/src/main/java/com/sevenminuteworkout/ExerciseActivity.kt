package com.sevenminuteworkout

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_exercise.*
import java.util.*

class ExerciseActivity : AppCompatActivity(),TextToSpeech.OnInitListener{


    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var excerciseTimer : CountDownTimer? = null
    private var excerciseProgress = 0
    private var exerciseList: ArrayList<ExerciseModel>?=null
    private var currentexcerciseposition=-1
    private var tts :TextToSpeech?=null

    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        setSupportActionBar(toolbar_exercise_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        tts = TextToSpeech(this,this)

             exerciseList= Constants.defaultExerciseList()
             setupRestView()

    }



    private fun setupRestView() {
        llexcerciseview.visibility=View.GONE
        llRestView.visibility=View.VISIBLE
        speakout("Next Exercise" + exerciseList!![currentexcerciseposition+1].getName())

        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        nextworkout.text=" Next Exercise ${exerciseList!![currentexcerciseposition+1].getName()}"


        setRestProgressBar()
    }

    private fun setRestProgressBar() {
        progressBar.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress = 10 - restProgress
                tvTimer.text =
                    (10 - restProgress).toString()
            }

            override fun onFinish() {
                currentexcerciseposition++
               setupEcerciseView()





            }
        }.start()
    }
    private fun setexerciseProgressBar() {
        progressBarexcercise.progress = excerciseProgress
        excerciseTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
               excerciseProgress++
                progressBarexcercise.max=30
            progressBarexcercise.progress= 30 -excerciseProgress
                tvTimerexcercise.text =
                        (30 - excerciseProgress).toString()

            }

            override fun onFinish() {

               if (currentexcerciseposition<exerciseList!!.size-1){
                   setupRestView()
               }else{







                   Snackbar.make(llexcerciseview,"WELL DONE ",Snackbar.LENGTH_LONG).show()




            }}
        }.start()
    }
    private fun setupEcerciseView() {
        llRestView.visibility=View.GONE
        llexcerciseview.visibility=View.VISIBLE
        speakout( exerciseList!![currentexcerciseposition].getName())

        if (excerciseTimer!= null) {
            excerciseTimer!!.cancel()
            excerciseProgress = 0
        }


       setexerciseProgressBar()
        ivExcercise.setImageResource(exerciseList!![currentexcerciseposition].getImage())
        tvexcersiname.text=exerciseList!![currentexcerciseposition].getName()
    }


    public override fun onDestroy() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        if (excerciseTimer != null) {
            excerciseTimer!!.cancel()
            excerciseProgress= 0
        }
        if (tts != null) {
            tts!!.stop()

        }
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        if(status==TextToSpeech.SUCCESS){
            val result=  tts!!.setLanguage(Locale.US)
            if (result==TextToSpeech.LANG_MISSING_DATA  || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("ERROR TTS","EROR")

            }

        }else{
            Log.e("tts","INIATILISATION FAILED")
        }
    }
    private  fun speakout(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }}


