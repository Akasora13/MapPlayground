package com.example.mapplayground

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img = findViewById<ImageView>(R.id.bg_id)
        img.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val x = event.x.toInt()
                val y = event.y.toInt()
                val colour: Int = getColour(img,x, y)
                //switch to correct province
                findViewById<TextView>(R.id.textView2).text = colour.toString()
            }
            true
        }
    }

    private fun getColour(img:ImageView, x:Int, y:Int): Int{
        val d = resources.getDrawable(R.drawable.id)
        val b1 = (d as BitmapDrawable).bitmap
        val hotspots = Bitmap.createScaledBitmap(b1, img.width, img.height, false)
        return hotspots.getPixel(x,y)
    }




}