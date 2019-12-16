package net.projectmovies.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import net.projectmovies.R
import net.projectmovies.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MenuFragmentBinding>(inflater,
            R.layout.menu_fragment,container,false)

        binding.movieButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_moviesFragment)
        }
        setHasOptionsMenu(true)

        binding.postsButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_postsFragment)
        }
        setHasOptionsMenu(true)

        binding.cinemaButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_cinemaActivity)
        }
        setHasOptionsMenu(true)

        binding.shopButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_shopActivity)
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
