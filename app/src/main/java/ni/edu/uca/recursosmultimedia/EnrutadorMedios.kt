package ni.edu.uca.recursosmultimedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.MimeTypes

import ni.edu.uca.recursosmultimedia.databinding.FragmentEnrutadorMediosBinding
import ni.edu.uca.recursosmultimedia.databinding.FragmentReproduccionRemotaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EnrutadorMedios.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnrutadorMedios : Fragment() {

    private lateinit var simpleExoPlayerView: PlayerView
    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_enrutador_medios, container, false)
        simpleExoPlayerView = view.findViewById(R.id.video_player_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initializePlayer()

    }

    private fun initializePlayer() {

        val trackSelector = DefaultTrackSelector(requireContext()).apply {
            setParameters(buildUponParameters().setMaxVideoSizeSd())
        }

        player = SimpleExoPlayer.Builder(requireContext()).setTrackSelector(trackSelector).build()
        simpleExoPlayerView.player = player

        val mediaItem = MediaItem.Builder().setUri(getString(R.string.media_url_dash)).setMimeType(MimeTypes.APPLICATION_MPD).build()

        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }


    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EnrutadorMedios.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnrutadorMedios().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}