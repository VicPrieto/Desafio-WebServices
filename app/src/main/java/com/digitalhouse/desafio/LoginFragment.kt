package com.digitalhouse.desafio

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_login, container, false)

        view.tv_register.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        view.btn_login.setOnClickListener{
            callHome()
        }

        return view
    }

    fun callHome(){
        var intent = Intent(SplashActivity(), HomeActivity::class.java)
        startActivity(intent)
    }

}