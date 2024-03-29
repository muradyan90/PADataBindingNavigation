package com.aram.padatabindingnavigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.aram.padatabindingnavigation.databinding.FragmentGameOverBinding
import com.aram.padatabindingnavigation.databinding.FragmentWinBinding

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment() {

    private lateinit var binding: FragmentGameOverBinding
    private var player = Player()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)
        val bundle = arguments
        if(bundle != null){
        val args = GameOverFragmentArgs.fromBundle(bundle)
        player = args.player
        binding.player = player
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            playAgainBtn.setOnClickListener {

                findNavController().navigate(
                    GameOverFragmentDirections.actionGameOverFragmentToGameFragment(
                        this@GameOverFragment.player
                    )
                )
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}
