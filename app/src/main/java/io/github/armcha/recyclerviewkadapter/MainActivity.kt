package io.github.armcha.recyclerviewkadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.armcha.recyclerviewkadapter.kadapter.setUp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOf<User>()

        val users = mutableListOf<User>()
        repeat(100){
            users+=User("Name is $it","Surname is $it")
        }

        recyclerView.setUp(users, R.layout.item_layout, {
            nameText.text = it.name
            surNameText.text = it.surname
        })
    }
}

class User(val name: String, val surname: String)
