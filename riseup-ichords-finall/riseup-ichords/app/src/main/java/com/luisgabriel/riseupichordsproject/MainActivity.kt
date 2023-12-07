package com.luisgabriel.riseupichordsproject

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.luisgabriel.riseupichordsproject.databinding.ActivityMainBinding
import com.luisgabriel.riseupichordsproject.databinding.Custompopup2Binding
import com.luisgabriel.riseupichordsproject.databinding.Custompopup3Binding
import com.luisgabriel.riseupichordsproject.databinding.Custompopup4Binding
import com.luisgabriel.riseupichordsproject.databinding.Custompopup5Binding
import com.luisgabriel.riseupichordsproject.databinding.CustompopupBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var popUpBinding: CustompopupBinding
    lateinit var popUp2Binding: Custompopup2Binding
    lateinit var popUp3Binding: Custompopup3Binding
    lateinit var popUp4Binding: Custompopup4Binding
    lateinit var popUp5Binding: Custompopup5Binding
    lateinit var popup: Dialog
    lateinit var popup2: Dialog
    lateinit var popup3: Dialog
    lateinit var popup4: Dialog
    lateinit var popup5: Dialog




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        popUpBinding = CustompopupBinding.inflate(LayoutInflater.from(this))
        popUpBinding.buttonPopup.setOnClickListener(this)
        initPopUps()
        popup.show()

    }

    // Funcionamento trocar de telas navBar
    private fun initNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.btNavView, navController)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_popup) {
            popup.dismiss()
            popup2.show()
        } else if ( v.id == R.id.button_popup_2) {
            navController.navigate(R.id.menu_musicas)
            popup2.dismiss()
            popup3.show()
        } else if( v.id == R.id.button_popup_3) {
            navController.navigate(R.id.menu_desafios)
            popup3.dismiss()
            popup4.show()
        } else if (v.id == R.id.button_popup_4) {
            navController.navigate(R.id.menu_mais)
            popup4.dismiss()
            popup5.show()
        } else if (v.id == R.id.button_popup_5) {
            navController.navigate(R.id.menu_home)
            popup5.dismiss()
        }
    }

    fun initPopUps() {
        //POP UP 1
        popUpBinding = CustompopupBinding.inflate(LayoutInflater.from(this))
        popUpBinding.buttonPopup.setOnClickListener(this)
        popup = Dialog(this)
        popup.setContentView(popUpBinding.root)
        popup.setCanceledOnTouchOutside(false)
        //POP UP 2
        popUp2Binding = Custompopup2Binding.inflate(LayoutInflater.from(this))
        popUp2Binding.buttonPopup2.setOnClickListener(this)
        popup2 = Dialog(this)
        popup2.setContentView(popUp2Binding.root)
        popup2.setCanceledOnTouchOutside(false)
        //POP UP 3
        popUp3Binding = Custompopup3Binding.inflate(LayoutInflater.from(this))
        popUp3Binding.buttonPopup3.setOnClickListener(this)
        popup3 = Dialog(this)
        popup3.setContentView(popUp3Binding.root)
        popup3.setCanceledOnTouchOutside(false)
        //POP UP 4
        popUp4Binding = Custompopup4Binding.inflate(LayoutInflater.from(this))
        popUp4Binding.buttonPopup4.setOnClickListener(this)
        popup4 = Dialog(this)
        popup4.setContentView(popUp4Binding.root)
        //POP UP 5
        popUp5Binding = Custompopup5Binding.inflate(LayoutInflater.from(this))
        popUp5Binding.buttonPopup5.setOnClickListener(this)
        popup5 = Dialog(this)
        popup5.setContentView(popUp5Binding.root)
        popup5.setCanceledOnTouchOutside(false)
    }

}