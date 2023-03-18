package ni.edu.uca.recursosmultimedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ni.edu.uca.recursosmultimedia.databinding.FragmentMenuBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [menu.newInstance] factory method to
 * create an instance of this fragment.
 */
class menu : Fragment() {
    private lateinit var fbinding: FragmentMenuBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentMenuBinding.inflate(layoutInflater)
        initialize()
        return fbinding.root
    }

    private fun initialize() {
        /* Menu navigation */
        fbinding.btnEnrutadorMedios.setOnClickListener {
            Navigation.findNavController(fbinding.root).navigate(R.id.acMenu_EnrutadorMedios)
        }
        fbinding.btnMaterialMultimedia.setOnClickListener {
            Navigation.findNavController(fbinding.root).navigate(R.id.acMenu_MaterialMultimedia)
        }
        fbinding.btnReproduccionRemota.setOnClickListener {
            Navigation.findNavController(fbinding.root).navigate(R.id.acMenu_ReproduccionRemota)
        }
    }


}