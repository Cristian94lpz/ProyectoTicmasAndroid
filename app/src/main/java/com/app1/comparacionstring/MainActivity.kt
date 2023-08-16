package com.app1.comparacionstring

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.app1.comparacionstring.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.casilla1.addTextChangedListener {

            if(it != null) mainViewModel.setText(it,1)



        }
        binding.casilla2.addTextChangedListener {

           if(it != null) mainViewModel.setText(it,2)


        }
        binding.compara.setOnClickListener {
            mainViewModel.compara()
        }

        mainViewModel.texto.observe(this){
                when(it.resultado){
                    true -> binding.textView.text = "Las cadenas de texto son iguales"
                    false -> binding.textView.text = "Las cadenas de texto son diferentes"
                    null-> binding.textView.text = "Completa ambas casillas de texto"
                }

        }
    }
}