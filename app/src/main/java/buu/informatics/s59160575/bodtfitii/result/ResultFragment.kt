package buu.informatics.s59160575.bodtfitii.result


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160575.bodtfitii.R
import buu.informatics.s59160575.bodtfitii.result.ResultFragmentArgs
import buu.informatics.s59160575.bodtfitii.databinding.FragmentResultBinding

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_result,container,false)
        // Inflate the layout for this fragment
        val args = ResultFragmentArgs.fromBundle(arguments!!)
        Log.i("test","${args.result}")
        binding.apply {
            showResult.text = args.result

            resultHomeButton.setOnClickListener {
                findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {
        val args =
            ResultFragmentArgs.fromBundle(
                arguments!!
            )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.type, args.result))
        return shareIntent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.result_share, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.setVisible(false)
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("resultFragment", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("resultFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("resultFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("resultFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("resultFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("resultFragment", "onDestroyView called")
    }

}
