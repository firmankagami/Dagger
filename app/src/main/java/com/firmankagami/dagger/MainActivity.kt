package com.firmankagami.dagger

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firmankagami.dagger.adapter.UserAdapter
import com.firmankagami.dagger.di.DaggerUserComponent
import com.firmankagami.dagger.di.UserModule
import com.firmankagami.dagger.utils.Result
import com.firmankagami.dagger.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var adapter: UserAdapter
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
        adapter = UserAdapter(mutableListOf())

        rv_users.setHasFixedSize(true)
        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter

        getUserList()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        inject()
        return super.onCreateView(name, context, attrs)
    }

    private fun getUserList(){
        viewModel.getUserList("1").observe(this, { result ->

            if (result != null){
                when(result){

                    is Result.Success -> {
                        val data = result.data
                        data.data?.forEach{
                            adapter.addUser(it)
                        }
                    }

                    is Result.Error -> {
                        Toast.makeText(
                            this,
                            "Terjadi kesalahan" + result.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
    }


    private fun inject(){
        DaggerUserComponent
            .builder()
            .userModule(UserModule())
            .build()
            .inject(this)
    }
}