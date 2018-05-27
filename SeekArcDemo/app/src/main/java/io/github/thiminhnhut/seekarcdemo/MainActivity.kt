package io.github.thiminhnhut.seekarcdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.thiminhnhut.model.Temperature
import io.github.thiminhnhut.view.FragmentTemp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val temperature = Temperature(16, 31)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.layout_root, FragmentTemp.newInstance(temperature))
            fragmentTransaction.commit()
        }
    }
}
