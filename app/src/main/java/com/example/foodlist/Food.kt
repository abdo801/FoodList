import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.foodlist.FoodAdapter
import com.example.foodlist.Foods
import com.example.foodlist.R
import com.example.foodlist.SettSave
import com.example.foodlist.databinding.FragmentFoodBinding


class Food : Fragment(R.layout.fragment_food) {
     private   var _binding:FragmentFoodBinding? =null
    private  val binding get() = _binding!!


    //create the adapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentFoodBinding.bind(view)
         val foodList = mutableListOf(
            Foods("Pizza ", R.drawable.pizzaq),
            Foods ("Fried Chicken", R.drawable.fried_chicken),
            Foods("Sushi", R.drawable.sushi),
             Foods("Pizza ", R.drawable.pizzaq),
             Foods ("Fried Chicken", R.drawable.fried_chicken),
             Foods("Sushi", R.drawable.sushi),
             Foods ("Fried Chicken", R.drawable.fried_chicken),
             Foods("Pizza", R.drawable.pizzaq),
            )

        //assign the adapter to the recyclerView
         val adapter = FoodAdapter(SettSave(requireContext()))
        binding.rvFood.adapter = adapter
        adapter.submitList(foodList)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}