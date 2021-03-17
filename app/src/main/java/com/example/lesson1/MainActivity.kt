package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val wordsStorage = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {

            btnAdd.setOnClickListener {
                wordsStorage.add(etDataInput.text.toString())
                etDataInput.setText(String())
            }

            btnShow.setOnClickListener {
                wordsStorage.sortBy { it.toLowerCase() }
                tvDataOutput.text = wordsStorage.joinToString("\n")
                wordsStorage.clear()
            }
        }

        setContentView(binding.root)
    }
}