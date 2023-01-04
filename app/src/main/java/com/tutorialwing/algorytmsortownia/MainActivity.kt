package com.tutorialwing.algorytmsortownia

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.widget.ProgressBar
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = findViewById<EditText>(R.id.input1)
        val text = findViewById<TextView>(R.id.wypisz1)
        var arrNums: MutableList<Int> = mutableListOf()

        findViewById<Button>(R.id.losuj).setOnClickListener {
            val rand = Random()
            text.text=""
            for (int in 1 ..  edit.text.toString().toInt()) {
                val a= rand.nextInt(edit.text.toString().toInt())
                text.append(a.toString())

            }
        }
        findViewById<Button>(R.id.sortuj).setOnClickListener {

            findViewById<ProgressBar>(R.id.pbProgress).progress = 0
            findViewById<ProgressBar>(R.id.pbProgress).max = arrNums.size

            var arrNumsSorted: List<Int> = quicksort(arrNums)

            findViewById<TextView>(R.id.input1).text = ""
            for (element in arrNumsSorted) {
                findViewById<TextView>(R.id.tvNumbers).append(element.toString()+" ")
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
                it < chosenItem -> {smallerList.add(it) ; findViewById<ProgressBar>(R.id.pbProgress).progress += 1}
                it > chosenItem -> {greaterList.add(it) ; findViewById<ProgressBar>(R.id.pbProgress).progress += 1}
                else -> {equalList.add(it) ; findViewById<ProgressBar>(R.id.pbProgress).progress += 1}
            }
        }

        val sortedList: MutableList<Int> = mutableListOf()
        sortedList.addAll(quicksort(smallerList))
        sortedList.addAll(equalList)
        sortedList.addAll(quicksort(greaterList))
        return sortedList
    }

}
    }
}