package buu.informatics.s59160575.bodtfitii.caloriescal


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
import buu.informatics.s59160575.bodtfitii.caloriescal.CaloriesFragmentDirections
import buu.informatics.s59160575.bodtfitii.R
import buu.informatics.s59160575.bodtfitii.databinding.FragmentCaloriesBinding

/**
 * A simple [Fragment] subclass.
 */
class CaloriesFragment : Fragment() {
    private lateinit var  binding : FragmentCaloriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_calories, container, false)
        binding.apply {
            caloriesBackButton.setOnClickListener {
                findNavController().navigate(R.id.action_caloriesFragment_to_homeFragment)
                }
            caloriesCalButton.setOnClickListener {
                calculatorCalories(view!!)





                }
            return binding.root
        }



    }
    fun calculatorCalories(view: View) {
        binding.apply {



            if(caloriesAgeNum.text.isEmpty()){
                Toast.makeText( context, "please input age!",Toast.LENGTH_SHORT).show()
            }else if((caloriesHightNum.text.isEmpty())){
                Toast.makeText( context, "please input hight!",Toast.LENGTH_SHORT).show()
            }else if((caloriesWeightNum.text.isEmpty())){
                Toast.makeText( context, "please input Weight!",Toast.LENGTH_SHORT).show()
            }else{
                var age = caloriesAgeNum.text.toString().toInt()
                var hight = caloriesHightNum.text.toString().toInt()
                var weight = caloriesWeightNum.text.toString().toInt()


                var BMR: Double
                var result = ""
                if (genderFemale.isChecked){
                    Toast.makeText( context, "female",Toast.LENGTH_SHORT).show()
                    BMR = (665+(9.6 *weight)+(1.8 *hight)-(4.7 *age)).toString().toDouble()
                    result = "%.2f".format(BMR).toDouble().toString()+ " แคลอรี่"
                }else if(genderMale.isChecked){
                    Toast.makeText( context, "male",Toast.LENGTH_SHORT).show()
                    BMR = (66 + (13.7 *weight)+(5  *hight)-(6.8 *age)).toString().toDouble()
                    result = "%.2f".format(BMR).toDouble().toString()+ " แคลอรี่"
                }else{
                    Toast.makeText( context, "Please select Gender.",Toast.LENGTH_SHORT).show()
                }
                view.findNavController().navigate(
                    CaloriesFragmentDirections.actionCaloriesFragmentToResultFragment(
                        result,
                        "bmr"
                    )
                )
            }



        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("caloriesFragment", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("caloriesFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("caloriesFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("caloriesFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("caloriesFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("caloriesFragment", "onDestroyView called")
    }

}
