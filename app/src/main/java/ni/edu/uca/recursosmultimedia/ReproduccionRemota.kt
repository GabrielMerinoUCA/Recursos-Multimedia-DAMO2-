package ni.edu.uca.recursosmultimedia

import  android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ni.edu.uca.recursosmultimedia.databinding.FragmentReproduccionRemotaBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReproduccionRemota.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReproduccionRemota : Fragment() {

    private lateinit var binding: FragmentReproduccionRemotaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentReproduccionRemotaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPlay.setOnClickListener {
            reproducir_video()
        }
    }

    private fun reproducir_video() {

        // Obtener la instancia de VideoView y EditText
        val videoView = binding.videoView
        val buttonPlay = binding.buttonPlay
        val editTextUrl = binding.editTextUrl

        // Establecer el OnClickListener en el botón de reproducción
        buttonPlay.setOnClickListener {
            // Obtener la URL ingresada por el usuario en el EditText
            val url = editTextUrl.text.toString()

            // Establecer la fuente de datos del video remoto utilizando la URL ingresada
            videoView.setVideoURI(Uri.parse(url))

            // Iniciar la reproducción del video
            videoView.start()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReproduccionRemota.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReproduccionRemota().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
