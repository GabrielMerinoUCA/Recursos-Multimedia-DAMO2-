package ni.edu.uca.recursosmultimedia

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import ni.edu.uca.recursosmultimedia.databinding.FragmentMaterialMultimediaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MaterialMultimedia.newInstance] factory method to
 * create an instance of this fragment.
 */
class MaterialMultimedia : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fbinding: FragmentMaterialMultimediaBinding
    var imagen: ImageView?=null
    var request: RequestQueue?=null
    var imagenURL: EditText?=null
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
        // Inflate the layout for this fragment
        fbinding = FragmentMaterialMultimediaBinding.inflate(layoutInflater)
        imagen= fbinding.ivImagen
        request= Volley.newRequestQueue(activity)
        imagenURL = fbinding.etURL
        fbinding.btnCargarImagen.setOnClickListener{
            cargarImagen()
        }
        fbinding.btnLimpiar.setOnClickListener{
            borrarURL()
        }
        return fbinding.root
    }

    fun borrarURL(){
        imagenURL?.setText("")
    }

    private fun cargarImagen() {
        var url = "${imagenURL?.text.toString()}"
        val imageRequest = ImageRequest(
            url,
            {bitmap -> // response listener

                imagen?.setImageBitmap(bitmap)

            },
            0, // max width
            0, // max height
            ImageView.ScaleType.CENTER_CROP, // image scale type
            Bitmap.Config.ARGB_8888, // decode config
            {error-> // error listener
                Toast.makeText(activity, "No ha escrito URL o la URL es incorrecta", Toast.LENGTH_LONG).show()
            }
        )
        request?.add(imageRequest)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MaterialMultimedia.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaterialMultimedia().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}