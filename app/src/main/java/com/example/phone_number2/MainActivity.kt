package com.example.phone_number2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phone_number2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList= mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample1,"김현수","010-1111-2222",true))
        dataList.add(MyItem(R.drawable.sample2,"김현주","010-3331-2442",false))
        dataList.add(MyItem(R.drawable.sample3,"김아수","010-4441-2992",true))
        dataList.add(MyItem(R.drawable.sample4,"이현수","010-4551-2772",false))
        dataList.add(MyItem(R.drawable.sample5,"주사수","010-6666-2211",true))
        dataList.add(MyItem(R.drawable.sample6,"오주수","010-9999-2332",false))

        val adapter=Adapter(dataList)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
    }
}