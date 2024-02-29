package com.niallmurph.expensetrackerm3.models

sealed class Recurrence (val name : String, val target : String){

    object None : Recurrence("None", "None")
    object Daily : Recurrence("Daily", "Today")
    object Weekly : Recurrence("Weekly", "This Week")
    object Monthly : Recurrence("Monthly", "This Month")
    object Yearly : Recurrence("Yearly", "This Year")

}

