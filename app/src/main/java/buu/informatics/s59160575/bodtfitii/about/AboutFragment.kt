package buu.informatics.s59160575.bodtfitii.about


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160575.bodtfitii.R
import buu.informatics.s59160575.bodtfitii.databinding.FragmentAboutBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {
        private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_about,container,false)
        // Inflate the layout for this fragment

        binding.apply {
            backAboutButton.setOnClickListener {
                findNavController().navigate(R.id.action_aboutFragment_to_homeFragment)
            }
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("bmiFragment", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("AboutFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("AboutFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("AboutFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("AboutFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("AboutFragment", "onDestroyView called")
    }


}
