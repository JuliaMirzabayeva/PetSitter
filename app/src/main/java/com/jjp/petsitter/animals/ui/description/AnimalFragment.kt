package com.jjp.petsitter.animals.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jjp.petsitter.R

class AnimalFragment : Fragment() {

    private lateinit var animalViewModel: AnimalViewModel

    private val animalObserver = Observer<AnimalUiModel> { animal ->
        setAnimal(animal)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        animalViewModel =
                ViewModelProviders.of(this).get(AnimalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animalViewModel.animal.observe(viewLifecycleOwner, animalObserver)
    }

    private fun setAnimal(animal: AnimalUiModel) {
    }
}
