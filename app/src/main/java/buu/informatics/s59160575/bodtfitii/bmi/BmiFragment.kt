package buu.informatics.s59160575.bodtfitii.bmi


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
import buu.informatics.s59160575.bodtfitii.bmi.BmiFragmentDirections
import buu.informatics.s59160575.bodtfitii.R
import buu.informatics.s59160575.bodtfitii.databinding.FragmentBmiBinding

/**
 * A simple [Fragment] subclass.
 */
class BmiFragment : Fragment() {
    private lateinit var binding: FragmentBmiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bmi,container,false)
        binding.apply {
            bmiBackButton.setOnClickListener{
                findNavController().navigate(R.id.action_bmiFragment_to_homeFragment)
            }
            bmiCalculatorButton.setOnClickListener{
                calculatorBMI(view)


            }
        }
        return binding.root
    }

    fun calculatorBMI(view: View?) {
        binding.apply {
            if(hightEditBmiNum.text.isEmpty()){
                Toast.makeText( context, "please input hight!",Toast.LENGTH_SHORT).show()
            }else if(wightEditBmiNum.text.isEmpty()){
                Toast.makeText( context, "please input weight!", Toast.LENGTH_SHORT).show()
            }else{
                var hight = hightEditBmiNum.text.toString().toInt()
                var wight = wightEditBmiNum.text.toString().toInt()
                var bmi= (wight/((hight*1.0/100)*(hight*1.0/100)))
                var result: String
                Log.i("BmiFragment", "bmi = ${bmi}")


                if(bmi<18.5){
                    result = "%.2f".format(bmi).toDouble().toString()+"  น้ำหนักน้อยกว่าปกติ"
                }else if(bmi>=18.5&&bmi<22.9){
                    result = "%.2f".format(bmi).toDouble().toString()+"  สมส่วน"
                }else if(bmi>=23&&bmi<25){
                    result  = "%.2f".format(bmi).toDouble().toString()+"  น้ำหนักเกิน"
                }else if(bmi>=25&&bmi<30){
                    result = "%.2f".format(bmi).toDouble().toString()+"  โรคอ้วน"
                }else{
                    result = "%.2f".format(bmi).toDouble().toString()+"  โรคอวนอันตราย"
                }
                view!!.findNavController().navigate(
                    BmiFragmentDirections.actionBmiFragmentToResultFragment(
                        result,
                        "bmi"
                    )
                )
            }


        }

    }


}
