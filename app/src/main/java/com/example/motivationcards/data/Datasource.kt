package com.example.motivationcards.data

import com.example.motivationcards.R
import com.example.motivationcards.module.Affirmation

class Datasource {
    fun loadAffirmations() :List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.card1, R.drawable.image1),
            Affirmation(R.string.card2, R.drawable.image2),
            Affirmation(R.string.card3, R.drawable.image3),
            Affirmation(R.string.card4, R.drawable.image4),
            Affirmation(R.string.card5, R.drawable.image5),
            Affirmation(R.string.card6, R.drawable.image6),
            Affirmation(R.string.card7, R.drawable.image7),
            Affirmation(R.string.card8, R.drawable.image8),
            Affirmation(R.string.card9, R.drawable.image9),
            Affirmation(R.string.card10, R.drawable.image10),
            Affirmation(R.string.card11, R.drawable.image11),
            Affirmation(R.string.card12, R.drawable.image12),
            Affirmation(R.string.card13, R.drawable.image13),
            Affirmation(R.string.card14, R.drawable.image14)
        )
    }
}