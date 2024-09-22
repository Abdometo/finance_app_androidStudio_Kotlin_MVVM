package com.example.myapplication.Repository

import com.example.myapplication.Adapter.BudgetDomain
import com.example.myapplication.domain.ExpensesDomain

class MainRepository {

    val items = mutableListOf(
        ExpensesDomain("Resturant",573.12,"img1","17 jun 2024 19:15") ,
        ExpensesDomain("Resturant",573.12,"img1","17 jun 2024 19:15") ,
        ExpensesDomain("Resturant",573.12,"img1","17 jun 2024 19:15") ,
        ExpensesDomain("Resturant",573.12,"img1","17 jun 2024 19:15")
    )

    val budget = mutableListOf(
        BudgetDomain("Home Loan",1200.0,80.0),
        BudgetDomain("Home Loan",1200.0,80.0),
        BudgetDomain("Home Loan",1200.0,80.0)
    )
}