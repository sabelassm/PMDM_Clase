package com.example.ud05_1_pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)


        val fabNext = view.findViewById<FloatingActionButton>(R.id.fab)
        fabNext.setOnClickListener {
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.group_pizza_type)
            val pizzaType = pizzaGroup.checkedRadioButtonId
            var msg =""
            if(pizzaType==-1){
                msg = "Debes seleccionar un tipo de pizza"
            }else{
                msg ="Has seleccionado una pizza de tipo "
                //Tipo de pizza
                msg+= when(pizzaType){
                    R.id.radio_margarita -> "Margarita"
                    R.id.radio_calzone -> "Calzone"
                    else -> "No existe"
                }
                //Extras
                var parmesano = view.findViewById<Chip>(R.id.chip_parmesano)
                if(parmesano.isChecked) msg+= " con pamersano"
                var tomate = view.findViewById<Chip>(R.id.chip_tomate_cherry)
                if(tomate.isChecked) msg+= " con tomate cherry"

            }
            //Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            val snackbar = Snackbar.make(fabNext, msg, Snackbar.LENGTH_SHORT)
            snackbar.setAction("Undo"){
                pizzaGroup.clearCheck()
            }
            snackbar.show()


        }
        return view
    }

}