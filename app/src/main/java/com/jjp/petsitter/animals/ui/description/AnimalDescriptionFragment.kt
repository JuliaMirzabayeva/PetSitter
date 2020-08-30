package com.jjp.petsitter.animals.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jjp.petsitter.App
import com.jjp.petsitter.R
import com.jjp.petsitter.animals.dagger.AnimalsComponent
import kotlinx.android.synthetic.main.fragment_animal_description.*
import javax.inject.Inject

class AnimalDescriptionFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var animalDescriptionViewModel: AnimalDescriptionViewModel

    private val animalObserver = Observer<AnimalDescriptionUiModel> { animal ->
        setAnimal(animal)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AnimalsComponent
            .create((requireActivity().application as App).getAppComponent())
            .inject(this)

        animalDescriptionViewModel =
            ViewModelProviders.of(this, viewModelFactory)[AnimalDescriptionViewModel::class.java]
      return inflater.inflate(R.layout.fragment_animal_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animalDescriptionViewModel.animal.observe(viewLifecycleOwner, animalObserver)

        if (savedInstanceState == null) {
            arguments?.getLong(ANIMAL_ID_KEY)?.let(animalDescriptionViewModel::setAnimal)
        }

        animalToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setAnimal(animal: AnimalDescriptionUiModel) {
        animalIcon.setImageResource(animal.icon)
        animalName.text = animal.name
        animalDescription.text = animal.description
    }

    companion object {
        const val TAG = "animal_description_fragment"
        private const val ANIMAL_ID_KEY = "id"

        fun createNewInstance(animalId: Long): AnimalDescriptionFragment {
            return AnimalDescriptionFragment().apply {
                arguments = bundleOf(ANIMAL_ID_KEY to animalId)
            }
        }
    }
}
