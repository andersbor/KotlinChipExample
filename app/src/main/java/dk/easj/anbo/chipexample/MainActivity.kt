package dk.easj.anbo.chipexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import dk.easj.anbo.chipexample.databinding.ActivityMainBinding

// Inspiration:
// https://material.io/components/chips
// https://howtodoandroid.com/android-chips-material-component/

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.coffeeChip.setOnClickListener {
            binding.messageView.text = "Clicked"
        }

        binding.coffeeChip.setOnCheckedChangeListener { compoundButton, checked ->
            binding.messageView.text = checked.toString()
        }

        binding.chipGroupFilter.setOnCheckedChangeListener { group, checkedId ->
            /*when (checkedId) {
                R.id.best_offer_chip -> binding.messageView.text = "Best Offer"
                R.id.fast_selling_chip -> binding.messageView.text = "Fast selling"
            }*/
            // https://howtodoandroid.com/android-chips-material-component/
            val chip: Chip = group.findViewById(checkedId)
            binding.messageView.text = "You want " + chip.text
        }
    }
}