package com.aram.padatabindingnavigation


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.aram.padatabindingnavigation.databinding.FragmentWinBinding

/**
 * A simple [Fragment] subclass.
 */
class WinFragment : Fragment() {

    private lateinit var binding: FragmentWinBinding
    private var playerInfo = ""
    private var winningNumber = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_win,container,false)
        val args = WinFragmentArgs.fromBundle(arguments!!)
        playerInfo = args.playerInfo
        winningNumber = args.winningNumber


        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            playAgainBtn.setOnClickListener{
                findNavController().navigate(WinFragmentDirections.actionWinFragmentToGameFragment(""))
            }

            congratTv.text = String.format(resources.getString(R.string.congrat),playerInfo)
            winningNumberTv.text = String.format(resources.getString(R.string.winning_number),winningNumber.toString())

            shareBtn.setOnClickListener{

                val shareIntent =Intent(Intent.ACTION_SEND)
                 shareIntent.apply {
                     type = ("text/plain")
                 putExtra(Intent.EXTRA_TEXT,"$playerInfo - $winningNumber")}

                if(shareIntent.resolveActivity(activity!!.packageManager) != null)
                    startActivity(shareIntent) else Toast.makeText(context,"No such activity on device",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return   NavigationUI.onNavDestinationSelected(item,findNavController()) || super.onOptionsItemSelected(item)
    }
}
