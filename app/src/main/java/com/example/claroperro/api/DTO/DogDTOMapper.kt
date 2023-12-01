package com.example.claroperro.api.DTO

import com.example.claroperro.Dog

class DogDTOMapper {
    private fun fromDogDTOToDogDomain(dogDTO: DogDTO) : Dog {

        return Dog(
            dogDTO.id,
            dogDTO.name,
            dogDTO.origin,
            dogDTO.intelligence,
            dogDTO.strangerFriendly,
            dogDTO.description,
            dogDTO.lifeSpan,
            dogDTO.temperament,
            dogDTO.childFriendly,
            dogDTO.wiki,
            dogDTO.countryCode,
            dogDTO.imgId

        )
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDTO>):List<Dog>{
        return dogDTOList.map { fromDogDTOToDogDomain(it)}
    }
}
