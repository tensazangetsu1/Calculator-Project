package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun btnSayiTik(view: View) {
        if (yeniOperator){
            binding.sayiGoster.setText("")
        }
        yeniOperator=false
        var btnSec = view as Button
        var btnTikDeger:String = binding.sayiGoster.text.toString()
        when(btnSec.id){
            binding.btn0.id->{
                btnTikDeger+="0"
            }
            binding.btn1.id->{
                btnTikDeger+="1"
            }
            binding.btn2.id->{
                btnTikDeger+="2"
            }
            binding.btn3.id->{
                btnTikDeger+="3"
            }
            binding.btn4.id->{
                btnTikDeger+="4"
            }
            binding.btn5.id->{
                btnTikDeger+="5"
            }
            binding.btn6.id->{
                btnTikDeger+="6"
            }
            binding.btn7.id->{
                btnTikDeger+="7"
            }
            binding.btn8.id->{
                btnTikDeger+="8"
            }
            binding.btn9.id->{
                btnTikDeger+="9"
            }
            binding.btnArtEksi.id->{
                btnTikDeger="-"+btnTikDeger
            }
        }
        binding.sayiGoster.setText(btnTikDeger)
    }
    var operator="*"
    var eskiSayi=""
    var yeniOperator=true
    fun btnOpTik(view: View) {
        var btnSec=view as Button
        when(btnSec.id){
            binding.btnBolme.id->{
                operator="/"
            }
            binding.btnCarpim.id->{
                operator="x"
            }
            binding.btnCikarma.id->{
                operator="-"
            }
            binding.btnToplama.id->{
                operator="+"
            }
        }
        eskiSayi=binding.sayiGoster.text.toString()
        yeniOperator=true
    }
    fun btnEsittirTik(view: View) {
        var yeniSayi=binding.sayiGoster.text.toString()
        var sonucSayisi:Double?=null
        when(operator) {
            "/"->{
                sonucSayisi=eskiSayi.toDouble()/yeniSayi.toDouble()
            }
            "x"->{
                sonucSayisi=eskiSayi.toDouble()*yeniSayi.toDouble()
            }
            "-"->{
                sonucSayisi=eskiSayi.toDouble()-yeniSayi.toDouble()
            }
            "+"->{
                sonucSayisi=eskiSayi.toDouble()+yeniSayi.toDouble()
            }
        }
        binding.sayiGoster.setText(sonucSayisi.toString())
        yeniOperator=true
    }
}