package buu.informatics.s59160575.bodtfitii.fatcalculator


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160575.bodtfitii.fatcalculator.FatCalculatorFragmentDirections
import buu.informatics.s59160575.bodtfitii.R
import buu.informatics.s59160575.bodtfitii.databinding.FragmentFatCalculatorBinding

/**
 * A simple [Fragment] subclass.
 */
class FatCalculatorFragment : Fragment() {
    private lateinit var binding: FragmentFatCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentFatCalculatorBinding>(inflater,
            R.layout.fragment_fat_calculator,container,false)
       binding.apply {
           fatBackButton.setOnClickListener{
               findNavController().navigate(R.id.action_fatCalculatorFragment_to_homeFragment)
           }
           fatCalButton.setOnClickListener{
                calculatorFat()
           }
       }
        return binding.root
    }
fun calculatorFat(){
    binding.apply {
        var result: String
        if(fatAgeNum.text.isEmpty()){
            Toast.makeText( context, "please input age!", Toast.LENGTH_SHORT).show()
        }else if(fatHrNum.text.isEmpty()){
            Toast.makeText( context, "please input heart rate!",Toast.LENGTH_SHORT).show()
        }else{
            var age = fatAgeNum.text.toString().toInt()
//            var hr = fatHrNum.text.toString().toInt()
            var hrRate = 220 - age;
            hrRate = hrRate*80/100

            result  = "ชีพจรที่เหมาะสม เพื่อเบิร์นใขมัน"+ "${hrRate*80/100}" +"ครั้งต่อนาที"
            view!!.findNavController().navigate(
                FatCalculatorFragmentDirections.actionFatCalculatorFragmentToResultFragment(
                    result,
                    "Fatburn"
                )
            )
        }
    }

}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("fatCalculatorFragment", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("fatCalculatorFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("fatCalculatorFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("fatCalculatorFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("fatCalculatorFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fatCalculatorFragment", "onDestroyView called")
    }
}
