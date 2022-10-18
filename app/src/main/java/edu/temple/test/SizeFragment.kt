package edu.temple.test

import android.os.Bundle
import android.util.Half.toFloat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.lifecycle.ViewModelProvider

class SizeFragment : Fragment() {

    private lateinit var textViewModel : textSizeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textViewModel = ViewModelProvider(requireActivity())[textSizeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_size, container, false)
    }

    interface ValueChangeInterface {
        fun onChange(value: Int)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (view.findViewById(R.id.seekBar) as SeekBar) {
            setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, user: Boolean) {

                    // Inform parent about slider event with updated value
                    //(requireActivity() as ValueChangeInterface).onChange(progress)
                    textViewModel.setText(progress.toFloat())


                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}

            })
        }
    }

}