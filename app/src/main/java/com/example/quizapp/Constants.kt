package com.example.quizapp

object Constants{

    const val User_Name : String = "user name"
    const val Total_Question :String = "Total Question"
    const val CORRECT_ANSWER :String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1,"What country does this flag belong to?",
        R.drawable.ic_australia,
            "Argentina",
            "Australia",
            "India",
            "Armenia",
            2
        )

        questionsList.add(que1)


        val que2 = Question(2,"What country does this flag belong to?",
            R.drawable.ic_argentina,
            "Argentina",
            "Bangladesh",
            "Brazil",
            "Armenia",
            1
        )

        questionsList.add(que2)


        val que3 = Question(3,"What country does this flag belong to?",
            R.drawable.ic_england,
            "Argentina",
            "Australia",
            "England",
            "Armenia",
            3
        )

        questionsList.add(que3)


        val que4 = Question(4,"What country does this flag belong to?",
            R.drawable.ic_bangladesh,
            "Bangladesh",
            "Australia",
            "Iceland",
            "Brazil",
            1
        )

        questionsList.add(que4)

        val que5 = Question(5,"What country does this flag belong to?",
            R.drawable.ic_ireland,
            "Ireland",
            "Australia",
            "South Africa",
            "India",
            1
        )

        questionsList.add(que5)

        val que6 = Question(1,"What country does this flag belong to?",
            R.drawable.ic_icelandflag,
            "Bangladesh",
            "Australia",
            "Iceland",
            "India",
            3
        )

        questionsList.add(que6)

        val que7 = Question(1,"What country does this flag belong to?",
            R.drawable.ic_newzealand,
            "Argentina",
            "New Zealand",
            "India",
            "Brazil",
            2
        )

        questionsList.add(que7)
        val que8 = Question(1,"What country does this flag belong to?",
            R.drawable.ic_indiaflag,
            "Argentina",
            "England",
            "India",
            "Armenia",
            3
        )

        questionsList.add(que8)

        val que9 = Question(1,"What country does this flag belong to?",
            R.drawable.ic_brazil,
            "Brazil",
            "Australia",
            "Bangladesh",
            "Argentina",
            1
        )

        questionsList.add(que9)

        val que10 = Question(1,"What country does this flag belong to?",
            R.drawable.ic_southafrica,
            "Australia",
            "Brazil",
            "India",
            "South Africa",
            4
        )

        questionsList.add(que10)

        return questionsList
    }
}