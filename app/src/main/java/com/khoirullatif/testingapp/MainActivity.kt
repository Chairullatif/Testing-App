package com.khoirullatif.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView
    private lateinit var imgPreview: ImageView

    private var namesArray = ArrayList<String>()
//    jika kita ingin membuat variabel list tanpa langsung menambahkan nilainya.
//    Maka list tersebut tidak memiliki nilai yang bisa dijadikan acuan untuk kompiler menentukan tipe parameter yaitu: <...>
//    Alhasil, kita wajib menentukannya secara eksplisit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tv_text)
        //test 1. blm di inisialisaasi btn nya
        btnSetValue = findViewById(R.id.btn_set_value)
        btnSetValue.setOnClickListener(this)
        imgPreview = findViewById(R.id.img_preview)

        imgPreview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.fronalpstock_big))

        Glide.with(this).load(R.drawable.fronalpstock_big).into(imgPreview)

        namesArray.add("Chairullatif")
        namesArray.add("Aji")
        namesArray.add("Sadewa")
    }

    override fun onClick(p0: View?) {
        if (p0?.id == btnSetValue.id) {
            Log.d("MainActivity", namesArray.toString()) // nulisnya bisa langsung pake logd (l kecil)
            val name = StringBuilder()
            // Test 2. indexoutofboundException
            for (i in 0..2) {
                name.append(namesArray[i]).append("\n")
            }
            tvText.text = name.toString()
        }
    }
}