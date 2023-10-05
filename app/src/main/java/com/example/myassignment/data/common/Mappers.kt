package com.example.myassignment.data.common

import com.example.myassignment.data.model.CountriesDTO
import com.example.myassignment.data.model.DataDTO
import com.example.myassignment.domain.model.Countries
import com.example.myassignment.domain.model.Data



fun CountriesDTO.toDomain(): Countries {
    return Countries(
        data = data?.map { it.toDomain() } ?: emptyList(),
        message = message,
        status = status
    )
}

fun DataDTO.toDomain(): Data {
    return Data(
        Abbreviation = Abbreviation,
        CountryId = CountryId,
        Name = Name,
        StateId = StateId
    )
}