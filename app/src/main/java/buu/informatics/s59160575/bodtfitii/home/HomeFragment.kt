package buu.informatics.s59160575.bodtfitii.home


import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160575.bodtfitii.R
import buu.informatics.s59160575.bodtfitii.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
        private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate(inflater,
           R.layout.fragment_home,container,false)
        binding.bmiButton.setOnClickListener {
                view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_bmiFragment)
        }
        binding.fatCalButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_fatCalculatorFragment)
        }

        binding.caloriesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_caloriesFragment)
        }


        setHasOptionsMenu(true)

        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("bmiFragment", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("bmiFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("bmiFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("bmiFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("bmiFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("bmiFragment", "onDestroyView called")
    }


}
