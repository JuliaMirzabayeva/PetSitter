package com.jjp.petsitter.animals.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jjp.petsitter.App
import com.jjp.petsitter.R
import com.jjp.petsitter.animals.dagger.AnimalsComponent
import kotlinx.android.synthetic.main.fragment_animal_description.*

class AnimalDescriptionFragment : Fragment() {

    private lateinit var animalDescriptionViewModel: AnimalDescriptionViewModel

    private val animalObserver = Observer<AnimalDescriptionUiModel> { animal ->
        setAnimal(animal)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        animalDescriptionViewModel =
                ViewModelProviders.of(this).get(AnimalDescriptionViewModel::class.java)
        AnimalsComponent.create((requireActivity().application as App).getAppComponent()).inject(this)
        return inflater.inflate(R.layout.fragment_animal_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animalDescriptionViewModel.animal.observe(viewLifecycleOwner, animalObserver)

        if (savedInstanceState == null) {
            arguments?.getLong(ANIMAL_ID_KEY)?.let(animalDescriptionViewModel::setAnimal)
        }
    }

    private fun setAnimal(animal: AnimalDescriptionUiModel) {
        animalName.text = animal.name
    }

    companion object {
        const val ANIMAL_ID_KEY = "id"
    }
}
