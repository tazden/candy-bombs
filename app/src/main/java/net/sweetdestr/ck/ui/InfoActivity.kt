package net.sweetdestr.ck.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import net.sweetdestr.ck.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val back=findViewById<ImageView>(R.id.back)
        back.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val exit=findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener(){
            finishAffinity()
        }
    }
}