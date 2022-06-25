package com.quick_example.apitodolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.quick_example.apitodolist.databinding.ActivityToDoListApiAcitvityBinding
import com.quick_example.apitodolist.service.RetrofitTodoApiData
import com.quick_example.apitodolist.ui.utils.ToDoListAdapter
import retrofit2.HttpException
import java.io.IOException

class ToDoListApiAcitvity : AppCompatActivity() {
    private lateinit var todoadapter: ToDoListAdapter

    private lateinit var binding: ActivityToDoListApiAcitvityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityToDoListApiAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecView() //calling our private recyclerview

        //coroutine scope used for loading the data online
        lifecycleScope.launchWhenCreated {
            //calling progress call to make it visible
            binding.progressbarTodoApi.isVisible= true

            //surrounding with try catch in case user has issues with connection or else

            val response = try {
                //todos list called
                RetrofitTodoApiData.todoapi.getTodos()
            }catch(e: IOException){
                Log.d("ApiResultError", "Check internet connection ")
                binding.progressbarTodoApi.isVisible= false
                Toast.makeText(this@ToDoListApiAcitvity,"Connection Error !",Toast.LENGTH_SHORT).show()
                return@launchWhenCreated
            }catch(e: HttpException){
                Log.d("ApiResultError", "Unexpected response")
                binding.progressbarTodoApi.isVisible= false
                Toast.makeText(this@ToDoListApiAcitvity,"Server Error !",Toast.LENGTH_SHORT).show()
                return@launchWhenCreated
            }
           if(response.isSuccessful && response.body() != null){
               //filling data following the json received from our api !
                todoadapter.todos = response.body()!!
           }else{
               Toast.makeText(this@ToDoListApiAcitvity,"No data returned !",Toast.LENGTH_SHORT).show()
               Log.d("ApiResultError", "No results were returned !")
           }
            binding.progressbarTodoApi.isVisible = false
        }
    }


    //creating own function for recyclerview to not always call recyclerview. ....
    private fun setupRecView() = binding.rvTodoApi.apply{
        todoadapter = ToDoListAdapter()
        adapter = todoadapter
        layoutManager = LinearLayoutManager(this@ToDoListApiAcitvity)
    }
}