package io.github.thiminhnhut.view

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.triggertrap.seekarc.SeekArc
import io.github.thiminhnhut.model.Temperature
import io.github.thiminhnhut.seekarcdemo.R
import kotlinx.android.synthetic.main.fragment_show_temp.view.*

class FragmentTemp: Fragment() {
    companion object {
        private lateinit var temperature: Temperature
        fun newInstance(temperature: Temperature): FragmentTemp {
            this.temperature = temperature
            return FragmentTemp()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_show_temp, container, false)
        val seekArc = view.findViewById<SeekArc>(R.id.seekArc)
        val txtValue = view.findViewById<TextView>(R.id.txtValue)

        txtValue.text = (seekArc.progress + temperature.min).toString()

        seekArc.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener{
            override fun onProgressChanged(p0: SeekArc?, p1: Int, p2: Boolean) {
                txtValue.text = (p1 + temperature.min).toString()
            }

            override fun onStartTrackingTouch(p0: SeekArc?) {
            }

            override fun onStopTrackingTouch(p0: SeekArc?) {
            }
        })
        return view
    }
}