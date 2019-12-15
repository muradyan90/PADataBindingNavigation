package com.aram.padatabindingnavigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.aram.padatabindingnavigation.databinding.FragmentRegistrationBinding

/**
 * A simple [Fragment] subclass.
 */
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var name: String
    private lateinit var lastName: String
    private var player = Player()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registration,
            container, false
        )

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            binding.startBtn.setOnClickListener {
                name = nameEt.text.toString()
                lastName = lastNameEt.text.toString()

                if (name.trim().isEmpty()) {
                    nameEt.error = "name is empty"
                    return@setOnClickListener
                }
                if (lastName.trim().isEmpty()) {
                    lastNameEt.error = "last name is empty"
                    return@setOnClickListener
                }
                 player = Player(name, lastName)
                findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToGameFragment(player))

            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,findNavController()) || super.onOptionsItemSelected(item)

    }
}
