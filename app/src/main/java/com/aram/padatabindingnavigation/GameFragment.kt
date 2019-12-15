package com.aram.padatabindingnavigation


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.aram.padatabindingnavigation.databinding.FragmentGameBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private var number = 0
    private var player = Player()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)


       val args = GameFragmentArgs.fromBundle(arguments!!)
       player = args.player

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            managingGuessBtn()
            guessingNumber()
        }
    }

    private fun FragmentGameBinding.managingGuessBtn() {
        numberEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    guessBtn.isEnabled = p0.toString().trim().isNotEmpty()
                }
            }
        })

    }

    private fun FragmentGameBinding.guessingNumber() {
        guessBtn.setOnClickListener {
              number = Random().nextInt(100)

            if (numberEt.text.trim().toString().toInt() !in 0..100){
                numberEt.error = getString(R.string.warning)
                return@setOnClickListener
            }

            if (number.toString() == numberEt.text.toString().trim()) {
                //findNavController().navigate(R.id.action_gameFragment_to_winFragment)
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToWinFragment(number,player))

            } else {
               // findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(player))
            }
        }
    }

}
