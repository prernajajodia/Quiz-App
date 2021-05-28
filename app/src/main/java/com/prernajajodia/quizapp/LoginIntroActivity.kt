package com.prernajajodia.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prernajajodia.quizapp.databinding.ActivityLoginIntroBinding

class LoginIntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginIntroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getStartedBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }


    }
}