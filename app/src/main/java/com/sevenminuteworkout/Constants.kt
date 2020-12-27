package com.sevenminuteworkout

class Constants {
 companion object {

    // The drawable images used here are added in the drawable folder.
    /**
     * Here we are adding all exercises to a single list with all the default values.
     */
    fun defaultExerciseList(): ArrayList<ExerciseModel> {

        val exerciseList = ArrayList<ExerciseModel>()

        val jumpingJacks =
                ExerciseModel(1, "Jumping Jacks", R.drawable.jumpingjacks, false, false)
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(2, "Wall Sit", R.drawable.waalsit, false, false)
        exerciseList.add(wallSit)

        val pushUp = ExerciseModel(3, "Push Up", R.drawable.pushup, false, false)
        exerciseList.add(pushUp)

        val abdominalCrunch =
                ExerciseModel(4, "Abdominal Crunch", R.drawable.abdominalcrunch, false, false)
        exerciseList.add(abdominalCrunch)

        val stepUpOnChair =
                ExerciseModel(
                        5,
                        "Step-Up onto Chair",
                        R.drawable.stepupnchair,
                        false,
                        false
                )
        exerciseList.add(stepUpOnChair)

        val squat = ExerciseModel(6, "Squat", R.drawable.armtanding, false, false)
        exerciseList.add(squat)

        val tricepDipOnChair =
                ExerciseModel(
                        7,
                        "Tricep Dip On Chair",
                        R.drawable.tricepdip,
                        false,
                        false
                )
        exerciseList.add(tricepDipOnChair)

        val plank = ExerciseModel(8, "Plank", R.drawable.plank, false, false)
        exerciseList.add(plank)

        val highKneesRunningInPlace =
                ExerciseModel(
                        9, "High Knees Running In Place",
                        R.drawable.highknees,
                        false,
                        false
                )
        exerciseList.add(highKneesRunningInPlace)

        val lunges = ExerciseModel(10, "Lunges", R.drawable.lunges, false, false)
        exerciseList.add(lunges)

        val pushupAndRotation =
                ExerciseModel(
                        11,
                        "Push up and Rotation",
                        R.drawable.rp,
                        false,
                        false
                )
        exerciseList.add(pushupAndRotation)

        val sidePlank = ExerciseModel(12, "Side Plank", R.drawable.sideplant, false, false)
        exerciseList.add(sidePlank)

        return exerciseList
    }
}
}
