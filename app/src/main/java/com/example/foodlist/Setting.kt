import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.foodlist.R
import com.example.foodlist.SettSave
import com.example.foodlist.TextSize
import com.example.foodlist.databinding.FragmentSettingBinding


class Setting : Fragment(R.layout.fragment_setting) {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingBinding.bind(view)
        var saveSetting = SettSave(requireContext())
        binding.apply {
            when(saveSetting.getFontSize()){
                TextSize.Small.size -> smallRB.isChecked =true
                TextSize.Medium.size -> medRB.isChecked =true
                TextSize.Large.size -> largRB.isChecked =true
               else ->smallRB.isChecked=true
            }
            radiogroup.setOnCheckedChangeListener { radioGroup,i->
                when(radioGroup.checkedRadioButtonId){
                    R.id.smallRB -> saveSetting.setFontSize(TextSize.Small)
                    R.id.medRB -> saveSetting.setFontSize(TextSize.Medium)
                    R.id.largRB -> saveSetting.setFontSize(TextSize.Large)


                }
            }
        }
  }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}