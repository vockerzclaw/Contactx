package com.example.contactx

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_friend_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        tampilMyFriendFragment()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun gantiFragment(fragmentManager: FragmentManager,
                              fragment:Fragment, frameId:Int){
        val transaction =  fragmentManager.beginTransaction()
        transaction.replace(frameId,fragment)
        transaction.commit()
    }
    fun tampilMyFriendFragment(){
        gantiFragment(supportFragmentManager,MyFriendFragment.newInstance(),
            R.id.frameLayout)
    }
    fun tampilAddFriendFragment(){
        gantiFragment(supportFragmentManager,AddFriendFragment.newInstance(),
            R.id.frameLayout)
    }

}
