package com.jjp.petsitter.animals.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjp.petsitter.App
import com.jjp.petsitter.R
import com.jjp.petsitter.animals.dagger.AnimalsComponent
import com.jjp.petsitter.animals.ui.description.AnimalDescriptionFragment
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel
import com.jjp.petsitter.animals.ui.list.adapter.AnimalsAdapter
import com.jjp.petsitter.animals.ui.list.adapter.AnimalsItemDecoration
import kotlinx.android.synthetic.main.fragment_animals.*
import javax.inject.Inject

class AnimalsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var animalsViewModel: AnimalsViewModel

    private lateinit var animalsAdapter: AnimalsAdapter

    private val animalsObserver = Observer<List<AnimalUiModel>> { animals ->
        setAnimals(animals)
    }

    private val errorObserver = Observer<String?> { error ->
        showError(error ?: getString(R.string.error))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AnimalsComponent
            .create((requireActivity().application as App).getAppComponent())
            .inject(this)

        animalsViewModel =
            ViewModelProviders.of(this, viewModelFactory)[AnimalsViewModel::class.java]
        return inflater.inflate(R.layout.fragment_animals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        animalsViewModel.animals.observe(viewLifecycleOwner, animalsObserver)
        animalsViewModel.error.observe(viewLifecycleOwner, errorObserver)
        animalsViewModel.loadAnimals()
    }

    private fun initAdapter() {
        animalsAdapter = AnimalsAdapter(this::onAnimalClicked)
        animalsRecycler.layoutManager = LinearLayoutManager(context)
        animalsRecycler.addItemDecoration(AnimalsItemDecoration(requireContext()))
        animalsRecycler.adapter = animalsAdapter
    }

    private fun onAnimalClicked(animal: AnimalUiModel) {
        val bundle = Bundle().apply {
            putLong(AnimalDescriptionFragment.ANIMAL_ID_KEY, animal.id)
        }
        view?.findNavController()?.navigate(R.id.navigation_from_animals_to_animal, bundle)
    }

    private fun setAnimals(animals: List<AnimalUiModel>) {
        animalsAdapter.setItems(animals)
    }

    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
