package com.tutorialwing.algorytmsortownia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.math.sin
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrNums: MutableList<Int> = mutableListOf()

        findViewById<Button>(R.id.losuj).setOnClickListener {
            findViewById<ProgressBar>(R.id.progres).progress = 0
            val numAmount = findViewById<EditText>(R.id.input1).text.toString().toInt() - 1
            arrNums.clear()

            for (i in 0..numAmount) {

                val randed = (0..1000).random()
                arrNums += randed

                findViewById<TextView>(R.id.wypisz1).text = ""
                for (element in arrNums) {
                    findViewById<TextView>(R.id.wypisz1).append(element.toString() + " ")
                }
            }
        }

        findViewById<Button>(R.id.sortuj).setOnClickListener {

            findViewById<ProgressBar>(R.id.progres).progress = 0
            findViewById<ProgressBar>(R.id.progres).max = arrNums.size

            var arrNumsSorted: List<Int> = quicksort(arrNums)

            findViewById<TextView>(R.id.wypisz1).text = ""
            for (element in arrNumsSorted) {
                findViewById<TextView>(R.id.wypisz1).append(element.toString()+" ")
            }
        }

    }


        fun quicksort(items: List<Int>): List<Int> {
            if (items.size <= 1) {
                return items
            }

            val chosenItem: Int = items[items.size / 2]

            val smallerList: MutableList<Int> = mutableListOf()
            val equalList: MutableList<Int> = mutableListOf()
            val greaterList: MutableList<Int> = mutableListOf()
            items.forEach {
                when {
                    it < chosenItem -> {
                        smallerList.add(it); findViewById<ProgressBar>(R.id.progres).progress += 1
                    }
                    it > chosenItem -> {
                        greaterList.add(it); findViewById<ProgressBar>(R.id.progres).progress += 1
                    }
                    else -> {
                        equalList.add(it); findViewById<ProgressBar>(R.id.progres).progress += 1
                    }
                }
            }

            val sortedList: MutableList<Int> = mutableListOf()
            sortedList.addAll(quicksort(smallerList))
            sortedList.addAll(equalList)
            sortedList.addAll(quicksort(greaterList))
            return sortedList
        }

    }


